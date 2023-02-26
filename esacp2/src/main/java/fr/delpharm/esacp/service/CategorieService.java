package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Categorie;
import fr.delpharm.esacp.repository.CategorieRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class CategorieService implements IService<Categorie>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	CategorieRepository categorieRepository;

	@Override
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	@Override
	public Optional<Categorie> findById(Long id) {
		return categorieRepository.findById(id);
	}

	@Override
	public Categorie save(Categorie t) {
		return categorieRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		categorieRepository.deleteById(id);
	}

	@Override
	public List<Categorie> findByIsAfficheTrue() {
		return categorieRepository.findByIsAfficheTrue();
	}
}
