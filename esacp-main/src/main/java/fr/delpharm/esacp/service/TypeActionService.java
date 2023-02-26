package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.TypeAction;
import fr.delpharm.esacp.repository.TypeActionRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class TypeActionService implements IService<TypeAction>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	TypeActionRepository typeActionRepository;

	@Override
	public List<TypeAction> findAll() {
		return typeActionRepository.findAll();
	}

	@Override
	public Optional<TypeAction> findById(Long id) {
		return typeActionRepository.findById(id);
	}

	@Override
	public TypeAction save(TypeAction t) {
		return typeActionRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		typeActionRepository.deleteById(id);
	}

	@Override
	public List<TypeAction> findByIsAfficheTrue() {
		return typeActionRepository.findByIsAfficheTrue();
	}
}

