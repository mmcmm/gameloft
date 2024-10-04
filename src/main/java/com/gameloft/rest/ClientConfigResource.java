package com.gameloft.rest;

import com.gameloft.domain.Player;
import com.gameloft.service.CampaignMatchingService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ClientConfigResource {

    private final CampaignMatchingService campaignMatchingService;

    @GetMapping("/get_client_config/{player_id}")
    public ResponseEntity<Player> getClientConfig(@PathVariable("player_id") @NotBlank final String playerId) {
        return ResponseEntity.ok(campaignMatchingService.matchProfile(playerId));
    }
}
