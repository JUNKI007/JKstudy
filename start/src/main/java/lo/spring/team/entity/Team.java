package lo.spring.team.entity;

import jakarta.persistence.*;
import lo.spring.player.entity.Player;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teams")
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
//    장점 : 유일성: UUID는 거의 유일한 값이므로 여러 개의 데이터베이스 서버 또는 분산 시스템에서도 충돌없이 식별할 수 있다.
//    선택권 이 있다.
//    보안성: 순차적인 숫자가 아닌 랜덤한 값을 사용하므로, 외부로부터 엔티티의 식별자를 추측하기 어렵다.
    private String id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<Player> players;
}