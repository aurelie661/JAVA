package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Repartition;
import fr.delpharm.esacp.repository.RepartitionRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */

@Service
@Transactional
public class RepartitionService implements IService<Repartition>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	RepartitionRepository repartitionRepository;

	@Override
	public List<Repartition> findAll() {
		return repartitionRepository.findAll();
	}

	@Override
	public Optional<Repartition> findById(Long id) {
		return repartitionRepository.findById(id);
	}

	@Override
	public Repartition save(Repartition t) {
		return repartitionRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		repartitionRepository.deleteById(id);
	}

	@Override
	public List<Repartition> findByIsAfficheTrue() {
		return repartitionRepository.findByIsAfficheTrue();
	}
}

