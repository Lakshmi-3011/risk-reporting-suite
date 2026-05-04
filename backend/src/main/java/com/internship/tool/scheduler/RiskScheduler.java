package com.internship.tool.scheduler;

import com.internship.tool.entity.Risk;
import com.internship.tool.service.RiskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskScheduler {

    private final RiskService riskService;

    public RiskScheduler(RiskService riskService) {
        this.riskService = riskService;
    }

    @Scheduled(fixedRate = 60000) // runs every 1 minute
    public void checkOverdueRisks() {

        List<Risk> risks = riskService.getAllRisks();

        for (Risk risk : risks) {
            System.out.println("Checking risk ID: " + risk.getId());
        }
    }
}