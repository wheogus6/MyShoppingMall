package com.wheogus.MyShoppingMall.entity;

import com.wheogus.MyShoppingMall.domain.user.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String email;


//    JPA로 데이터베이스로 저장할 때 Enum 값을 어떤 형태로 저장할지를 결정 (기본 - int로 된 숫자)
//    숫자로 저장되면 데이터베이스로 확인할 때 무슨 코드를 의미하는지 알 수 없으므로 문자열로 저장될 수 있도록 선언
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


}