package lo.spring.team.service;

import lo.spring.player.entity.Player;
import lo.spring.team.entity.Team;
import lo.spring.team.entity.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    public void save(String name) {
        Team team = new Team(UUID.randomUUID().toString(), name, null);
        teamRepository.save(team);
    }
}







