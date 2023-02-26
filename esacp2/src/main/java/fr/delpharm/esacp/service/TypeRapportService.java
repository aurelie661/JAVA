package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.TypeRapport;
import fr.delpharm.esacp.repository.TypeRapportRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class TypeRapportService implements IService<TypeRapport>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	TypeRapportRepository typeRapportRepository;

	@Override
	public List<TypeRapport> findAll() {
		return typeRapportRepository.findAll();
	}

	@Override
	public Optional<TypeRapport> findById(Long id) {
		return typeRapportRepository.findById(id);
	}

	@Override
	public TypeRapport save(TypeRapport t) {
		return typeRapportRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		typeRapportRepository.deleteById(id);
	}

	@Override
	public List<TypeRapport> findByIsAfficheTrue() {
		return typeRapportRepository.findByIsAfficheTrue();
	}
}


