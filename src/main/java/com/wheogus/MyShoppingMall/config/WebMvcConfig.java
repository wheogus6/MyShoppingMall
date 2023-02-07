package com.wheogus.MyShoppingMall.config;

import com.wheogus.MyShoppingMall.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {

    // Bean에 등록하여 직접 구현한 서비스를 기본 서비스로 사용


    @Bean
    public UserDetailService userDetailService() {
        return new UserDetailService();
    }

}
