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

import fr.delpharm.esacp.domain.Equipement;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.EquipementService;
/**
 * 
 * @author GS
 * API CRUD equipements
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/equipements")
public class EquipementController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EquipementService equipementRepository;

	// Permet de d'afficher une liste d'objet equipements
	@GetMapping
	public ResponseEntity<List<Equipement>> listEquipements(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Equipement> equipements = equipementRepository.findAll();
		return new ResponseEntity<List<Equipement>>(equipements, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet equipements en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Equipement>> listEquipementsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Equipement> equipements = equipementRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Equipement>>(equipements, HttpStatus.OK);
	}

	// Permet d'ajouter un objet equipements
	@PostMapping
	public ResponseEntity<Equipement> addEquipement(@RequestBody @Valid Equipement equipement, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		equipementRepository.save(equipement);
		return new ResponseEntity<Equipement>(equipement, HttpStatus.CREATED);
	}
	
	// Permet de supprimer un objet equipements
	@DeleteMapping(value = "/{equipementId}")
	public ResponseEntity<Object> deleteEquipement(@PathVariable("equipementId") Long equipementId, Principal principal) {
		equipementRepository.deleteById(equipementId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet equipements
	@PutMapping(value = "/{equipementId}")
	public ResponseEntity<Equipement> updateBook(@PathVariable("equipementId") String equipementId, @Valid @RequestBody Equipement equipement, Principal principal) {
		equipement.setId(Long.valueOf(equipementId));
		Equipement equipementToSave = equipementRepository.save(equipement);
		return new ResponseEntity<Equipement>(equipementToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet equipements pour voir l'afficher
	@GetMapping("/{equipementId}")
	public ResponseEntity<Equipement> loadEquipement(@PathVariable("equipementId") String equipementId) {
		Optional<Equipement> equipement = equipementRepository.findById(Long.valueOf(equipementId));
		return new ResponseEntity<Equipement>(equipement.get(), HttpStatus.OK);
	}

}