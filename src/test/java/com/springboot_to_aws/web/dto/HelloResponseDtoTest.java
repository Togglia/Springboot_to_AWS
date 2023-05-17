package com.springboot_to_aws.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

    @Test
    public void lombok_func_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  //테스트 검증 라이브러리의 검증 메소드 , 동등비교 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
