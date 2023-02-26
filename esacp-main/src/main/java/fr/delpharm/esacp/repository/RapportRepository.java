package fr.delpharm.esacp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Rapport;

/**
 * Spring Data SQL repository for the Rapport entity.
 */

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
//	"select u from User u where u.emailAddress = ?1"
	@Query(value = "select r from Rapport r where r.id = ?1")
	Rapport findByIdRapport(Long id);
	
}
