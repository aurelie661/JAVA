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

import fr.delpharm.esacp.domain.Departement;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.DepartementService;
/**
 * 
 * @author GS
 * API CRUD departements
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departements")
public class DepartementController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DepartementService departementRepository;

	// Permet de d'afficher une liste d'objet departements
	@GetMapping
	public ResponseEntity<List<Departement>> listDepartements(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Departement> departements = departementRepository.findAll();
		return new ResponseEntity<List<Departement>>(departements, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet departements en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Departement>> listDepartementsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Departement> departements = departementRepository.findAll();
		return new ResponseEntity<List<Departement>>(departements, HttpStatus.OK);
	}

	// Permet d'ajouter un objet departements
	@PostMapping
	public ResponseEntity<Departement> addDepartement(@RequestBody @Valid Departement departement, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		departementRepository.save(departement);
		return new ResponseEntity<Departement>(departement, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet departements
	@DeleteMapping(value = "/{departementId}")
	public ResponseEntity<Object> deleteDepartement(@PathVariable("departementId") Long departementId, Principal principal) {
		departementRepository.deleteById(departementId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	// Permet de modifier un objet departements
	@PutMapping(value = "/{departementId}")
	public ResponseEntity<Departement> updateBook(@PathVariable("departementId") String departementId, @Valid @RequestBody Departement departement, Principal principal) {
		departement.setId(Long.valueOf(departementId));
		Departement departementToSave = departementRepository.save(departement);
		return new ResponseEntity<Departement>(departementToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet departements pour voir l'afficher	
	@GetMapping("/{departementId}")
	public ResponseEntity<Departement> loadDepartement(@PathVariable("departementId") String departementId) {
		Optional<Departement> departement = departementRepository.findById(Long.valueOf(departementId));
		return new ResponseEntity<Departement>(departement.get(), HttpStatus.OK);
	}

}