package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Site;

/**
 * Spring Data SQL repository for the Site entity.
 */

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<Site> findByIsAfficheTrue();
	
}
