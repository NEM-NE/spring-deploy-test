package dev.nemne.book.spring.web;

import dev.nemne.book.spring.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킴 / 스프링과 Junit 사이를 연결
@WebMvcTest(controllers = HelloController.class) // spring mvc에 집중할 수 잇는 어노테이션 / Controller, advicecontroller 등을 사용가능
public class HelloControllerTest {

    @Autowired // 빈 주입
    private MockMvc mvc; //web api를 테스트할 때 사용 / 엔트리 포인트

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void hello_dto_테스트() throws Exception{
        //given
        String name = "sungbin";
        int amount = 1000;


        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // json 응답값을 필드 별로 검증할 수 있는 메서드
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}