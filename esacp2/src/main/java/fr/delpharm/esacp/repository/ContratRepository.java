package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Contrat;

/**
 * Spring Data SQL repository for the Contrat entity.
 */

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Contrat> findByIsAfficheTrue();
	
}
