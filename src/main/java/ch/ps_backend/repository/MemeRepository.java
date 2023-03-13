package ch.ps_backend.repository;

import ch.ps_backend.model.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemeRepository extends JpaRepository<Meme, Integer> {
}