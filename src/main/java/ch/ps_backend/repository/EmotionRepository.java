package ch.ps_backend.repository;

import ch.ps_backend.model.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmotionRepository extends JpaRepository<Emotion, Integer> {

    Emotion getById(int id);
}