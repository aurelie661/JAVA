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

import fr.delpharm.esacp.domain.NatureAccident;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.NatureAccidentService;
/**
 * 
 * @author GS
 * API CRUD natureAccidents
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/natureAccidents")
public class NatureAccidentController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NatureAccidentService natureAccidentRepository;

	// Permet de d'afficher une liste d'objet natureAccidents
	@GetMapping
	public ResponseEntity<List<NatureAccident>> listNatureAccidents(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<NatureAccident> natureAccidents = natureAccidentRepository.findAll();
		return new ResponseEntity<List<NatureAccident>>(natureAccidents, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet natureAccidents en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<NatureAccident>> listNatureAccidentsaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<NatureAccident> natureAccidents = natureAccidentRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<NatureAccident>>(natureAccidents, HttpStatus.OK);
	}

	// Permet d'ajouter un objet natureAccidents
	@PostMapping
	public ResponseEntity<NatureAccident> addNatureAccident(@RequestBody @Valid NatureAccident natureAccident, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		natureAccidentRepository.save(natureAccident);
		return new ResponseEntity<NatureAccident>(natureAccident, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet natureAccidents
	@DeleteMapping(value = "/{natureAccidentId}")
	public ResponseEntity<Object> deleteNatureAccident(@PathVariable("natureAccidentId") Long natureAccidentId, Principal principal) {
		natureAccidentRepository.deleteById(natureAccidentId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet natureAccidents
	@PutMapping(value = "/{natureAccidentId}")
	public ResponseEntity<NatureAccident> updateBook(@PathVariable("natureAccidentId") String natureAccidentId, @Valid @RequestBody NatureAccident natureAccident, Principal principal) {
		natureAccident.setId(Long.valueOf(natureAccidentId));
		NatureAccident natureAccidentToSave = natureAccidentRepository.save(natureAccident);
		return new ResponseEntity<NatureAccident>(natureAccidentToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet natureAccidents pour voir l'afficher
	@GetMapping("/{natureAccidentId}")
	public ResponseEntity<NatureAccident> loadNatureAccident(@PathVariable("natureAccidentId") String natureAccidentId) {
		Optional<NatureAccident> natureAccident = natureAccidentRepository.findById(Long.valueOf(natureAccidentId));
		return new ResponseEntity<NatureAccident>(natureAccident.get(), HttpStatus.OK);
	}

}