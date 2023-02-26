package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.EtapeValidation;

/**
 * Spring Data SQL repository for the EtapeValidation entity.
 */

@Repository
public interface EtapeValidationRepository extends JpaRepository<EtapeValidation, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<EtapeValidation> findByIsAfficheTrue();
	
}
