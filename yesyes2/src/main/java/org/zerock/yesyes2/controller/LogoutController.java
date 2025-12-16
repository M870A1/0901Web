package org.zerock.yesyes2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        // 세션 가져오기 (Spring이 자동으로 주입해줌)
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        
        // 메인 페이지 또는 로그인 페이지로 리디렉션
        return "redirect:/member/login"; // Spring MVC에서 리다이렉트 처리
    }
}