package ch.ps_backend.repository;

import ch.ps_backend.model.GameState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GameStateRepository extends JpaRepository<GameState, Integer> {
}