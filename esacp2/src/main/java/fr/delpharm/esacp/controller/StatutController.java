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

import fr.delpharm.esacp.domain.Statut;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.StatutService;
/**
 * 
 * @author GS
 * API CRUD statuts
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/statuts")
public class StatutController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StatutService statutRepository;

	// Permet de d'afficher une liste d'objet statuts
	@GetMapping
	public ResponseEntity<List<Statut>> listStatuts(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Statut> statuts = statutRepository.findAll();
		return new ResponseEntity<List<Statut>>(statuts, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet statuts en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Statut>> listStatutsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Statut> statuts = statutRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Statut>>(statuts, HttpStatus.OK);
	}

	// Permet d'ajouter un objet statuts
	@PostMapping
	public ResponseEntity<Statut> addStatut(@RequestBody @Valid Statut statut, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		statutRepository.save(statut);
		return new ResponseEntity<Statut>(statut, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet statuts
	@DeleteMapping(value = "/{statutId}")
	public ResponseEntity<Object> deleteStatut(@PathVariable("statutId") Long statutId, Principal principal) {
		statutRepository.deleteById(statutId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet statuts
	@PutMapping(value = "/{statutId}")
	public ResponseEntity<Statut> updateBook(@PathVariable("statutId") String statutId, @Valid @RequestBody Statut statut, Principal principal) {
		statut.setId(Long.valueOf(statutId));
		Statut statutToSave = statutRepository.save(statut);
		return new ResponseEntity<Statut>(statutToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet statuts pour voir l'afficher
	@GetMapping("/{statutId}")
	public ResponseEntity<Statut> loadStatut(@PathVariable("statutId") String statutId) {
		Optional<Statut> statut = statutRepository.findById(Long.valueOf(statutId));
		return new ResponseEntity<Statut>(statut.get(), HttpStatus.OK);
	}

}