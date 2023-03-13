package ch.ps_backend.repository;

import ch.ps_backend.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}