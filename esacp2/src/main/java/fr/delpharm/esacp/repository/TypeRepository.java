package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Type;

/**
 * Spring Data SQL repository for the Type entity.
 */

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Type> findByIsAfficheTrue();
}
