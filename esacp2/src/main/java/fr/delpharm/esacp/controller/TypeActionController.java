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

import fr.delpharm.esacp.domain.TypeAction;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.TypeActionRepository;
import fr.delpharm.esacp.repository.UserRepository;
/**
 * 
 * @author GS
 * API CRUD typeActions
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typeActions")
public class TypeActionController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TypeActionRepository typeActionRepository;

	// Permet de d'afficher une liste d'objet typeActions
	@GetMapping
	public ResponseEntity<List<TypeAction>> listTypeActions(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<TypeAction> typeActions = typeActionRepository.findAll();
		return new ResponseEntity<List<TypeAction>>(typeActions, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet typeActions en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<TypeAction>> listTypeActionsaffiches(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<TypeAction> typeActions = typeActionRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<TypeAction>>(typeActions, HttpStatus.OK);
	}

	// Permet d'ajouter un objet typeActions
	@PostMapping
	public ResponseEntity<TypeAction> addTypeAction(@RequestBody @Valid TypeAction typeAction, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		typeActionRepository.save(typeAction);
		return new ResponseEntity<TypeAction>(typeAction, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet typeActions
	@DeleteMapping(value = "/{typeActionId}")
	public ResponseEntity<Object> deleteTypeAction(@PathVariable("typeActionId") Long typeActionId, Principal principal) {
		typeActionRepository.deleteById(typeActionId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet typeActions
	@PutMapping(value = "/{typeActionId}")
	public ResponseEntity<TypeAction> updateBook(@PathVariable("typeActionId") String typeActionId, @Valid @RequestBody TypeAction typeAction, Principal principal) {
		typeAction.setId(Long.valueOf(typeActionId));
		TypeAction typeActionToSave = typeActionRepository.save(typeAction);
		return new ResponseEntity<TypeAction>(typeActionToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet typeActions pour voir l'afficher
	@GetMapping("/{typeActionId}")
	public ResponseEntity<TypeAction> loadTypeAction(@PathVariable("typeActionId") String typeActionId) {
		Optional<TypeAction> typeAction = typeActionRepository.findById(Long.valueOf(typeActionId));
		return new ResponseEntity<TypeAction>(typeAction.get(), HttpStatus.OK);
	}

}