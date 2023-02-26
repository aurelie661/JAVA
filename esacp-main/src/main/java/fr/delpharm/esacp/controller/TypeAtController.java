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

import fr.delpharm.esacp.domain.TypeAt;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.TypeAtService;
/**
 * 
 * @author GS
 * API CRUD typeAts
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typeAts")
public class TypeAtController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TypeAtService typeAtRepository;

	// Permet de d'afficher une liste d'objet typeAts
	@GetMapping
	public ResponseEntity<List<TypeAt>> listTypeAts(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<TypeAt> typeAts = typeAtRepository.findAll();
		return new ResponseEntity<List<TypeAt>>(typeAts, HttpStatus.OK);
	}

	// Permet d'afficher une liste d'objet typeAts en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<TypeAt>> listTypeAtsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<TypeAt> typeAts = typeAtRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<TypeAt>>(typeAts, HttpStatus.OK);
	}

	// Permet d'ajouter un objet typeAts
	@PostMapping
	public ResponseEntity<TypeAt> addTypeAt(@RequestBody @Valid TypeAt typeAt, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		typeAtRepository.save(typeAt);
		return new ResponseEntity<TypeAt>(typeAt, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet typeAts
	@DeleteMapping(value = "/{typeAtId}")
	public ResponseEntity<Object> deleteTypeAt(@PathVariable("typeAtId") Long typeAtId, Principal principal) {
		typeAtRepository.deleteById(typeAtId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet typeAts
	@PutMapping(value = "/{typeAtId}")
	public ResponseEntity<TypeAt> updateBook(@PathVariable("typeAtId") String typeAtId, @Valid @RequestBody TypeAt typeAt, Principal principal) {
		typeAt.setId(Long.valueOf(typeAtId));
		TypeAt typeAtToSave = typeAtRepository.save(typeAt);
		return new ResponseEntity<TypeAt>(typeAtToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet typeAts pour voir l'afficher
	@GetMapping("/{typeAtId}")
	public ResponseEntity<TypeAt> loadTypeAt(@PathVariable("typeAtId") String typeAtId) {
		Optional<TypeAt> typeAt = typeAtRepository.findById(Long.valueOf(typeAtId));
		return new ResponseEntity<TypeAt>(typeAt.get(), HttpStatus.OK);
	}

}