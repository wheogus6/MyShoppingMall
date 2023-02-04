package com.wheogus.MyShoppingMall.config;


import com.wheogus.MyShoppingMall.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        // .authorizeRequests() → .authorizeHttpRequests()
        // .antMatchers() → .requestMatchers()
        // .access("hasAnyRole('ROLE_A','ROLE_B')") → .hasAnyRole("A", "B")
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("login").permitAll()
                .requestMatchers("user").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/").permitAll()
                .and()
                .oauth2Login().loginPage("/login")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        return httpSecurity.build();
    }
}
