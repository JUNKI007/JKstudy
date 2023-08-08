package lo.spring.player.controller;

import lo.spring.player.entity.Player;
import lo.spring.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> findAllPlayer(){
        return playerService.findAllPlayer();
    }


    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable String id) {
        return playerService.findPlayerById(id);
    }
}
