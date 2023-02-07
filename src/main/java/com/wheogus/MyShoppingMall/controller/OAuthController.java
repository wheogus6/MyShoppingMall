package com.wheogus.MyShoppingMall.controller;

import com.mashape.unirest.http.Unirest;
import com.wheogus.MyShoppingMall.entity.OauthToken;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    // 클라이언트가 구현해야하는 코드 - 발급 받은 코드로 토큰 발행
    @RequestMapping("/callback")
    public OauthToken.response code(@RequestParam String code) throws Exception{
        String cridentials = "clientId:secretKey";
        // base 64로 인코딩
        String encodingCredentials = new String(
                Base64.encodeBase64(cridentials.getBytes())
        );
        String requestCode = code;
        OauthToken.request.accessToken request = new OauthToken.request.accessToken(){{
            setCode(requestCode);
            setGrant_type("authorization_code");
            setRedirect_uri("http://localhost:8080/callback");
        }};

    // oauth 서버에 http 통신으로 토큰 발행
        OauthToken.response oauthToken = Unirest.post("http://localhost:8080/oauth/token")
                .header("Autorization", "Basic " + encodingCredentials).fields(request.getMapData())
                .asObject(OauthToken.response.class).getBody();
        return oauthToken;
    }
}
