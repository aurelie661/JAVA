package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.TypeAction;

/**
 * Spring Data SQL repository for the TypeAction entity.
 */

@Repository
public interface TypeActionRepository extends JpaRepository<TypeAction, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<TypeAction> findByIsAfficheTrue();
	
}
