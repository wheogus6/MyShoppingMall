package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.entity.Member;
import com.wheogus.MyShoppingMall.repository.MemberRepository;
import com.wheogus.MyShoppingMall.service.JwtService;
import com.wheogus.MyShoppingMall.service.JwtServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private MemberRepository memberRepository;

//    @PostMapping("/shop/account/login")
//    public int login(@RequestBody Map<String, String> params) {
//        Member member = memberRepository.findByEmailAndPwd(params.get("email"), params.get("pwd"));
//        if (member != null) {
//        return member.getId();
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }

//    @PostMapping("/shop/account/login/{email}/{pwd}")
//    public int login(@PathVariable String email, @PathVariable String pwd) {
//        Member member = memberRepository.findByEmailAndPwd(email, pwd);
//        if (member != null) {
//            return member.getId();
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/shop/account/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
        Member member = memberRepository.findByEmailAndPwd(params.get("email"), params.get("pwd"));
        if (member != null) {
            int id = member.getId();
            String token = jwtService.getToken("id", id);
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);
            return ResponseEntity.ok().build();

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/shop/account/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/shop/account/login")
//    public ResponseEntity login(@PathVariable String email, @PathVariable String pwd, HttpServletResponse res) {
//        Member member = memberRepository.findByEmailAndPwd(email, pwd);
//        if (member != null) {
//            JwtService jwtService = new JwtServiceImpl();
//            int id = member.getId();
//            String token = jwtService.getToken("id", id);
//            Cookie cookie = new Cookie("token", token);
//            cookie.setHttpOnly(true);
//            cookie.setPath("/");
//
//            res.addCookie(cookie);
//            return ResponseEntity.ok().build();
//
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }

    @GetMapping("/shop/account/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);

        if (claims != null) {
            int id = Integer.parseInt(claims.get("id").toString());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
