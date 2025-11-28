package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import membership.MemberDTO;
import membership.MemberService;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberService memberService;

    @Override
    public void init() throws ServletException {
        memberService = new MemberService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 회원가입 페이지로 이동
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // register.jsp에서 넘어온 파라미터로 DTO 채우기
        MemberDTO dto = new MemberDTO();
        dto.setId(req.getParameter("regId"));
        dto.setPass(req.getParameter("regPassword"));
        dto.setName(req.getParameter("regName"));
        dto.setTel(req.getParameter("regPhone"));
        dto.setEmail(req.getParameter("regEmail"));
        dto.setGender(req.getParameter("gender"));
        
        // 생년월일 (DOB) : String을 java.sql.Date로 변환
        String dobStr = req.getParameter("regDob");
        if (dobStr != null && !dobStr.isEmpty()) {
            try {
                dto.setDob(Date.valueOf(dobStr)); // java.sql.Date.valueOf 사용
            } catch (IllegalArgumentException e) {
                // 날짜 형식이 잘못된 경우 처리
                System.out.println("잘못된 날짜 형식입니다: " + dobStr);
                e.printStackTrace();
                req.setAttribute("errorMsg", "날짜 형식이 올바르지 않습니다. (YYYY-MM-DD)");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }
        }
        
        // MemberService를 통해 회원가입 처리
        int result = memberService.register(dto);
        
        if (result == 1) {
            // 회원가입 성공 시 로그인 페이지로 이동
            resp.sendRedirect(req.getContextPath() + "/member/login.do");
        } else {
            // 회원가입 실패 시 다시 회원가입 페이지로 이동
            req.setAttribute("errorMsg", "회원가입에 실패했습니다. 다시 시도해주세요.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
