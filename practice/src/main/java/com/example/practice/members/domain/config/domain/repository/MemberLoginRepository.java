package com.example.practice.members.domain.config.domain.repository;

import com.example.practice.members.domain.config.domain.entity.MemberLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLoginRepository
        extends JpaRepository<MemberLogin, Long> {
}
