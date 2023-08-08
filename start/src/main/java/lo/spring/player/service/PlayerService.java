package lo.spring.player.service;

import lo.spring.player.entity.Player;
import lo.spring.player.entity.PlayerRepository;
import lo.spring.team.entity.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public List<Player> findAllPlayer(){
     return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(String id){
        return playerRepository.findById(id);
    }
}
