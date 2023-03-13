package ch.ps_backend.repository;

import ch.ps_backend.model.TimeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TimeLogRepository extends JpaRepository<TimeLog, Integer> {

    TimeLog getById(int id);
}