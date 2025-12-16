package org.zerock.yesyes2.controller;

import jakarta.servlet.ServletContext;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.zerock.yesyes2.VO.BoardVO; // BoardVO 임포트

import org.zerock.yesyes2.board.BoardService;

import org.zerock.yesyes2.utils.BoardPage;

import org.zerock.yesyes2.utils.JSFunction; // JSFunction은 클라이언트 사이드 스크립트 처리 방식으로 변경 필요


import java.io.IOException;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

@Controller

public class BoardController {

    @Autowired

    private BoardService boardService;

    @Autowired

    // ServletContext를 Spring에서 주입받아 사용
    private ServletContext application;


    @GetMapping("/board/list")

    public String list(Model model,

                       @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,

                       @RequestParam(value = "searchField", required = false) String searchField,

                       @RequestParam(value = "searchWord", required = false) String searchWord) {


        int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));

        int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));


        Map<String, Object> param = new HashMap<>();

        if (searchWord != null && !searchWord.trim().equals("")) {

            param.put("searchField", searchField);

            param.put("searchWord", searchWord);

        }


        int totalCount = boardService.selectCount(param);


        param.put("offset", (pageNum - 1) * pageSize);
        param.put("pageSize", pageSize);


        List<BoardVO> boardList = boardService.getBoardList(param);


        String pagingImg = BoardPage.pagingStr(totalCount, pageSize,

                blockPage, pageNum, "/board/list");


        model.addAttribute("boardList", boardList);

        model.addAttribute("pagingImg", pagingImg);

        model.addAttribute("totalCount", totalCount);

        model.addAttribute("pageSize", pageSize);

        model.addAttribute("pageNum", pageNum);

        model.addAttribute("searchField", searchField);

        model.addAttribute("searchWord", searchWord);

        return "board/list";

    }

    @GetMapping("/board/view")

    public String view(@RequestParam("num") int num, Model model) {

        BoardVO post = boardService.getBoard(num); // BoardDTO -> BoardVO 변경

        model.addAttribute("post", post);

        return "board/view";

    }

    @GetMapping("/board/write")

    public String writeForm(HttpSession session, RedirectAttributes redirectAttributes) {
        String userId = (String) session.getAttribute("user_id");
        if (userId == null) {
            redirectAttributes.addFlashAttribute("alertMessage", "로그인 후 이용해주세요.");
            return "redirect:/member/login";
        }
        return "board/write"; // /WEB-INF/views/board/write.jsp 로 포워딩
    }

    @PostMapping("/board/write")

    public String writeProcess(@RequestParam("title") String title,

                               @RequestParam("content") String content,

                               HttpSession session, RedirectAttributes redirectAttributes) {

        String userId = (String) session.getAttribute("user_id");

        String userName = (String) session.getAttribute("user_name");

        if (userId == null) {

            redirectAttributes.addFlashAttribute("alertMessage", "로그인 후 이용해주세요.");

            return "redirect:/member/login";

        }
        BoardVO vo = BoardVO.builder()
                .title(title)
                .content(content)
                .author(userName)
                .id(userId)
                .build();

        int result = boardService.writeBoard(vo);

        if (result > 0) {

            return "redirect:/board/list";

        } else {

            redirectAttributes.addFlashAttribute("alertMessage", "글쓰기에 실패했습니다.");

            return "redirect:/board/write";

        }

    }

    @GetMapping("/board/edit")

    public String editForm(@RequestParam("num") int num, HttpSession session, Model model, RedirectAttributes redirectAttributes) {

        String userId = (String) session.getAttribute("user_id");

        BoardVO post = boardService.getBoard(num);

        if (userId == null || !userId.equals(post.getId())) {

            redirectAttributes.addFlashAttribute("alertMessage", "작성자 본인만 수정할 수 있습니다.");

            return "redirect:/board/view?num=" + num;

        }

        model.addAttribute("post", post);

        return "board/edit";

    }

    @PostMapping("/board/edit")

    public String editProcess(BoardVO vo, HttpSession session, RedirectAttributes redirectAttributes) {

        String userId = (String) session.getAttribute("user_id");

        if (userId == null) {
            redirectAttributes.addFlashAttribute("alertMessage", "로그인 후 이용해주세요.");
            return "redirect:/member/login";
        }

        BoardVO originalPost = boardService.getBoard(vo.getNum());

        if (!userId.equals(originalPost.getId())) {

            redirectAttributes.addFlashAttribute("alertMessage", "작성자 본인만 수정할 수 있습니다.");

            return "redirect:/board/view?num=" + vo.getNum();

        }

        int result = boardService.updateBoard(vo);

        if (result > 0) {
            return "redirect:/board/view?num=" + vo.getNum();
        } else {
            redirectAttributes.addFlashAttribute("alertMessage", "글 수정에 실패했습니다.");
            return "redirect:/board/edit?num=" + vo.getNum();
        }
    }

    @PostMapping("/board/delete")

    public String deleteProcess(@RequestParam("num") int num, HttpSession session, RedirectAttributes redirectAttributes) {
        String userId = (String) session.getAttribute("user_id");

        if (userId == null) {

            redirectAttributes.addFlashAttribute("alertMessage", "로그인 후 이용해주세요.");

            return "redirect:/member/login";
        }
        BoardVO post = boardService.getBoard(num);

        if (!userId.equals(post.getId())) {
            redirectAttributes.addFlashAttribute("alertMessage", "작성자 본인만 삭제할 수 있습니다.");
            return "redirect:/board/view?num=" + num;
        }

        int result = boardService.deleteBoard(num);

        if (result > 0) {

            redirectAttributes.addFlashAttribute("alertMessage", "게시글이 삭제되었습니다.");

            return "redirect:/board/list";

        } else {

            redirectAttributes.addFlashAttribute("alertMessage", "게시글 삭제에 실패했습니다.");

            return "redirect:/board/view?num=" + num;

        }

    }

}