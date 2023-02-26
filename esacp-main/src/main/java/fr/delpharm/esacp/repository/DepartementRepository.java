package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Departement;

/**
 * Spring Data SQL repository for the Departement entity.
 */

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Departement> findByIsAfficheTrue();
	
}
