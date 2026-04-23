package com.internship.tool.service;

import com.internship.tool.entity.Risk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskService {

    private List<Risk> risks = new ArrayList<>();

    public List<Risk> getAllRisks() {
        return risks;
    }

    public Risk addRisk(Risk risk) {
        risks.add(risk);
        return risk;
    }
}