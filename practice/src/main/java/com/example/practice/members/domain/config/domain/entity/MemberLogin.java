package com.example.practice.members.domain.config.domain.entity;

import com.example.practice.members.domain.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor
public class MemberLogin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    private LocalDateTime createAt;
    private LocalDateTime endAt;

    public MemberLogin(Member member, LocalDateTime createAt) {
        this.id = id;
        this.member = member;
        this.createAt = createAt;
        this.endAt = createAt.plusMinutes(10);
    }
}
