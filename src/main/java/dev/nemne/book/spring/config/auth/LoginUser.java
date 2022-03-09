package dev.nemne.book.spring.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션을 생성할 수 있는 위치
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 어노테이션 클래스 생성

}
