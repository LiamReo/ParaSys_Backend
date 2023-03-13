package ch.ps_backend.repository;

import ch.ps_backend.model.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Integer> {

    Tracker getById(int id);
}