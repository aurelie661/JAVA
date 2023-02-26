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

import fr.delpharm.esacp.domain.Priorite;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.PrioriteService;
/**
 * 
 * @author GS
 * API CRUD priorites
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/priorites")
public class PrioriteController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PrioriteService prioriteRepository;

	// Permet de d'afficher une liste d'objet priorites
	@GetMapping
	public ResponseEntity<List<Priorite>> listPriorites(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Priorite> priorites = prioriteRepository.findAll();
		return new ResponseEntity<List<Priorite>>(priorites, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet priorites en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Priorite>> listPrioritesaffiches(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Priorite> priorites = prioriteRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Priorite>>(priorites, HttpStatus.OK);
	}

	// Permet d'ajouter un objet priorites
	@PostMapping
	public ResponseEntity<Priorite> addPriorite(@RequestBody @Valid Priorite priorite, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		prioriteRepository.save(priorite);
		return new ResponseEntity<Priorite>(priorite, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet priorites
	@DeleteMapping(value = "/{prioriteId}")
	public ResponseEntity<Object> deletePriorite(@PathVariable("prioriteId") Long prioriteId, Principal principal) {
		prioriteRepository.deleteById(prioriteId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet priorites
	@PutMapping(value = "/{prioriteId}")
	public ResponseEntity<Priorite> updateBook(@PathVariable("prioriteId") String prioriteId, @Valid @RequestBody Priorite priorite, Principal principal) {
		priorite.setId(Long.valueOf(prioriteId));
		Priorite prioriteToSave = prioriteRepository.save(priorite);
		return new ResponseEntity<Priorite>(prioriteToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet priorites pour voir l'afficher
	@GetMapping("/{prioriteId}")
	public ResponseEntity<Priorite> loadPriorite(@PathVariable("prioriteId") String prioriteId) {
		Optional<Priorite> priorite = prioriteRepository.findById(Long.valueOf(prioriteId));
		return new ResponseEntity<Priorite>(priorite.get(), HttpStatus.OK);
	}

}