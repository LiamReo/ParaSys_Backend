package ch.ps_backend.repository;

import ch.ps_backend.model.Addiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddictionRepository extends JpaRepository<Addiction, Integer> {
    Addiction getById(int id);
}