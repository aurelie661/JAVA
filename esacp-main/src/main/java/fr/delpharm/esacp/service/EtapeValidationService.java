package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.EtapeValidation;
import fr.delpharm.esacp.repository.EtapeValidationRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class EtapeValidationService implements IService<EtapeValidation>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	EtapeValidationRepository etapeValidationRepository;

	@Override
	public List<EtapeValidation> findAll() {
		return etapeValidationRepository.findAll();
	}

	@Override
	public Optional<EtapeValidation> findById(Long id) {
		return etapeValidationRepository.findById(id);
	}

	@Override
	public EtapeValidation save(EtapeValidation t) {
		return etapeValidationRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		etapeValidationRepository.deleteById(id);
	}

	@Override
	public List<EtapeValidation> findByIsAfficheTrue() {
		return etapeValidationRepository.findByIsAfficheTrue();
	}
}
