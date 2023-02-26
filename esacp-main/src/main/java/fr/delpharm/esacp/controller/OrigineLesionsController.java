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

import fr.delpharm.esacp.domain.OrigineLesions;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.OrigineLesionsService;
/**
 * 
 * @author GS
 * API CRUD origineLesionss
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/origineLesionss")
public class OrigineLesionsController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrigineLesionsService origineLesionsRepository;

	// Permet de d'afficher une liste d'objet origineLesionss
	@GetMapping
	public ResponseEntity<List<OrigineLesions>> listOrigineLesionss(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<OrigineLesions> origineLesionss = origineLesionsRepository.findAll();
		return new ResponseEntity<List<OrigineLesions>>(origineLesionss, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet origineLesionss en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<OrigineLesions>> listOrigineLesionssaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<OrigineLesions> origineLesionss = origineLesionsRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<OrigineLesions>>(origineLesionss, HttpStatus.OK);
	}
	
	// Permet d'ajouter un objet origineLesionss
	@PostMapping
	public ResponseEntity<OrigineLesions> addOrigineLesions(@RequestBody @Valid OrigineLesions origineLesions, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		origineLesionsRepository.save(origineLesions);
		return new ResponseEntity<OrigineLesions>(origineLesions, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet origineLesionss
	@DeleteMapping(value = "/{origineLesionsId}")
	public ResponseEntity<Object> deleteOrigineLesions(@PathVariable("origineLesionsId") Long origineLesionsId, Principal principal) {
		origineLesionsRepository.deleteById(origineLesionsId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet origineLesionss
	@PutMapping(value = "/{origineLesionsId}")
	public ResponseEntity<OrigineLesions> updateBook(@PathVariable("origineLesionsId") String origineLesionsId, @Valid @RequestBody OrigineLesions origineLesions, Principal principal) {
		origineLesions.setId(Long.valueOf(origineLesionsId));
		OrigineLesions origineLesionsToSave = origineLesionsRepository.save(origineLesions);
		return new ResponseEntity<OrigineLesions>(origineLesionsToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet origineLesionss pour voir l'afficher
	@GetMapping("/{origineLesionsId}")
	public ResponseEntity<OrigineLesions> loadOrigineLesions(@PathVariable("origineLesionsId") String origineLesionsId) {
		Optional<OrigineLesions> origineLesions = origineLesionsRepository.findById(Long.valueOf(origineLesionsId));
		return new ResponseEntity<OrigineLesions>(origineLesions.get(), HttpStatus.OK);
	}

}