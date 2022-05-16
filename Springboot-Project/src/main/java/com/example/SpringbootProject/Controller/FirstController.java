package com.example.SpringbootProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PublicKey;

//1.Controller 설정
@Controller
public class FirstController {

    @GetMapping("/hi") //3. Getmappring하여 접속 url 만들기
    public String niceToMeetyou(Model model){
        model.addAttribute("username","ju0");
        return "greetings";//2.리턴값으로 보여줄 패이지의 이름을 리턴하기
        //templates/greetings.muctache ->브라우저로 전송
    }
}
