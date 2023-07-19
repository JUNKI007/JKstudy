package com.example.practice.config.repository;

import com.example.practice.config.domain.entity.MemberLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberLoginRepository
        extends JpaRepository<MemberLogin, Long> {
    Optional<MemberLogin> findFirstByMemberIdOrderByEndAtDesc(Long memberId);
}