package com.gameloft.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class CampaignDtoTest {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

    public static CampaignDto campaignFixture() {
        return CampaignDto.builder()
                .game("mygame")
                .name("mycampaign")
                .priority(10.5)
                .matchers(
                        MatchersDto.builder()
                                .level(MatchersDto.Level.builder()
                                        .min(1)
                                        .max(3)
                                        .build())
                                .has(MatchersDto.Has.builder()
                                        .country(Set.of("US", "RO", "CA"))
                                        .items(Set.of("item_1"))
                                        .build())
                                .doesNotHave(MatchersDto.DoesNotHave.builder()
                                        .items(Set.of("item_4"))
                                        .build())
                                .build()
                )
                .startDate(ZonedDateTime.parse("2022-01-25 00:00:00Z", DATE_TIME_FORMATTER))
                .endDate(ZonedDateTime.parse("2022-02-25 00:00:00Z", DATE_TIME_FORMATTER))
                .enabled(true)
                .lastUpdated(ZonedDateTime.parse("2021-07-13 11:46:58Z", DATE_TIME_FORMATTER))
                .build();
    }
}