package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Equipement;

/**
 * Spring Data SQL repository for the Equipement entity.
 */

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Equipement> findByIsAfficheTrue();
	
}
