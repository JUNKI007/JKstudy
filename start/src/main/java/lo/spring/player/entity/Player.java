package lo.spring.player.entity;

import jakarta.persistence.*;
import lo.spring.team.entity.Team;
import lombok.*;

@Entity
@Table(name = "players")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;
}