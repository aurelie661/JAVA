package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.SiegeLesions;
import fr.delpharm.esacp.repository.SiegeLesionsRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class SiegeLesionsService implements IService<SiegeLesions>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	SiegeLesionsRepository siegeLesionsRepository;

	@Override
	public List<SiegeLesions> findAll() {
		return siegeLesionsRepository.findAll();
	}

	@Override
	public Optional<SiegeLesions> findById(Long id) {
		return siegeLesionsRepository.findById(id);
	}

	@Override
	public SiegeLesions save(SiegeLesions t) {
		return siegeLesionsRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		siegeLesionsRepository.deleteById(id);
	}
  
	@Override
	public List<SiegeLesions> findByIsAfficheTrue() {
		return siegeLesionsRepository.findByIsAfficheTrue();
	}
}

