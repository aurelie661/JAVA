package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Departement;
import fr.delpharm.esacp.repository.DepartementRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class DepartementService implements IService<Departement>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	DepartementRepository departementRepository;

	@Override
	public List<Departement> findAll() {
		return departementRepository.findAll();
	}

	@Override
	public Optional<Departement> findById(Long id) {
		return departementRepository.findById(id);
	}

	@Override
	public Departement save(Departement t) {
		return departementRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		departementRepository.deleteById(id);
	}

	@Override
	public List<Departement> findByIsAfficheTrue() {
		return departementRepository.findByIsAfficheTrue();
	}
}

