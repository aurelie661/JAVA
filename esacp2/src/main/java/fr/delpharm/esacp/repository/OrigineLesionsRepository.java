package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.OrigineLesions;

/**
 * Spring Data SQL repository for the OrigineLesions entity.
 */

@Repository
public interface OrigineLesionsRepository extends JpaRepository<OrigineLesions, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<OrigineLesions> findByIsAfficheTrue();
	
}
