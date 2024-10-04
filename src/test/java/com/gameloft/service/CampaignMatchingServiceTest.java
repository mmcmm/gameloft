package com.gameloft.service;

import com.gameloft.config.MapperConfig;
import com.gameloft.domain.PlayerTest;
import com.gameloft.dto.CampaignDtoTest;
import com.gameloft.external.CampaignResource;
import com.gameloft.repository.PlayerRepository;
import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfig.class)
class CampaignMatchingServiceTest {


    @Autowired
    private Mapper mapper;

    private final PlayerRepository playerRepository = mock(PlayerRepository.class);
    private final CampaignResource campaignResource = mock(CampaignResource.class);

    private CampaignMatchingService campaignMatchingService;

    @BeforeEach
    void setUp() {
        campaignMatchingService = new CampaignMatchingService(playerRepository, mapper, campaignResource);
    }


    @Test
    void shouldMatchProfileWithCurrentCampaigns() {
        final var campaign = CampaignDtoTest.campaignFixture();
        final var player = PlayerTest.playerFixture();

        when(campaignResource.getCurrentCampaigns()).thenReturn(List.of(campaign));
        when(playerRepository.findById(anyString())).thenReturn(Optional.of(player));

        final var result = campaignMatchingService.matchProfile(player.getPlayerId());

        assertThat(result).hasNoNullFieldsOrProperties();
        assertThat(result.getActiveCampaigns())
                .containsExactly(campaign.name());
    }
}