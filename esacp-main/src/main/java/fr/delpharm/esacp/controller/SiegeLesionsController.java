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

import fr.delpharm.esacp.domain.SiegeLesions;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.SiegeLesionsService;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author GS
 * API CRUD siegeLesionss
 */
@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/siegeLesionss")
public class SiegeLesionsController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SiegeLesionsService siegeLesionsRepository;

	// Permet de d'afficher une liste d'objet siegeLesionss
	@GetMapping
	public ResponseEntity<List<SiegeLesions>> listSiegeLesionss(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<SiegeLesions> siegeLesionss = siegeLesionsRepository.findAll();
		return new ResponseEntity<List<SiegeLesions>>(siegeLesionss, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet siegeLesionss en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<SiegeLesions>> listSiegeLesionssaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<SiegeLesions> siegeLesionss = siegeLesionsRepository.findByIsAfficheTrue();
		log.info(siegeLesionss.toString());
		return new ResponseEntity<List<SiegeLesions>>(siegeLesionss, HttpStatus.OK);
	}

	// Permet d'ajouter un objet siegeLesionss
	@PostMapping
	public ResponseEntity<SiegeLesions> addSiegeLesions(@RequestBody @Valid SiegeLesions siegeLesions, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		siegeLesionsRepository.save(siegeLesions);
		return new ResponseEntity<SiegeLesions>(siegeLesions, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet siegeLesionss
	@DeleteMapping(value = "/{siegeLesionsId}")
	public ResponseEntity<Object> deleteSiegeLesions(@PathVariable("siegeLesionsId") Long siegeLesionsId, Principal principal) {
		siegeLesionsRepository.deleteById(siegeLesionsId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet siegeLesionss
	@PutMapping(value = "/{siegeLesionsId}")
	public ResponseEntity<SiegeLesions> updateBook(@PathVariable("siegeLesionsId") String siegeLesionsId, @Valid @RequestBody SiegeLesions siegeLesions, Principal principal) {
		siegeLesions.setId(Long.valueOf(siegeLesionsId));
		SiegeLesions siegeLesionsToSave = siegeLesionsRepository.save(siegeLesions);
		return new ResponseEntity<SiegeLesions>(siegeLesionsToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet siegeLesionss pour voir l'afficher
	@GetMapping("/{siegeLesionsId}")
	public ResponseEntity<SiegeLesions> loadSiegeLesions(@PathVariable("siegeLesionsId") String siegeLesionsId) {
		Optional<SiegeLesions> siegeLesions = siegeLesionsRepository.findById(Long.valueOf(siegeLesionsId));
		return new ResponseEntity<SiegeLesions>(siegeLesions.get(), HttpStatus.OK);
	}

}