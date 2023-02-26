package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.NatureAccident;
import fr.delpharm.esacp.repository.NatureAccidentRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class NatureAccidentService implements IService<NatureAccident>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	NatureAccidentRepository natureAccidentRepository;

	@Override
	public List<NatureAccident> findAll() {
		return natureAccidentRepository.findAll();
	}

	@Override
	public Optional<NatureAccident> findById(Long id) {
		return natureAccidentRepository.findById(id);
	}

	@Override
	public NatureAccident save(NatureAccident t) {
		return natureAccidentRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		natureAccidentRepository.deleteById(id);
	}

	@Override
	public List<NatureAccident> findByIsAfficheTrue() {
		return natureAccidentRepository.findByIsAfficheTrue();
	}
}

