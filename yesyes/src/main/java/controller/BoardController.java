package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.BoardDTO;
import board.BoardService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.BoardPage; 
import utils.JSFunction;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BoardService boardService;

    @Override
    public void init() throws ServletException {
        boardService = new BoardService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String path = req.getContextPath();
        String command = uri.substring(path.length());
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("user_id");

        if (command.equals("/board/list.do")) {
            ServletContext application = getServletContext();
            int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
            int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));

            int pageNum = 1;
            String pageTemp = req.getParameter("pageNum");
            if (pageTemp != null && !pageTemp.equals(""))
                pageNum = Integer.parseInt(pageTemp);

            Map<String, Object> param = new HashMap<>();
            String searchField = req.getParameter("searchField");
            String searchWord = req.getParameter("searchWord");
            if (searchWord != null && !searchWord.trim().equals("")) {
                param.put("searchField", searchField);
                param.put("searchWord", searchWord);
            }

            int totalCount = boardService.selectCount(param);

            param.put("start", (pageNum - 1) * pageSize + 1);
            param.put("end", pageNum * pageSize);

            List<BoardDTO> boardList = boardService.getBoardList(param);

            String pagingImg = BoardPage.pagingStr(totalCount, pageSize,
                    blockPage, pageNum, req.getContextPath() + "/board/list.do");

            req.setAttribute("boardList", boardList);
            req.setAttribute("pagingImg", pagingImg);
            req.setAttribute("totalCount", totalCount);
            req.setAttribute("pageSize", pageSize);
            req.setAttribute("pageNum", pageNum);
            req.setAttribute("searchField", searchField);
            req.setAttribute("searchWord", searchWord);

            req.getRequestDispatcher("/board/list.jsp").forward(req, resp);

        } else if (command.equals("/board/view.do")) {
            int num = Integer.parseInt(req.getParameter("num"));
            BoardDTO post = boardService.getBoard(num);
            req.setAttribute("post", post);
            req.getRequestDispatcher("/board/view.jsp").forward(req, resp);

        } else if (command.equals("/board/write.do")) {
             if (userId == null) {
                JSFunction.alertLocation(resp, "로그인 후 이용해주세요.", req.getContextPath() + "/member/login.do");
                return;
            }
            req.getRequestDispatcher("/board/write.jsp").forward(req, resp);

        } else if (command.equals("/board/edit.do")) {
            int num = Integer.parseInt(req.getParameter("num"));
            BoardDTO post = boardService.getBoard(num);
            
            if (userId == null || !userId.equals(post.getId())) {
                JSFunction.alertBack(resp, "작성자 본인만 수정할 수 있습니다.");
                return;
            }
            
            req.setAttribute("post", post);
            req.getRequestDispatcher("/board/edit.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String path = req.getContextPath();
        String command = uri.substring(path.length());
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("user_id");
        String userName = (String) session.getAttribute("user_name");

        if (command.equals("/board/write.do")) {
            if (userId == null) {
                resp.sendRedirect(req.getContextPath() + "/member/login.do");
                return;
            }

            BoardDTO dto = new BoardDTO();
            dto.setTitle(req.getParameter("title"));
            dto.setContent(req.getParameter("content"));
            dto.setId(userId);
            dto.setAuthor(userName);

            int result = boardService.writeBoard(dto);
            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/board/list.do");
            } else {
                JSFunction.alertBack(resp, "글쓰기에 실패했습니다.");
            }
        } else if (command.equals("/board/edit.do")) {
            if (userId == null) {
                resp.sendRedirect(req.getContextPath() + "/member/login.do");
                return;
            }

            int num = Integer.parseInt(req.getParameter("num"));
            BoardDTO post = boardService.getBoard(num);

            if (!userId.equals(post.getId())) {
                JSFunction.alertBack(resp, "작성자 본인만 수정할 수 있습니다.");
                return;
            }

            BoardDTO dto = new BoardDTO();
            dto.setNum(num);
            dto.setTitle(req.getParameter("title"));
            dto.setContent(req.getParameter("content"));

            int result = boardService.updateBoard(dto);
            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/board/view.do?num=" + num);
            } else {
                JSFunction.alertBack(resp, "글 수정에 실패했습니다.");
            }
        } else if (command.equals("/board/delete.do")) {
            if (userId == null) {
                JSFunction.alertLocation(resp, "로그인 후 이용해주세요.", req.getContextPath() + "/member/login.do");
                return;
            }
            int num = Integer.parseInt(req.getParameter("num"));
            BoardDTO post = boardService.getBoard(num); 

            if (!userId.equals(post.getId())) {
                JSFunction.alertBack(resp, "작성자 본인만 삭제할 수 있습니다.");
                return;
            }

            int result = boardService.deleteBoard(num);
            if (result > 0) {
                JSFunction.alertLocation(resp, "게시글이 삭제되었습니다.", req.getContextPath() + "/board/list.do");
            } else {
                JSFunction.alertBack(resp, "게시글 삭제에 실패했습니다.");
            }
        }
    }
}