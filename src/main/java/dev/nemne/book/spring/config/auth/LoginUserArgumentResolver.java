package dev.nemne.book.spring.config.auth;

import dev.nemne.book.spring.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) { // controller 메서드의 특정 파라미터를 지원하는지 판단한다.
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null; // @LoginUser가 있는지 확인하고
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); // 파라미터 타입이 SessionUser인지도 확인한다

        return isLoginUserAnnotation && isUserClass;
    }

    // 파라미터에서 전달할 객체 생성
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
