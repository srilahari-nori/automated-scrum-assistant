package org.example.repository;

import org.example.entity.TechnicalDebt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalDebtRepository extends JpaRepository<TechnicalDebt, Long> {
    // This interface allows you to Save/Find technical debt issues in SQL
}