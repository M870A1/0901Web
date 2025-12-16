package org.zerock.yesyes2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.zerock.yesyes2.membership.MemberDTO;
import org.zerock.yesyes2.membership.MemberService;
import org.zerock.yesyes2.utils.CookieManager;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/login")
    public String loginForm(@RequestParam(value = "loginId", required = false) String loginId, Model model) {
        return "login";
    }

    @PostMapping("/member/login")
    public String loginProcess(@RequestParam("username") String id,
                               @RequestParam("password") String pass,
                               @RequestParam(value = "save_check", required = false) String saveCheck,
                               HttpSession session,
                               HttpServletResponse resp, // CookieManager 사용을 위해 필요
                               RedirectAttributes redirectAttributes) {

        MemberDTO memberDTO = memberService.login(id, pass);

        if (memberDTO != null) {
            session.setAttribute("user_id", memberDTO.getId());
            session.setAttribute("user_name", memberDTO.getName());

            if ("on".equals(saveCheck)) {
                CookieManager.makeCookie(resp, "loginId", id, 86400); // 24시간
            } else {
                CookieManager.deleteCookie(resp, "loginId");
            }
            
            return "redirect:/"; // 메인 페이지로 리다이렉트
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "아이디 또는 비밀번호를 잘못 입력하셨습니다.");
            return "redirect:/member/login"; // 로그인 페이지로 리다이렉트 (에러 메시지 포함)
        }
    }
}

