package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import membership.MemberDTO;
import membership.MemberService;
import utils.CookieManager;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberService memberService;

    @Override
    public void init() throws ServletException {
        memberService = new MemberService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인 페이지
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 전송된 아이디와 비밀번호를 저장
        String id = req.getParameter("username");
        String pass = req.getParameter("password");
        String saveCheck = req.getParameter("save_check");

        // MemberService를 통해 로그인 처리
        MemberDTO memberDTO = memberService.login(id, pass);

        if (memberDTO != null) {
            // 로그인 성공시
            HttpSession session = req.getSession();
            session.setAttribute("user_id", memberDTO.getId());
            session.setAttribute("user_name", memberDTO.getName());

            // '아이디 저장' 체크박스 처리
            if ("on".equals(saveCheck)) {
                CookieManager.makeCookie(resp, "loginId", id, 86400); // 24시간
            } else {
                CookieManager.deleteCookie(resp, "loginId");
            }
            
            // 메인 페이지로 이동
            resp.sendRedirect("/");
        } else {
            // 로그인 실패
            req.setAttribute("errorMessage", "아이디 또는 비밀번호를 잘못 입력하셨습니다.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
