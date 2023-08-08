package lo.spring.team.controller;

import lo.spring.team.request.TeamRequest;
import lo.spring.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("teams")
public class TeamController {
    private final TeamService service;
    @PostMapping
    public void insert(@RequestBody TeamRequest teamRequest){
        service.save(teamRequest.getName());
    }

}
