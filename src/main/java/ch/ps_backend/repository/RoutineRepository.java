package ch.ps_backend.repository;

import ch.ps_backend.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoutineRepository extends JpaRepository<Routine, Integer> {
}