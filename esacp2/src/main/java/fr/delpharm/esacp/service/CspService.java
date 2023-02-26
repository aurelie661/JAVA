package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Csp;
import fr.delpharm.esacp.repository.CspRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class CspService implements IService<Csp>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	CspRepository cspRepository;

	@Override
	public List<Csp> findAll() {
		return cspRepository.findAll();
	}

	@Override
	public Optional<Csp> findById(Long id) {
		return cspRepository.findById(id);
	}

	@Override
	public Csp save(Csp t) {
		return cspRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		cspRepository.deleteById(id);
	}

	@Override
	public List<Csp> findByIsAfficheTrue() {
		return cspRepository.findByIsAfficheTrue();
	}
}
