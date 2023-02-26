package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.TypeRapport;

/**
 * Spring Data SQL repository for the TypeRapport entity.
 */

@Repository
public interface TypeRapportRepository extends JpaRepository<TypeRapport, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<TypeRapport> findByIsAfficheTrue();
	
}
