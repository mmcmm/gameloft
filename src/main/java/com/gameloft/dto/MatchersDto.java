package com.gameloft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Set;

@Builder(toBuilder = true)
public record MatchersDto(
        @JsonProperty("level") Level level,
        @JsonProperty("has") Has has,
        @JsonProperty("does_not_have") DoesNotHave doesNotHave
) {

    @Builder(toBuilder = true)
    public record Level(
            @JsonProperty("min") int min,
            @JsonProperty("max") int max
    ) {
    }

    @Builder(toBuilder = true)
    public record Has(
            @JsonProperty("country") Set<String> country,
            @JsonProperty("items") Set<String> items
    ) {
    }

    @Builder(toBuilder = true)
    public record DoesNotHave(
            @JsonProperty("items") Set<String> items
    ) {
    }
}
