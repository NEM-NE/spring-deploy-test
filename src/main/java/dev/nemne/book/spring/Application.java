package dev.nemne.book.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //스프링 부트의 자동 설정, 스프링 bean 읽기와 생성 모두 자동으로 설정 / 엔트리 포인트이기 때문에 최상단에 위치
public class Application {
    public static void main(String[] args) {
        // 별도로 외부에 WAS를 설치 하지 않아도 스프링 부트로 만들어진 Jar파일을 실행하면된다.
        SpringApplication.run(Application.class, args);
        System.out.println("hi");
    }
}
