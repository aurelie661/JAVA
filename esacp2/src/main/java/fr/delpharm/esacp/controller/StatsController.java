package fr.delpharm.esacp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.delpharm.esacp.repository.ActionRepository;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author GS
 * API CRUD stats
 */
@Slf4j
@RestController
@RequestMapping("/stats")
public class StatsController {

	@Autowired
	private ActionRepository actionRepository;

	// permet d'afficher list des stats sur 12 mois glissant
	@GetMapping
	public ResponseEntity<List<Object>> liststats(Principal principal) {
		log.info("je suis dans la fonction stats");
		// Long userConnectedId = UserController.getUserConnectedId(principal);
		log.info("je suis dans la fonction stats");
		List<Object> actions = actionRepository.liststat();
		log.info(actions.toString());
		return new ResponseEntity<List<Object>>(actions, HttpStatus.OK);
	}

}
