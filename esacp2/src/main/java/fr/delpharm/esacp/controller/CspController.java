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

import fr.delpharm.esacp.domain.Csp;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.CspService;
/**
 * 
 * @author GS
 * API CRUD csps
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/csps")
public class CspController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CspService cspRepository;

	// Permet de d'afficher une liste d'objet csp
	@GetMapping
	public ResponseEntity<List<Csp>> listCsps(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Csp> csps = cspRepository.findAll();
		return new ResponseEntity<List<Csp>>(csps, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet csp en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Csp>> listCspsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Csp> csps = cspRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Csp>>(csps, HttpStatus.OK);
	}

	// Permet d'ajouter un objet csp
	@PostMapping
	public ResponseEntity<Csp> addCsp(@RequestBody @Valid Csp csp, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		cspRepository.save(csp);
		return new ResponseEntity<Csp>(csp, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet csp
	@DeleteMapping(value = "/{cspId}")
	public ResponseEntity<Object> deleteCsp(@PathVariable("cspId") Long cspId, Principal principal) {
		cspRepository.deleteById(cspId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	// Permet de modifier un objet csp
	@PutMapping(value = "/{cspId}")
	public ResponseEntity<Csp> updateBook(@PathVariable("cspId") String cspId, @Valid @RequestBody Csp csp, Principal principal) {
		csp.setId(Long.valueOf(cspId));
		Csp cspToSave = cspRepository.save(csp);
		return new ResponseEntity<Csp>(cspToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet csp pour voir l'afficher
	@GetMapping("/{cspId}")
	public ResponseEntity<Csp> loadCsp(@PathVariable("cspId") String cspId) {
		Optional<Csp> csp = cspRepository.findById(Long.valueOf(cspId));
		return new ResponseEntity<Csp>(csp.get(), HttpStatus.OK);
	}

}
