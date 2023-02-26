package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.MoyenPrevenu;

/**
 * Spring Data SQL repository for the MoyenPrevenu entity.
 */

@Repository
public interface MoyenPrevenuRepository extends JpaRepository<MoyenPrevenu, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<MoyenPrevenu> findByIsAfficheTrue();
}