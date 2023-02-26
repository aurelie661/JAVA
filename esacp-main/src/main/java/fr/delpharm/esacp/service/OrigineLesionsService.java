package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.OrigineLesions;
import fr.delpharm.esacp.repository.OrigineLesionsRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class OrigineLesionsService implements IService<OrigineLesions>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	OrigineLesionsRepository origineLesionsRepository;

	@Override
	public List<OrigineLesions> findAll() {
		return origineLesionsRepository.findAll();
	}

	@Override
	public Optional<OrigineLesions> findById(Long id) {
		return origineLesionsRepository.findById(id);
	}

	@Override
	public OrigineLesions save(OrigineLesions t) {
		return origineLesionsRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		origineLesionsRepository.deleteById(id);
	}

	@Override
	public List<OrigineLesions> findByIsAfficheTrue() {
		return origineLesionsRepository.findByIsAfficheTrue();
	}
}



