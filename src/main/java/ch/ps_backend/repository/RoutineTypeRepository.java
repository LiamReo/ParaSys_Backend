package ch.ps_backend.repository;

import ch.ps_backend.model.RoutineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoutineTypeRepository extends JpaRepository<RoutineType, Integer> {
}