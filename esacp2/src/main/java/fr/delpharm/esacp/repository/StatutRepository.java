package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Statut;

/**
 * Spring Data SQL repository for the Statut entity.
 */

@Repository
public interface StatutRepository extends JpaRepository<Statut, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Statut> findByIsAfficheTrue();
	
}
