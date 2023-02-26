package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Sexe;
import fr.delpharm.esacp.repository.SexeRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class SexeService implements IService<Sexe>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	SexeRepository sexeRepository;

	@Override
	public List<Sexe> findAll() {
		return sexeRepository.findAll();
	}

	@Override
	public Optional<Sexe> findById(Long id) {
		return sexeRepository.findById(id);
	}

	@Override
	public Sexe save(Sexe t) {
		return sexeRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		sexeRepository.deleteById(id);
	}

	@Override
	public List<Sexe> findByIsAfficheTrue() {
		return sexeRepository.findByIsAfficheTrue();
	}
}

