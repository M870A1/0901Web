package action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class RegisterAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // 파라미터 받기
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String passConfirm = request.getParameter("passConfirm");
        String name = request.getParameter("name");

        //  유효성 검사
        if (id == null || id.isEmpty()) {
            request.setAttribute("errorMessage", "아이디를 입력해주세요.");
            return "/register.jsp";
        }

        if (pass == null || pass.isEmpty()) {
            request.setAttribute("errorMessage", "비밀번호를 입력해주세요.");
            return "/register.jsp";
        }

        if (passConfirm == null || passConfirm.isEmpty()) {
            request.setAttribute("errorMessage", "비밀번호 확인란을 입력해주세요.");
            return "/register.jsp";
        }

        if (!pass.equals(passConfirm)) {
            request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "/register.jsp";
        }

        if (name == null || name.isEmpty()) {
            request.setAttribute("errorMessage", "이름을 입력해주세요.");
            return "/register.jsp";
        }

        //  회원가입 처리 (Service 사용)
        MemberService service = new MemberService();
        boolean isRegistered;

        try {
            isRegistered = service.registerMember(id, pass, name);  
            // registerMember는 DAO를 호출하는 메서드라고 가정
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "회원가입 중 오류가 발생했습니다. (아이디 중복 가능)");
            return "/register.jsp";
        }

        // 성공 시 로그인 페이지로 이동
        if (isRegistered) {
            request.setAttribute("registerMsg", "회원가입이 완료되었습니다. 로그인 해주세요.");
            return "/login.jsp";
        } else {
            request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "/register.jsp";
        }
    }
}
