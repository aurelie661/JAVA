package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Sexe;

/**
 * Spring Data SQL repository for the Sexe entity.
 */

@Repository
public interface SexeRepository extends JpaRepository<Sexe, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Sexe> findByIsAfficheTrue();
}
