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

import fr.delpharm.esacp.domain.TypeRapport;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.TypeRapportService;
/**
 * 
 * @author GS
 * API CRUD typeRapports
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typeRapports")
public class TypeRapportController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TypeRapportService typeRapportRepository;

	// Permet de d'afficher une liste d'objet typeRapports
	@GetMapping
	public ResponseEntity<List<TypeRapport>> listTypeRapports(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<TypeRapport> typeRapports = typeRapportRepository.findAll();
		return new ResponseEntity<List<TypeRapport>>(typeRapports, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet typeRapports en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<TypeRapport>> listTypeRapportsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<TypeRapport> typeRapports = typeRapportRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<TypeRapport>>(typeRapports, HttpStatus.OK);
	}

	// Permet d'ajouter un objet typeRapports
	@PostMapping
	public ResponseEntity<TypeRapport> addTypeRapport(@RequestBody @Valid TypeRapport typeRapport, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		typeRapportRepository.save(typeRapport);
		return new ResponseEntity<TypeRapport>(typeRapport, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet typeRapports
	@DeleteMapping(value = "/{typeRapportId}")
	public ResponseEntity<Object> deleteTypeRapport(@PathVariable("typeRapportId") Long typeRapportId, Principal principal) {
		typeRapportRepository.deleteById(typeRapportId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet typeRapports
	@PutMapping(value = "/{typeRapportId}")
	public ResponseEntity<TypeRapport> updateBook(@PathVariable("typeRapportId") String typeRapportId, @Valid @RequestBody TypeRapport typeRapport, Principal principal) {
		typeRapport.setId(Long.valueOf(typeRapportId));
		TypeRapport typeRapportToSave = typeRapportRepository.save(typeRapport);
		return new ResponseEntity<TypeRapport>(typeRapportToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet typeRapports pour voir l'afficher
	@GetMapping("/{typeRapportId}")
	public ResponseEntity<TypeRapport> loadTypeRapport(@PathVariable("typeRapportId") String typeRapportId) {
		Optional<TypeRapport> typeRapport = typeRapportRepository.findById(Long.valueOf(typeRapportId));
		return new ResponseEntity<TypeRapport>(typeRapport.get(), HttpStatus.OK);
	}

}