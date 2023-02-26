package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Priorite;

/**
 * Spring Data SQL repository for the Priorite entity.
 */

@Repository
public interface PrioriteRepository extends JpaRepository<Priorite, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Priorite> findByIsAfficheTrue();
	
}
