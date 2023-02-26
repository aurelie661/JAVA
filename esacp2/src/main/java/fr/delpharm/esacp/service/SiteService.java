package fr.delpharm.esacp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.delpharm.esacp.domain.Site;
import fr.delpharm.esacp.repository.SiteRepository;
/**
 * 
 * @author GS
 * Pour faire un couplage faible
 *
 */
@Service
@Transactional
public class SiteService implements IService<Site>{
		
	//L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	@Autowired
    	SiteRepository siteRepository;

	@Override
	public List<Site> findAll() {
		return siteRepository.findAll();
	}

	@Override
	public Optional<Site> findById(Long id) {
		return siteRepository.findById(id);
	}

	@Override
	public Site save(Site t) {
		return siteRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		siteRepository.deleteById(id);
	}

	@Override
	public List<Site> findByIsAfficheTrue() {
		return siteRepository.findByIsAfficheTrue();
	}
}


