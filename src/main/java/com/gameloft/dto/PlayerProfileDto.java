package com.gameloft.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public record PlayerProfileDto(
        @JsonProperty("player_id") String playerId,
        @JsonProperty("credential") String credential,
        @JsonProperty("created") ZonedDateTime created,
        @JsonProperty("modified") ZonedDateTime modified,
        @JsonProperty("last_session") ZonedDateTime lastSession,
        @JsonProperty("total_spent") int totalSpent,
        @JsonProperty("total_refund") int totalRefund,
        @JsonProperty("total_transactions") int totalTransactions,
        @JsonProperty("last_purchase") ZonedDateTime lastPurchase,
        @JsonProperty("active_campaigns") List<String> activeCampaigns,
        @JsonProperty("devices") List<DeviceDto> devices,
        @JsonProperty("level") int level,
        @JsonProperty("xp") int xp,
        @JsonProperty("total_playtime") int totalPlaytime,
        @JsonProperty("country") String country,
        @JsonProperty("language") String language,
        @JsonProperty("birthdate") ZonedDateTime birthdate,
        @JsonProperty("gender") String gender,
        @JsonProperty("inventory") Map<String, Integer> inventory,
        @JsonProperty("clan") ClanDto clan,
        @JsonProperty("_customfield") String customField
) {
}