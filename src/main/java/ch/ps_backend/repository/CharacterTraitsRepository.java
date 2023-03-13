package ch.ps_backend.repository;

import ch.ps_backend.model.CharacterTraits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CharacterTraitsRepository extends JpaRepository<CharacterTraits, Long>, JpaSpecificationExecutor<CharacterTraits> {

}