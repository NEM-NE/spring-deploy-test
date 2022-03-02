package dev.nemne.book.spring.web.dto;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "Test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getAmount()).isEqualTo(amount); // assertThat이 assertEquals보다 가독성, 실패 메세지, 타입 안정성이 더 좋다
        assertThat(dto.getName()).isEqualTo(name);
    }

}