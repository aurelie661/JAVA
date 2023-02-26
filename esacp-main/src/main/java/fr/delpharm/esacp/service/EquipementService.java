package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Equipement;
import fr.delpharm.esacp.repository.EquipementRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class EquipementService implements IService<Equipement>{
	
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	EquipementRepository equipementRepository;

	@Override
	public List<Equipement> findAll() {
		return equipementRepository.findAll();
	}

	@Override
	public Optional<Equipement> findById(Long id) {
		return equipementRepository.findById(id);
	}

	@Override
	public Equipement save(Equipement t) {
		return equipementRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		equipementRepository.deleteById(id);
	}

	@Override
	public List<Equipement> findByIsAfficheTrue() {
		return equipementRepository.findByIsAfficheTrue();
	}
}
