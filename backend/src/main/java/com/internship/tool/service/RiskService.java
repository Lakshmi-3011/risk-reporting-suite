package com.internship.tool.service;

import com.internship.tool.entity.Risk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskService {

    private List<Risk> riskList = new ArrayList<>();
    private Long idCounter = 1L;   // 🔥 important

    public List<Risk> getAllRisks() {
        return riskList;
    }

    public Risk addRisk(Risk risk) {
        risk.setId(idCounter++);   // 🔥 assign ID
        riskList.add(risk);
        return risk;
    }

    public Risk getRiskById(Long id) {
        return riskList.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String deleteRisk(Long id) {
        riskList.removeIf(r -> r.getId().equals(id));
        return "Risk deleted successfully";
    }
}