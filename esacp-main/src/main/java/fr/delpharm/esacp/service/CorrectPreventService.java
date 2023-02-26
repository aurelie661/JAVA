package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.CorrectPrevent;
import fr.delpharm.esacp.repository.CorrectPreventRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class CorrectPreventService implements IService<CorrectPrevent>{
	
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	CorrectPreventRepository correctPreventRepository;

	@Override
	public List<CorrectPrevent> findAll() {
		return correctPreventRepository.findAll();
	}

	@Override
	public Optional<CorrectPrevent> findById(Long id) {
		return correctPreventRepository.findById(id);
	}

	@Override
	public CorrectPrevent save(CorrectPrevent t) {
		return correctPreventRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		correctPreventRepository.deleteById(id);
	}

	@Override
	public List<CorrectPrevent> findByIsAfficheTrue() {
		return correctPreventRepository.findByIsAfficheTrue();
	}
}
