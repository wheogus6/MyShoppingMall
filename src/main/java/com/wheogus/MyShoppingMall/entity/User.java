package com.wheogus.MyShoppingMall.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
// 유저 정보를 조회하는 UserDetails 인터페이스를 상속(spring security 라이브러리 사용시 가능)
@Data
@Entity
public class User implements UserDetails {
    @Id
    @Column
    private String id;

    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String state;
    // Y : 정상 회원 , L : 잠긴 계정, P : 패스워드 만료, A : 계정 만료

    // 권한 (기본 권한 셋팅)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.id;
    }
    // 계정 만료 A
    @Override
    public boolean isAccountNonExpired() {
        if (StringUtils.equalsAnyIgnoreCase(state, "A")){
            return false;
        }
        return true;
    }
    // 계정 잠김 L
    @Override
    public boolean isAccountNonLocked() {
        if (StringUtils.equalsAnyIgnoreCase(state, "L"))
        {return false;
    }
        return true;
    }
    // 패스워드 만료 P
    @Override
    public boolean isCredentialsNonExpired() {
       if (StringUtils.equalsAnyIgnoreCase(state, "P")){
           return false;
       }
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (isCredentialsNonExpired() && isAccountNonExpired() && isAccountNonLocked()){
            return true;
            // 위 3개 함수가 전부 true라면 true
        }
        return false;
    }
}
