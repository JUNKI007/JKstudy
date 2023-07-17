package com.example.test20230717.member.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime loginExpiresAt;

//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<MemberHobby> hobbies;
}
