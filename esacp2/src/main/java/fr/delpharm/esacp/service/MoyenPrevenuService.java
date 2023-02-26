package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.MoyenPrevenu;
import fr.delpharm.esacp.repository.MoyenPrevenuRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class MoyenPrevenuService implements IService<MoyenPrevenu>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	MoyenPrevenuRepository moyenRepository;

	@Override
	public List<MoyenPrevenu> findAll() {
		return moyenRepository.findAll();
	}

	@Override
	public Optional<MoyenPrevenu> findById(Long id) {
		return moyenRepository.findById(id);
	}

	@Override
	public MoyenPrevenu save(MoyenPrevenu t) {
		return moyenRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		moyenRepository.deleteById(id);
	}

	@Override
	public List<MoyenPrevenu> findByIsAfficheTrue() {
		return moyenRepository.findByIsAfficheTrue();
	}
}
