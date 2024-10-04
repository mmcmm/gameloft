package com.gameloft.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(toBuilder = true)
public record ClanDto(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name
) {}
