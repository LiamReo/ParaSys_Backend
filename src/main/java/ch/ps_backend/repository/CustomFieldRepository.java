package ch.ps_backend.repository;

import ch.ps_backend.model.CustomField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomFieldRepository extends JpaRepository<CustomField, Integer> {
}