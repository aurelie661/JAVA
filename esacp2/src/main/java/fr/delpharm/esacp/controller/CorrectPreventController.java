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

import fr.delpharm.esacp.domain.CorrectPrevent;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.CorrectPreventService;
/**
 * 
 * @author GS
 * API CRUD correctPrevents
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/correctPrevents")
public class CorrectPreventController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CorrectPreventService correctPreventRepository;

	// Permet de d'afficher une liste d'objet catégories
	@GetMapping
	public ResponseEntity<List<CorrectPrevent>> listCorrectPrevents(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<CorrectPrevent> correctPrevents = correctPreventRepository.findAll();
		return new ResponseEntity<List<CorrectPrevent>>(correctPrevents, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet catégories en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<CorrectPrevent>> listCorrectPreventsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<CorrectPrevent> correctPrevents = correctPreventRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<CorrectPrevent>>(correctPrevents, HttpStatus.OK);
	}

	// Permet d'ajouter un objet catégorie
	@PostMapping
	public ResponseEntity<CorrectPrevent> addCorrectPrevent(@RequestBody @Valid CorrectPrevent correctPrevent,
			Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		correctPreventRepository.save(correctPrevent);
		return new ResponseEntity<CorrectPrevent>(correctPrevent, HttpStatus.CREATED);
	}

    // Permet de supprimer un objet catégorie
	@DeleteMapping(value = "/{correctPreventId}")
	public ResponseEntity<Object> deleteCorrectPrevent(@PathVariable("correctPreventId") Long correctPreventId,
			Principal principal) {
		correctPreventRepository.deleteById(correctPreventId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet catégorie
	@PutMapping(value = "/{correctPreventId}")
	public ResponseEntity<CorrectPrevent> updateBook(@PathVariable("correctPreventId") String correctPreventId,
			@Valid @RequestBody CorrectPrevent correctPrevent, Principal principal) {
		correctPrevent.setId(Long.valueOf(correctPreventId));
		CorrectPrevent correctPreventToSave = correctPreventRepository.save(correctPrevent);
		return new ResponseEntity<CorrectPrevent>(correctPreventToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet catégorie pour voir l'afficher
	@GetMapping("/{correctPreventId}")
	public ResponseEntity<CorrectPrevent> loadCorrectPrevent(
			@PathVariable("correctPreventId") String correctPreventId) {
		Optional<CorrectPrevent> correctPrevent = correctPreventRepository.findById(Long.valueOf(correctPreventId));
		return new ResponseEntity<CorrectPrevent>(correctPrevent.get(), HttpStatus.OK);
	}

}
