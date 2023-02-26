package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Priorite;
import fr.delpharm.esacp.repository.PrioriteRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class PrioriteService implements IService<Priorite>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	PrioriteRepository prioriteRepository;

	@Override
	public List<Priorite> findAll() {
		return prioriteRepository.findAll();
	}

	@Override
	public Optional<Priorite> findById(Long id) {
		return prioriteRepository.findById(id);
	}

	@Override
	public Priorite save(Priorite t) {
		return prioriteRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		prioriteRepository.deleteById(id);
	}

	@Override
	public List<Priorite> findByIsAfficheTrue() {
		return prioriteRepository.findByIsAfficheTrue();
	}
}
