package com.internship.tool.service;

import com.internship.tool.entity.Risk;
import com.internship.tool.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RiskServiceTest {

    private RiskService riskService;

    @BeforeEach
    void setup() {
        riskService = new RiskService();
    }

    // 1️⃣ Add Risk - Happy
    @Test
    void testAddRisk() {
        Risk risk = new Risk();
        risk.setTitle("Test Risk");

        Risk result = riskService.addRisk(risk);

        assertNotNull(result.getId());
        assertEquals("Test Risk", result.getTitle());
    }

    // 2️⃣ Get All Risks
    @Test
    void testGetAllRisks() {
        riskService.addRisk(new Risk());
        riskService.addRisk(new Risk());

        List<Risk> risks = riskService.getAllRisks();

        assertEquals(2, risks.size());
    }

    // 3️⃣ Get Risk By ID - Success
    @Test
    void testGetRiskById_success() {
        Risk risk = new Risk();
        riskService.addRisk(risk);

        Risk found = riskService.getRiskById(1L);

        assertNotNull(found);
    }

    // 4️⃣ Get Risk By ID - Not Found
    @Test
    void testGetRiskById_notFound() {
        assertThrows(ResourceNotFoundException.class,
                () -> riskService.getRiskById(999L));
    }

    // 5️⃣ Delete Risk
    @Test
    void testDeleteRisk() {
        Risk risk = new Risk();
        riskService.addRisk(risk);

        String result = riskService.deleteRisk(1L);

        assertEquals("Risk deleted successfully", result);
    }

    // 6️⃣ Delete Non-existing Risk
    @Test
    void testDeleteRisk_notFound() {
        String result = riskService.deleteRisk(999L);

        assertEquals("Risk deleted successfully", result);
    }

    // 7️⃣ Multiple Add Check
    @Test
    void testMultipleAdd() {
        riskService.addRisk(new Risk());
        riskService.addRisk(new Risk());
        riskService.addRisk(new Risk());

        assertEquals(3, riskService.getAllRisks().size());
    }

    // 8️⃣ Null Risk Case
    @Test
    void testAddNullRisk() {
        assertThrows(NullPointerException.class,
                () -> riskService.addRisk(null));
    }

    // 9️⃣ Check ID Increment
    @Test
    void testIdIncrement() {
        Risk r1 = riskService.addRisk(new Risk());
        Risk r2 = riskService.addRisk(new Risk());

        assertEquals(1L, r1.getId());
        assertEquals(2L, r2.getId());
    }

    // 🔟 Empty List Initially
    @Test
    void testEmptyList() {
        assertTrue(riskService.getAllRisks().isEmpty());
    }
}