package com.springboot_to_aws.web;

import com.springboot_to_aws.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
        // 머스테치 스타터 덕분에 컨트롤러에서 문자열 반환 시
        // 앞의 경로와 뒤의 확장자는 자동으로 지정
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
