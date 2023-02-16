package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.dto.MemberDto;
import com.wheogus.MyShoppingMall.entity.Member;
import com.wheogus.MyShoppingMall.repository.MemberRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import com.wheogus.MyShoppingMall.service.JwtServiceImpl;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private MemberRepository memberRepository;


    //로그인
    @PostMapping("/shop/account/login")
    public ResponseEntity login(@RequestBody MemberDto dto, HttpServletResponse res) {
        String email = dto.getEmail();
        String pwd = dto.getPwd();
        log.info("email = " + email);
        log.info("pwd = " + pwd);

        Member member = memberRepository.findByEmailAndPwd(email, pwd);
        log.info("member = " + member);


        if (member != null) {
            int id = member.getId();
            String token = jwtService.getToken("id", id);
            log.info("token = " + token);

            Cookie cookie = new Cookie("token", token);
            log.info("cookie = "+ cookie );

            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);
            return ResponseEntity.ok().build();

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //로그아웃
    @PostMapping("/shop/account/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인 체크
    @GetMapping("/shop/account/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);

        log.info("claims = "+ claims);
        if (claims != null) {
            int id = Integer.parseInt(claims.get("id").toString());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
