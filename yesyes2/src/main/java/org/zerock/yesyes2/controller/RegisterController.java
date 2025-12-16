package org.zerock.yesyes2.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.yesyes2.membership.MemberDTO;
import org.zerock.yesyes2.membership.MemberService;

@Controller
public class RegisterController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/register")
    public String registerForm() {
        // 회원가입 페이지로 이동
        return "register";
    }

    @PostMapping("/member/register")
    public String registerProcess(MemberDTO dto,
                                  @RequestParam("regDob") String dobStr,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {

        if (dobStr != null && !dobStr.isEmpty()) {
            try {
                dto.setDob(Date.valueOf(dobStr));
            } catch (IllegalArgumentException e) {
                // 날짜 형식이 잘못된 경우 처리
                System.out.println("잘못된 날짜 형식입니다: " + dobStr);
                e.printStackTrace();
                model.addAttribute("errorMsg", "날짜 형식이 올바르지 않습니다. (YYYY-MM-DD)");
                return "register"; // 에러 메시지와 함께 회원가입 폼으로 돌아감
            }
        }
        
        // MemberService를 통해 회원가입 처리
        int result = memberService.register(dto);
        
        if (result == 1) {
            // 회원가입 성공 시 로그인 페이지로 이동
            return "redirect:/member/login";
        } else {
            // 회원가입 실패 시 다시 회원가입 페이지로 이동
            redirectAttributes.addFlashAttribute("errorMsg", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/member/register"; // 에러 메시지와 함께 리다이렉트
        }
    }
}
