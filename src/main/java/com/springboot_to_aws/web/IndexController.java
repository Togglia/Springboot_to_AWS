package com.springboot_to_aws.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
        // 머스테치 스타터 덕분에 컨트롤러에서 문자열 반환 시
        // 앞의 경로와 뒤의 확장자는 자동으로 지정
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
