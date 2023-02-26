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

import fr.delpharm.esacp.domain.Sexe;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.SexeService;
/**
 * 
 * @author GS
 * API CRUD sexes
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sexes")
public class SexeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SexeService sexeRepository;

	// Permet de d'afficher une liste d'objet sexes
	@GetMapping
	public ResponseEntity<List<Sexe>> listSexes(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Sexe> sexes = sexeRepository.findAll();
		return new ResponseEntity<List<Sexe>>(sexes, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet sexes en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Sexe>> listSexesaffiches(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Sexe> sexes = sexeRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Sexe>>(sexes, HttpStatus.OK);
	}

	// Permet d'ajouter un objet sexes
	@PostMapping
	public ResponseEntity<Sexe> addSexe(@RequestBody @Valid Sexe sexe, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		sexeRepository.save(sexe);
		return new ResponseEntity<Sexe>(sexe, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet sexes
	@DeleteMapping(value = "/{sexeId}")
	public ResponseEntity<Object> deleteSexe(@PathVariable("sexeId") Long sexeId, Principal principal) {
		sexeRepository.deleteById(sexeId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet sexes
	@PutMapping(value = "/{sexeId}")
	public ResponseEntity<Sexe> updateBook(@PathVariable("sexeId") String sexeId, @Valid @RequestBody Sexe sexe, Principal principal) {
		sexe.setId(Long.valueOf(sexeId));
		Sexe sexeToSave = sexeRepository.save(sexe);
		return new ResponseEntity<Sexe>(sexeToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet sexes pour voir l'afficher
	@GetMapping("/{sexeId}")
	public ResponseEntity<Sexe> loadSexe(@PathVariable("sexeId") String sexeId) {
		Optional<Sexe> sexe = sexeRepository.findById(Long.valueOf(sexeId));
		return new ResponseEntity<Sexe>(sexe.get(), HttpStatus.OK);
	}

}