package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Criticite;
import fr.delpharm.esacp.repository.CriticiteRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class CriticiteService implements IService<Criticite>{
	
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	CriticiteRepository criticiteRepository;

	@Override
	public List<Criticite> findAll() {
		return criticiteRepository.findAll();
	}

	@Override
	public Optional<Criticite> findById(Long id) {
		return criticiteRepository.findById(id);
	}

	@Override
	public Criticite save(Criticite t) {
		return criticiteRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		criticiteRepository.deleteById(id);
	}

	@Override
	public List<Criticite> findByIsAfficheTrue() {
		return criticiteRepository.findByIsAfficheTrue();
	}
}
