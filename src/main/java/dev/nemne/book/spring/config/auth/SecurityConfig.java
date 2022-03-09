package dev.nemne.book.spring.config.auth;

import dev.nemne.book.spring.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()// h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
                .and()
                .authorizeRequests() // URL 별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", // 권한 관리 대상 지정(URL, HTTP 메서드 별로 관리 가능)
                        "/js/**", ".h2-console/**").permitAll() // 전체 열람 가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사람만 가능
                .anyRequest()// 설정 이외 URL 의미
                .authenticated() // 인증된 사용자만 허용
                .and()
                .logout().logoutSuccessUrl("/") // 로그아웃 성공시 해당 URL로 이동
                .and()
                .oauth2Login()
                .userInfoEndpoint() // 로그인 성공 후 사용자 정보를 가져올 때 설정 담당
                .userService(customOAuth2UserService); // 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
    }
}
