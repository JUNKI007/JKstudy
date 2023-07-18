package com.example.practice.members.repository;

import com.example.practice.members.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //select * from members where email =? and password?;
    Optional<Member> findByEmailAndPassword(String email, String password);
}
