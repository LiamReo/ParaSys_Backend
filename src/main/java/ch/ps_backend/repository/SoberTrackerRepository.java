package ch.ps_backend.repository;

import ch.ps_backend.model.SoberTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SoberTrackerRepository extends JpaRepository<SoberTracker, Integer> {

    SoberTracker getById(int id);
}