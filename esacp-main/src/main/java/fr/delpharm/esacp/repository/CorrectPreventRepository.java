package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.CorrectPrevent;

/**
 * Spring Data SQL repository for the CorrectPrevent entity.
 */

@Repository
public interface CorrectPreventRepository extends JpaRepository<CorrectPrevent, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<CorrectPrevent> findByIsAfficheTrue();
	
}
