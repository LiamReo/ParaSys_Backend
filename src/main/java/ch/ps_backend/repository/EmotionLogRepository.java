package ch.ps_backend.repository;

import ch.ps_backend.model.EmotionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmotionLogRepository extends JpaRepository<EmotionLog, Integer> {

    EmotionLog getById(int id);
}