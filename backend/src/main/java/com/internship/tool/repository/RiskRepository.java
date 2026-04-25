package com.internship.tool.repository;

import com.internship.tool.entity.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {

    // Search by title or description
    List<Risk> findByTitleContainingIgnoreCase(String title);

    // Filter by status
    List<Risk> findByStatus(String status);

    // Filter by category
    List<Risk> findByCategory(String category);

    // Find by date range
    @Query("SELECT r FROM Risk r WHERE r.createdAt BETWEEN :startDate AND :endDate")
    List<Risk> findByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    // Count by status
    @Query("SELECT r.status, COUNT(r) FROM Risk r GROUP BY r.status")
    List<Object[]> countByStatus();

    // Count by category
    @Query("SELECT r.category, COUNT(r) FROM Risk r GROUP BY r.category")
    List<Object[]> countByCategory();
}