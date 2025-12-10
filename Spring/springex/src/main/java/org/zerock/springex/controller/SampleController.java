package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    // GET 요청 처리
    @GetMapping("/hello")
    public void hello() {
        log.info("hello");
    }

    // POST 요청 처리
    @PostMapping("/hello")
    public void helloPost() {
        log.info("helloPost");
    }

    // 파라미터를 받아서 출력
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("name : " + name);
        log.info("age : " + age);
    }

    // 파라미터 기본값을 설정
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "30") int age) {
        log.info("name : " + name);
        log.info("age : " + age);
    }

    // LocalDate 파라미터 자동 변환
    @GetMapping("/ex3")
    public void ex3(LocalDate localDate) {
        log.info("LocalDate : " + localDate);
    }

    // 모델에 데이터를 전달
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("ex4 model test ........");
        String message = "화면으로 데이터를 전달하는 메시지";
        model.addAttribute("message", message);
    }

    // 리다이렉트 및 파라미터 전달
    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        log.info("ex5 redirect test ........");
        // 파라미터를 전달
        redirectAttributes.addAttribute("name", "hong");
        // 일회용 데이터 전달
        redirectAttributes.addFlashAttribute("age", "20");
        // 리다이렉트 주소 지정
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(String name) {
        log.info("name : " + name);
    }@GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1 : " + p1);
        log.info("p2 : " + p2);
    }
}
