package com.example.test20230717.member.repository;

import com.example.test20230717.member.domain.entity.MemberLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberLoginRepository extends JpaRepository<MemberLogin, Long> {
    Optional<MemberLogin> findByMemberId(Long memberId);
}
