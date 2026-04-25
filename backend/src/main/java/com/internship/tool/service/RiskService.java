package com.internship.tool.service;

import com.internship.tool.entity.Risk;
import com.internship.tool.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiskService {

    @Autowired
    private RiskRepository riskRepository;

    // CREATE
    public Risk createRisk(Risk risk) {
        if (risk.getTitle() == null || risk.getTitle().isEmpty()) {
            throw new RuntimeException("Title cannot be empty");
        }
        return riskRepository.save(risk);
    }

    // READ ALL
    public List<Risk> getAllRisks() {
        return riskRepository.findAll();
    }

    // READ BY ID
    public Risk getRiskById(Long id) {
        return riskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk not found"));
    }

    // UPDATE
    public Risk updateRisk(Long id, Risk updatedRisk) {
        Risk existing = getRiskById(id);
        existing.setTitle(updatedRisk.getTitle());
        existing.setDescription(updatedRisk.getDescription());
        existing.setCategory(updatedRisk.getCategory());
        existing.setStatus(updatedRisk.getStatus());
        existing.setScore(updatedRisk.getScore());
        return riskRepository.save(existing);
    }

    // DELETE
    public void deleteRisk(Long id) {
        riskRepository.deleteById(id);
    }

    // SEARCH by title
    public List<Risk> searchRisks(String query) {
        return riskRepository.findByTitleContainingIgnoreCase(query);
    }

    // FILTER by status
    public List<Risk> filterByStatus(String status) {
        return riskRepository.findByStatus(status);
    }

    // STATS for dashboard
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalRisks", riskRepository.count());
        stats.put("byStatus", riskRepository.countByStatus());
        stats.put("byCategory", riskRepository.countByCategory());
        return stats;
    }
}