package com.gameloft.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.gameloft.dto.CampaignDtoTest.DATE_TIME_FORMATTER;

public class PlayerTest {

    public static Player playerFixture() {
        return Player.builder()
                .playerId("97983be2-98b7-11e7-90cf-082e5f28d836")
                .credential("apple_credential")
                .created(ZonedDateTime.parse("2021-01-10 13:37:17Z", DATE_TIME_FORMATTER))
                .modified(ZonedDateTime.parse("2021-01-23 13:37:17Z", DATE_TIME_FORMATTER))
                .lastSession(ZonedDateTime.parse("2021-01-23 13:37:17Z", DATE_TIME_FORMATTER))
                .totalSpent(400)
                .totalRefund(0)
                .totalTransactions(5)
                .lastPurchase(ZonedDateTime.parse("2021-01-22 13:37:17Z", DATE_TIME_FORMATTER))
                .activeCampaigns(new ArrayList<>())
                .devices(List.of(
                        Device.builder()
                                .id(1)
                                .model("apple iphone 11")
                                .carrier("vodafone")
                                .firmware("123")
                                .build()
                ))
                .level(3)
                .xp(1000)
                .totalPlaytime(144)
                .country("CA")
                .language("fr")
                .birthdate(ZonedDateTime.parse("2000-01-10 13:37:17Z", DATE_TIME_FORMATTER))
                .gender("male")
                .inventory(Map.of(
                        "cash", 123,
                        "coins", 123,
                        "item_1", 1,
                        "item_34", 3,
                        "item_55", 2
                ))
                .clan(Clan.builder()
                        .id("123456")
                        .name("Hello world clan")
                        .build())
                .customField("mycustom")
                .build();
    }
}