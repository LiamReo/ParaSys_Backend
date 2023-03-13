package ch.ps_backend.repository;

import ch.ps_backend.model.AmountLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountLogRepository extends JpaRepository<AmountLog, Integer> {

    AmountLog getById(int id);
}