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

import fr.delpharm.esacp.domain.Repartition;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.RepartitionService;
/**
 * 
 * @author GS
 * API CRUD repartitions
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/repartitions")
public class RepartitionController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RepartitionService repartitionRepository;

	// Permet de d'afficher une liste d'objet repartitions
	@GetMapping
	public ResponseEntity<List<Repartition>> listRepartitions(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Repartition> repartitions = repartitionRepository.findAll();
		return new ResponseEntity<List<Repartition>>(repartitions, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet repartitions en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Repartition>> listRepartitionsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Repartition> repartitions = repartitionRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Repartition>>(repartitions, HttpStatus.OK);
	}

	// Permet d'ajouter un objet repartitions
	@PostMapping
	public ResponseEntity<Repartition> addRepartition(@RequestBody @Valid Repartition repartition, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		repartitionRepository.save(repartition);
		return new ResponseEntity<Repartition>(repartition, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet repartitions
	@DeleteMapping(value = "/{repartitionId}")
	public ResponseEntity<Object> deleteRepartition(@PathVariable("repartitionId") Long repartitionId, Principal principal) {
		repartitionRepository.deleteById(repartitionId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet repartitions
	@PutMapping(value = "/{repartitionId}")
	public ResponseEntity<Repartition> updateBook(@PathVariable("repartitionId") String repartitionId, @Valid @RequestBody Repartition repartition, Principal principal) {
		repartition.setId(Long.valueOf(repartitionId));
		Repartition repartitionToSave = repartitionRepository.save(repartition);
		return new ResponseEntity<Repartition>(repartitionToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet repartitions pour voir l'afficher
	@GetMapping("/{repartitionId}")
	public ResponseEntity<Repartition> loadRepartition(@PathVariable("repartitionId") String repartitionId) {
		Optional<Repartition> repartition = repartitionRepository.findById(Long.valueOf(repartitionId));
		return new ResponseEntity<Repartition>(repartition.get(), HttpStatus.OK);
	}

}