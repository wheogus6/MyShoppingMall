package com.wheogus.MyShoppingMall.config;

// AuthorizationServerConfigurerAdapter 상속으로 매개변수만 다른 오버로딩 함수인 configure가 존재하고, security, client, endpoints를 사용 가능.
import com.wheogus.MyShoppingMall.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@EnableAuthorizationServer
@Configuration
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailService userDetailService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() //클라이언트 정보 = 메모리
                .withClient("clientId")  //클라 아이디
                .secret("{noop}secretKey")  // 시크릿키 ({} 안에 암호화 알고리즘 명시 하면된다. 암호화 되어 있지 않다면 {noop}로 설정 해야 한다. 실제 요청은 암호화 방식인 {noop}를 입력 하지 않아도 된다.)
                .authorizedGrantTypes("authorization_code", "passwoed", "refresh_token") // 가능한 토큰 발행 타입
                .scopes("read", "write") // 가능한 접근 범위
                .accessTokenValiditySeconds(60) // 토큰 유효 시간 : 1분
                .refreshTokenValiditySeconds(60 * 60) // 리프레시 토큰 유효 시간 : 1시간
                .redirectUris("http://localhost:8080/callback") // 가능한 redirect uri
                .autoApprove(true); // 권한 동의는 자동으로 yes (false 로 할시 권한 동의 여부를 묻는다.)
    }

    // 인증, 토큰 설정
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userDetailService);
        // refrash token 발생시 유저 정보 검사에 사용하는 서비스 설정
    }
}
