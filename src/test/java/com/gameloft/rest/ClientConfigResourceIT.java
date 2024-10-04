package com.gameloft.rest;

import com.gameloft.GameloftApplication;
import com.gameloft.domain.PlayerTest;
import com.gameloft.dto.CampaignDtoTest;
import com.gameloft.external.CampaignResource;
import com.gameloft.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = GameloftApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClientConfigResourceIT {

    @MockBean
    private CampaignResource campaignResource;
    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        when(campaignResource.getCurrentCampaigns()).thenReturn(List.of(CampaignDtoTest.campaignFixture()));
        when(playerRepository.findById(anyString())).thenReturn(Optional.of(PlayerTest.playerFixture()));

    }

    @Test
    @Transactional
    void testMatchingCampaigns() throws Exception {
        final var player = PlayerTest.playerFixture();

        mockMvc.perform(get("/api/get_client_config/{player_id}", player.getPlayerId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.activeCampaigns").isNotEmpty());
    }
}