package fr.delpharm.esacp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.delpharm.esacp.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// permet de récuperer une liste en filtrant par e-mail
	List<User> findByEmail(String email);
	// permet de récuperer une liste en filtrant par matricule
	Optional<User> findByMatricule(String matricule);
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<User> findByIsAfficheTrue();
	// permet de récuperer une liste par ID
	Optional<User> findById(Integer valueOf);
	// permet de récuperer une liste dont le boolean affiche = "true"
	List<User> findByPiloteTrue();
}
