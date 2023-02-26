package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Statut;
import fr.delpharm.esacp.repository.StatutRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class StatutService implements IService<Statut>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	StatutRepository statutRepository;

	@Override
	public List<Statut> findAll() {
		return statutRepository.findAll();
	}

	@Override
	public Optional<Statut> findById(Long id) {
		return statutRepository.findById(id);
	}

	@Override
	public Statut save(Statut t) {
		return statutRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		statutRepository.deleteById(id);
	}

	@Override
	public List<Statut> findByIsAfficheTrue() {
		return statutRepository.findByIsAfficheTrue();
	}
}

