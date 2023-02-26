package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Categorie;

/**
 * Spring Data SQL repository for the Categorie entity.
 */
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Categorie> findByIsAfficheTrue();
	
}
