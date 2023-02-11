package com.wheogus.MyShoppingMall.controller;

import com.wheogus.MyShoppingMall.entity.Member;
import com.wheogus.MyShoppingMall.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class AccountController {

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

    @PostMapping("/shop/account/login/{email}/{pwd}")
    public int login(@PathVariable String email, @PathVariable String pwd) {
        Member member = memberRepository.findByEmailAndPwd(email, pwd);
        if (member != null) {
            return member.getId();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
