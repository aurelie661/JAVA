package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Contrat;
import fr.delpharm.esacp.repository.ContratRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class ContratService implements IService<Contrat>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	ContratRepository contratRepository;

	@Override
	public List<Contrat> findAll() {
		return contratRepository.findAll();
	}

	@Override
	public Optional<Contrat> findById(Long id) {
		return contratRepository.findById(id);
	}

	@Override
	public Contrat save(Contrat t) {
		return contratRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		contratRepository.deleteById(id);
	}

	@Override
	public List<Contrat> findByIsAfficheTrue() {
		return contratRepository.findByIsAfficheTrue();
	}
}
