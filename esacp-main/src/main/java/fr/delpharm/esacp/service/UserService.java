package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class UserService implements IService<User>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User save(User t) {
		return userRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public List<User> findByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public Optional<User> findByMatricule(String matricule) {
		return userRepository.findByMatricule(matricule);
	}
	
//	public User findByUsername(String username) {
//		return userRepository.findByUsername(username);
//	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findByIsAfficheTrue() {
		return userRepository.findByIsAfficheTrue();
	}
	
	public List<User> findByPiloteTrue() {
		return userRepository.findByPiloteTrue();
	}

}
