package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Rapport;
import fr.delpharm.esacp.repository.RapportRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class RapportService implements IService<Rapport>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	RapportRepository rapportRepository;

	@Override
	public List<Rapport> findAll() {
		return rapportRepository.findAll();
	}

	@Override
	public Optional<Rapport> findById(Long id) {
		return rapportRepository.findById(id);
	}

	@Override
	public Rapport save(Rapport t) {
		return rapportRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		rapportRepository.deleteById(id);
	}

	@Override
	public List<Rapport> findByIsAfficheTrue() {
		return null;
	}
	
	
	public Rapport findByIdRapport(Long id) {
		return rapportRepository.findByIdRapport(id);
	}
}

