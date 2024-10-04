package com.gameloft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.ZonedDateTime;

@Builder(toBuilder = true)
public record CampaignDto(
        @JsonProperty("game") String game,
        @JsonProperty("name") String name,
        @JsonProperty("priority") double priority,
        @JsonProperty("matchers") MatchersDto matchers,
        @JsonProperty("start_date") ZonedDateTime startDate,
        @JsonProperty("end_date") ZonedDateTime endDate,
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("last_updated") ZonedDateTime lastUpdated
) {

}
