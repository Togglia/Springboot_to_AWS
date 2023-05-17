package com.springboot_to_aws.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // SpringRunner라는 다른 실행자 사용 ,스프링부트 테스트와 Junit사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class,secure = false) // spring MVC에 집중할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 Bean을 주입
    private MockMvc mvc;
    // 웹 API를 테스트할 때 사용,
    // 스프링 MVC 테스트 시작점,
    // HTTP GET,POST API테스트 사용가능

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  //MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // status 가 ok, 200인지 확인
                .andExpect(content().string(hello));    // hello 값이맞는지 검증
    }
    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name",name) //API를 테스트할 떄 사용될 요청 파라미터를 설정. 단 String만 허용
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name",  is(name)))   //JSon 응답값을 필드별로 검증 가능
                .andExpect((ResultMatcher) jsonPath("$.amount", is(amount)));

    }
}

