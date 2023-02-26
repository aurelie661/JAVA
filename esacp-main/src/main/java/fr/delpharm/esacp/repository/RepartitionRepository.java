package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Repartition;

/**
 * Spring Data SQL repository for the Repartition entity.
 */

@Repository
public interface RepartitionRepository extends JpaRepository<Repartition, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Repartition> findByIsAfficheTrue();
}
