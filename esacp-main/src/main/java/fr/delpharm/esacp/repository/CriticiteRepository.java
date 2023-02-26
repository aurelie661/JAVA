package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Criticite;

/**
 * Spring Data SQL repository for the Criticite entity.
 */

@Repository
public interface CriticiteRepository extends JpaRepository<Criticite, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Criticite> findByIsAfficheTrue();
	
}
