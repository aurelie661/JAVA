package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.NatureAccident;

/**
 * Spring Data SQL repository for the NatureAccident entity.
 */

@Repository
public interface NatureAccidentRepository extends JpaRepository<NatureAccident, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<NatureAccident> findByIsAfficheTrue();
	
}
