package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Csp;

/**
 * Spring Data SQL repository for the Csp entity.
 */

@Repository
public interface CspRepository extends JpaRepository<Csp, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Csp> findByIsAfficheTrue();
	
}
