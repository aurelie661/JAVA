package fr.delpharm.esacp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.delpharm.esacp.domain.Site;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.SiteService;
/**
 * 
 * @author GS
 * API CRUD sites
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sites")
public class SiteController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SiteService siteRepository;

	// Permet de d'afficher une liste d'objet sites
	@GetMapping
	public ResponseEntity<List<Site>> listSites(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Site> sites = siteRepository.findAll();
		return new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet sites en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Site>> listSitesaffiches(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Site> sites = siteRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
	}

	// Permet d'ajouter un objet sites
	@PostMapping
	public ResponseEntity<Site> addSite(@RequestBody @Valid Site site, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		siteRepository.save(site);
		return new ResponseEntity<Site>(site, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet sites
	@DeleteMapping(value = "/{siteId}")
	public ResponseEntity<Object> deleteSite(@PathVariable("siteId") Long siteId, Principal principal) {
		siteRepository.deleteById(siteId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet sites
	@PutMapping(value = "/{siteId}")
	public ResponseEntity<Site> updateBook(@PathVariable("siteId") String siteId, @Valid @RequestBody Site site, Principal principal) {
		site.setId(Long.valueOf(siteId));
		Site siteToSave = siteRepository.save(site);
		return new ResponseEntity<Site>(siteToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet sites pour voir l'afficher
	@GetMapping("/{siteId}")
	public ResponseEntity<Site> loadSite(@PathVariable("siteId") String siteId) {
		Optional<Site> site = siteRepository.findById(Long.valueOf(siteId));
		return new ResponseEntity<Site>(site.get(), HttpStatus.OK);
	}

}