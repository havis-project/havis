package com.havis.common.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer securityCustomizer() {
        return (web) -> web
                .ignoring()
                .requestMatchers(PathRequest
                        .toStaticResources()
                        .atCommonLocations());
    }




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry
                    .requestMatchers("/main/**").authenticated() // 메인홈은 인증된 사용자만 접근 가능
                    .requestMatchers("/member/mypage").authenticated() // 마이페이지는 인증된 사용자만 접근 가능
                    .requestMatchers("/member/edit").authenticated() // 정보수정 페이지는 인증된 사용자만 접근 가능
                    .anyRequest().permitAll();
        }));

        //formLogin 설정
        http.formLogin((formLoginConfigurer -> {
            formLoginConfigurer
                    .loginPage("/auth/login") // 로그인 페이지 (GET)
                    .loginProcessingUrl("/auth/login") // 로그인 처리(POST)
                    .usernameParameter("memberId") // userName으로 전달한 파라미터 설정
                    .passwordParameter("password") // password로 전달할 파라미터 설정
                    .defaultSuccessUrl("/main/home") // 로그인 성공시 이동할 url
                    .permitAll();
        }));

        http.logout(logoutConfigurer -> {
            logoutConfigurer
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/auth/login");
        });

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
