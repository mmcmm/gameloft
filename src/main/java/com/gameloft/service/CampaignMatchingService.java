package com.gameloft.service;

import com.gameloft.domain.Player;
import com.gameloft.dto.CampaignDto;
import com.gameloft.external.CampaignResource;
import com.gameloft.repository.PlayerRepository;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignMatchingService {

    private final PlayerRepository playerRepository;
    private final Mapper mapper;
    private final CampaignResource campaignResource;


    @NonNull
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Player matchProfile(@NonNull final String playerId) {
        return playerRepository.findById(playerId)
                .map(player -> {
                    final var campaigns = getMatchingCampaigns(player);
                    if (!campaigns.isEmpty()) {
                        player.getActiveCampaigns()
                                .addAll(campaigns.stream().map(CampaignDto::name).toList());
                        playerRepository.save(player);
                    }
                    return player;
                })
                //      .map(player -> mapper.map(player, PlayerProfileDto.class))
                .orElseThrow(IllegalStateException::new);
    }

    @NonNull
    private List<CampaignDto> getMatchingCampaigns(@NonNull final Player player) {
        return campaignResource.getCurrentCampaigns()
                .stream()
                .filter(c -> c.matchers().level().min() <= player.getLevel())
                .filter(c -> c.matchers().level().max() >= player.getLevel())
                .filter(c -> c.matchers().has().country().contains(player.getCountry()))
                .filter(c -> player.getInventory().keySet().containsAll(c.matchers().has().items()))
                .filter(c -> player.getInventory().keySet().stream()
                        .noneMatch(c.matchers().doesNotHave().items()::contains))
                .toList();
    }
}
