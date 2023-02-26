package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.TypeAt;
import fr.delpharm.esacp.repository.TypeAtRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class TypeAtService implements IService<TypeAt>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	TypeAtRepository typeAtRepository;

	@Override
	public List<TypeAt> findAll() {
		return typeAtRepository.findAll();
	}

	@Override
	public Optional<TypeAt> findById(Long id) {
		return typeAtRepository.findById(id);
	}

	@Override
	public TypeAt save(TypeAt t) {
		return typeAtRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		typeAtRepository.deleteById(id);
	}

	@Override
	public List<TypeAt> findByIsAfficheTrue() {
		return typeAtRepository.findByIsAfficheTrue() ;
	}
}

