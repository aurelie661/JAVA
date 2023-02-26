package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Type;
import fr.delpharm.esacp.repository.TypeRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class TypeService implements IService<Type>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	TypeRepository typeRepository;

	@Override
	public List<Type> findAll() {
		return typeRepository.findAll();
	}

	@Override
	public Optional<Type> findById(Long id) {
		return typeRepository.findById(id);
	}

	@Override
	public Type save(Type t) {
		return typeRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		typeRepository.deleteById(id);
	}

	@Override
	public List<Type> findByIsAfficheTrue() {
		return typeRepository.findByIsAfficheTrue();
	}
}
