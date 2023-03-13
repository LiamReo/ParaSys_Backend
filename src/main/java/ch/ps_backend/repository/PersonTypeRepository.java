package ch.ps_backend.repository;

import ch.ps_backend.model.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonTypeRepository extends JpaRepository<PersonType, Integer> {
}