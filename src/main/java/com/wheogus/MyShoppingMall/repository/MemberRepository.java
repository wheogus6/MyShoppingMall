package com.wheogus.MyShoppingMall.repository;

import com.wheogus.MyShoppingMall.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByEmailAndPwd(String email, String pwd);
}
