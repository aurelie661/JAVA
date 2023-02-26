package fr.delpharm.esacp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.Action;

/**
 * Spring Data SQL repository for the Categorie entity.
 */
@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

	Action findById(Integer valueOf);
	
	// Requete permet de calculer stat sur 12 mois glissant
	@Query(value = "SELECT CONCAT(YEAR(date_et_heure_creation), '/', MONTH(date_et_heure_creation)) as temps , count(id) AS nombre FROM action"
			+" where (DATE_SUB(NOW(), INTERVAL 1 MONTH))>=date_et_heure_creation and datediff((DATE_SUB(NOW(), INTERVAL 1 MONTH)),date_et_heure_creation)<=365"
			+" group by YEAR(date_et_heure_creation) , MONTH(date_et_heure_creation)"
			+" ORDER BY YEAR(date_et_heure_creation) asc, MONTH(date_et_heure_creation) asc;", nativeQuery = true)
		List<Object> liststat();

}