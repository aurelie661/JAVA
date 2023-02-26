package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Action;
import fr.delpharm.esacp.repository.ActionRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class ActionService implements IService<Action>{
	
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    ActionRepository actionRepository;
	
	@Override
	public List<Action> findAll() {
		return actionRepository.findAll();
	}

	@Override
	public Optional<Action> findById(Long id) {
		return actionRepository.findById(id);
	}

	@Override
	public Action save(Action t) {
		return actionRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		actionRepository.deleteById(id);
	}

	@Override
	public List<Action> findByIsAfficheTrue() {
		// TODO Auto-generated method stub
		return null;
	}
}
