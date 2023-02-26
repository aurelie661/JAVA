package fr.delpharm.esacp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.TypeAt;

/**
 * Spring Data SQL repository for the TypeAt entity.
 */

@Repository
public interface TypeAtRepository extends JpaRepository<TypeAt, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<TypeAt> findByIsAfficheTrue();
	
}
