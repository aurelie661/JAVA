package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.SiegeLesions;

/**
 * Spring Data SQL repository for the SiegeLesions entity.
 */

@Repository
public interface SiegeLesionsRepository extends JpaRepository<SiegeLesions, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<SiegeLesions> findByIsAfficheTrue();
	SiegeLesions findByValue(String value);
	
}
