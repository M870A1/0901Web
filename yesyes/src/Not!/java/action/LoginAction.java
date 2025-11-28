package action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import membership.MemberDTO;
import service.MemberService;

public class LoginAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 서비스 객체 생성
        MemberService service = new MemberService();

        // 로그인 폼에서 아이디와 패스워드 받기
        String id = request.getParameter("userId");
        String pass = request.getParameter("userPw");

        // 서비스의 로그인 메서드 호출
        MemberDTO dto = service.getMember(id, pass);

        // 로그인 성공/실패에 따른 처리
        if (dto != null && dto.getId() != null) {
            System.out.println("로그인 성공");

            // 세션에 로그인 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("userId", dto.getId());
            session.setAttribute("userName", dto.getName());

            // 메인 페이지로 이동 
            response.sendRedirect("/main");
            return null;
        } else {
            System.out.println("로그인 실패");

            // 실패 메시지를 request에 저장
            request.setAttribute("loginError", "아이디나 비밀번호가 틀렸습니다.");
            return "/login.jsp";
        }
    }
}
