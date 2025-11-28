package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 가져오기
        HttpSession session = req.getSession(false); // 세션이 없으면 새로 생성하지 않음
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        
        // 메인 페이지 또는 로그인 페이지로 리디렉션
        resp.sendRedirect(req.getContextPath() + "/member/login.do"); 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); // POST 요청도 GET과 동일하게 처리
    }
}