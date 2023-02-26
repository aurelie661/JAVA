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

import fr.delpharm.esacp.domain.Contrat;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.ContratService;
/**
 * 
 * @author GS
 * API CRUD contrats
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contrats")
public class ContratController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContratService contratRepository;

	// Peremet d'afficher une Liste de contrat
	@GetMapping
	public ResponseEntity<List<Contrat>> listContrats(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Contrat> contrats = contratRepository.findAll();
		return new ResponseEntity<List<Contrat>>(contrats, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste de Contrat en filtrant sur un Boolean = "True" 
	@GetMapping("/affiche")
	public ResponseEntity<List<Contrat>> listContratsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Contrat> contrats = contratRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Contrat>>(contrats, HttpStatus.OK);
	}

	// Permet de supprimer un Contrat
	@PostMapping
	public ResponseEntity<Contrat> addContrat(@RequestBody @Valid Contrat contrat, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		contratRepository.save(contrat);
		return new ResponseEntity<Contrat>(contrat, HttpStatus.CREATED);
	}

	// Permet de supprimer un Contrat
	@DeleteMapping(value = "/{contratId}")
	public ResponseEntity<Object> deleteContrat(@PathVariable("contratId") Long contratId, Principal principal) {
		contratRepository.deleteById(contratId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	// Permet de modifier un Contrat
	@PutMapping(value = "/{contratId}")
	public ResponseEntity<Contrat> updateBook(@PathVariable("contratId") String contratId, @Valid @RequestBody Contrat contrat, Principal principal) {
		contrat.setId(Long.valueOf(contratId));
		Contrat contratToSave = contratRepository.save(contrat);
		return new ResponseEntity<Contrat>(contratToSave, HttpStatus.OK);
	}

	// Permet de récuperer une catégorie pour voir l'afficher	
	@GetMapping("/{contratId}")
	public ResponseEntity<Contrat> loadContrat(@PathVariable("contratId") String contratId) {
		Optional<Contrat> contrat = contratRepository.findById(Long.valueOf(contratId));
		return new ResponseEntity<Contrat>(contrat.get(), HttpStatus.OK);
	}

}
