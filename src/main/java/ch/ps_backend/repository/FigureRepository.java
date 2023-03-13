package ch.ps_backend.repository;

import ch.ps_backend.model.Figure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FigureRepository extends JpaRepository<Figure, Integer> {
}