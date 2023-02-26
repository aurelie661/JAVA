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

import fr.delpharm.esacp.domain.Action;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.ActionService;
import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author GS
 * API CRUD ACTION
 */

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/actions")
public class ActionController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ActionService actionRepository;
	
	
	// Permet de d'afficher une liste d'objet action
	@GetMapping
	public ResponseEntity<List<Action>> listActions(Principal principal) {
		UserController.getUserConnectedId(principal);
		List<Action> actions = actionRepository.findAll();
		log.info(actions.toString());
		return new ResponseEntity<List<Action>>(actions, HttpStatus.OK);
	}
	
	// Permet d'ajouter une Action
	@PostMapping
	public ResponseEntity<Action> addAction(@RequestBody @Valid Action action, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		userRepository.findById(userConnectedId);
		actionRepository.save(action);
		log.info(action.toString());
		return new ResponseEntity<Action>(action, HttpStatus.CREATED);
	}

	// Permet de supprimer une Action
	@DeleteMapping(value = "/{actionId}")
	public ResponseEntity<Object> deleteAction(@PathVariable("actionId") Long actionId, Principal principal) {
		actionRepository.deleteById(actionId);
		log.info("La ligne action a été supprimé " + actionId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de Modifier une Action
	@PutMapping(value = "/{actionId}")
	public ResponseEntity<Action> updateBook(@PathVariable("actionId") String actionId, @Valid @RequestBody Action action,
			Principal principal) {
		action.setId(Long.valueOf(actionId));
		Action actionToSave = actionRepository.save(action);
		return new ResponseEntity<Action>(actionToSave, HttpStatus.OK);
	}

	// Permet de récuperer une action
	@GetMapping("/{actionId}")
	public ResponseEntity<Action> loadAction(@PathVariable("actionId") String actionId) {
		Optional<Action> action = actionRepository.findById(Long.valueOf(actionId));
		return new ResponseEntity<Action>(action.get(), HttpStatus.OK);
	}

}
