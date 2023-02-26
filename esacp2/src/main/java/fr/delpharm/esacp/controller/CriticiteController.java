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

import fr.delpharm.esacp.domain.Criticite;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.CriticiteService;
/**
 * 
 * @author GS
 * API CRUD criticites
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/criticites")
public class CriticiteController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CriticiteService criticiteRepository;

	// Permet de d'afficher une liste de criticites
	@GetMapping
	public ResponseEntity<List<Criticite>> listCriticites(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Criticite> criticites = criticiteRepository.findAll();
		return new ResponseEntity<List<Criticite>>(criticites, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste de criticites en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Criticite>> listCriticitesaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Criticite> criticites = criticiteRepository.findAll();
		return new ResponseEntity<List<Criticite>>(criticites, HttpStatus.OK);
	}

	// Permet d'ajouter une criticites
	@PostMapping
	public ResponseEntity<Criticite> addCriticite(@RequestBody @Valid Criticite criticite, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		criticiteRepository.save(criticite);
		return new ResponseEntity<Criticite>(criticite, HttpStatus.CREATED);
	}

    // Permet de supprimer une Criticite
	@DeleteMapping(value = "/{criticiteId}")
	public ResponseEntity<Object> deleteCriticite(@PathVariable("criticiteId") Long criticiteId, Principal principal) {
		criticiteRepository.deleteById(criticiteId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un Criticite
	@PutMapping(value = "/{criticiteId}")
	public ResponseEntity<Criticite> updateBook(@PathVariable("criticiteId") String criticiteId, @Valid @RequestBody Criticite criticite, Principal principal) {
		criticite.setId(Long.valueOf(criticiteId));
		Criticite criticiteToSave = criticiteRepository.save(criticite);
		return new ResponseEntity<Criticite>(criticiteToSave, HttpStatus.OK);
	}

	// Permet de récuperer une catégorie pour voir l'afficher
	@GetMapping("/{criticiteId}")
	public ResponseEntity<Criticite> loadCriticite(@PathVariable("criticiteId") String criticiteId) {
		Optional<Criticite> criticite = criticiteRepository.findById(Long.valueOf(criticiteId));
		return new ResponseEntity<Criticite>(criticite.get(), HttpStatus.OK);
	}

}