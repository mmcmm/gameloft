package com.gameloft.external;

import com.gameloft.dto.CampaignDto;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = CampaignResource.CAMPAIGNS, url = "https://localhost:8080")
public interface CampaignResource {

    String CAMPAIGNS = "campaigns";

    List<CampaignDto> getCurrentCampaigns();
}
