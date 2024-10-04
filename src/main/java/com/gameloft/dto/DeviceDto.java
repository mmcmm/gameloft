package com.gameloft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(toBuilder = true)
public record DeviceDto(
        @JsonProperty("id") int id,
        @JsonProperty("model") String model,
        @JsonProperty("carrier") String carrier,
        @JsonProperty("firmware") String firmware
) {}