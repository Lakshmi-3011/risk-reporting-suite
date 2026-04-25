package com.internship.tool.controller;

import com.internship.tool.entity.Risk;
import com.internship.tool.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risks")
@CrossOrigin(origins = "*")
public class RiskController {

    @Autowired
    private RiskService riskService;

    // GET all risks
    @GetMapping("/all")
    public ResponseEntity<List<Risk>> getAllRisks() {
        return ResponseEntity.ok(riskService.getAllRisks());
    }

    // GET risk by ID
    @GetMapping("/{id}")
    public ResponseEntity<Risk> getRiskById(@PathVariable Long id) {
        return ResponseEntity.ok(riskService.getRiskById(id));
    }

    // POST create risk
    @PostMapping("/create")
    public ResponseEntity<Risk> createRisk(@RequestBody Risk risk) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(riskService.createRisk(risk));
    }

    // PUT update risk
    @PutMapping("/{id}")
    public ResponseEntity<Risk> updateRisk(@PathVariable Long id,
                                           @RequestBody Risk risk) {
        return ResponseEntity.ok(riskService.updateRisk(id, risk));
    }

    // DELETE risk
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRisk(@PathVariable Long id) {
        riskService.deleteRisk(id);
        return ResponseEntity.noContent().build();
    }

    // GET search by title
    @GetMapping("/search")
    public ResponseEntity<List<Risk>> searchRisks(@RequestParam String q) {
        return ResponseEntity.ok(riskService.searchRisks(q));
    }

    // GET filter by status
    @GetMapping("/filter")
    public ResponseEntity<List<Risk>> filterByStatus(@RequestParam String status) {
        return ResponseEntity.ok(riskService.filterByStatus(status));
    }

    // GET stats for dashboard
    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        return ResponseEntity.ok(riskService.getStats());
    }
}