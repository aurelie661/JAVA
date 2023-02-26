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

import fr.delpharm.esacp.domain.EtapeValidation;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.EtapeValidationService;
/**
 * 
 * @author GS
 * API CRUD etapeValidations
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/etapeValidations")
public class EtapeValidationController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EtapeValidationService etapeValidationRepository;

	// Permet de d'afficher une liste d'objet etapeValidations
	@GetMapping
	public ResponseEntity<List<EtapeValidation>> listEtapeValidations(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<EtapeValidation> etapeValidations = etapeValidationRepository.findAll();
		return new ResponseEntity<List<EtapeValidation>>(etapeValidations, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet etapeValidations en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<EtapeValidation>> listEtapeValidationsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<EtapeValidation> etapeValidations = etapeValidationRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<EtapeValidation>>(etapeValidations, HttpStatus.OK);
	}

	// Permet d'ajouter un objet etapeValidations
	@PostMapping
	public ResponseEntity<EtapeValidation> addEtapeValidation(@RequestBody @Valid EtapeValidation etapeValidation, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		etapeValidationRepository.save(etapeValidation);
		return new ResponseEntity<EtapeValidation>(etapeValidation, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet etapeValidations
	@DeleteMapping(value = "/{etapeValidationId}")
	public ResponseEntity<Object> deleteEtapeValidation(@PathVariable("etapeValidationId") Long etapeValidationId, Principal principal) {
		etapeValidationRepository.deleteById(etapeValidationId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet etapeValidations
	@PutMapping(value = "/{etapeValidationId}")
	public ResponseEntity<EtapeValidation> updateBook(@PathVariable("etapeValidationId") String etapeValidationId, @Valid @RequestBody EtapeValidation etapeValidation, Principal principal) {
		etapeValidation.setId(Long.valueOf(etapeValidationId));
		EtapeValidation etapeValidationToSave = etapeValidationRepository.save(etapeValidation);
		return new ResponseEntity<EtapeValidation>(etapeValidationToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet etapeValidations pour voir l'afficher
	@GetMapping("/{etapeValidationId}")
	public ResponseEntity<EtapeValidation> loadEtapeValidation(@PathVariable("etapeValidationId") String etapeValidationId) {
		Optional<EtapeValidation> etapeValidation = etapeValidationRepository.findById(Long.valueOf(etapeValidationId));
		return new ResponseEntity<EtapeValidation>(etapeValidation.get(), HttpStatus.OK);
	}

}