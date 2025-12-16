package org.zerock.yesyes2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

    @GetMapping("/member/mypage")
    public String mypageView(HttpSession session) {
        String userId = (String) session.getAttribute("user_id");

        if (userId == null) {
            // 로그인되어 있지 않으면 로그인 페이지로 리다이렉션
            return "redirect:/member/login";
        }
        // 로그인되어 있으면 마이페이지 뷰를 반환 (WEB-INF/views/mypage.jsp)
        return "mypage";
    }
}
