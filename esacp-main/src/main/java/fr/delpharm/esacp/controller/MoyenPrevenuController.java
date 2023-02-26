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

import fr.delpharm.esacp.domain.MoyenPrevenu;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.MoyenPrevenuService;
/**
 * 
 * @author GS
 * API CRUD moyenprevenus
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/moyenprevenus")
public class MoyenPrevenuController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MoyenPrevenuService moyenRepository;

	// Permet de d'afficher une liste d'objet moyenprevenus
	@GetMapping
	public ResponseEntity<List<MoyenPrevenu>> listCategories(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<MoyenPrevenu> moyens = moyenRepository.findAll();
		return new ResponseEntity<List<MoyenPrevenu>>(moyens, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet moyenprevenus en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<MoyenPrevenu>> listCategoriesaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<MoyenPrevenu> moyens = moyenRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<MoyenPrevenu>>(moyens, HttpStatus.OK);
	}

	// Permet d'ajouter un objet moyenprevenus
	@PostMapping
	public ResponseEntity<MoyenPrevenu> addMoyen(@RequestBody @Valid MoyenPrevenu moyen, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
//		if (user.isPresent()) {
//			user.setUser(user.get());
//		} else {
//			return new ResponseEntity("You must provide a valid user", HttpStatus.BAD_REQUEST);
//		}
		moyenRepository.save(moyen);
		return new ResponseEntity<MoyenPrevenu>(moyen, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet moyenprevenus
	@DeleteMapping(value = "/{moyenId}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable("moyenId") Long moyenId, Principal principal) {
		moyenRepository.deleteById(moyenId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet moyenprevenus
	@PutMapping(value = "/{moyenId}")
	public ResponseEntity<MoyenPrevenu> updateBook(@PathVariable("moyenId") String moyenId, @Valid @RequestBody MoyenPrevenu moyen, Principal principal) {
		moyen.setId(Long.valueOf(moyenId));
		MoyenPrevenu moyenToSave = moyenRepository.save(moyen);
		return new ResponseEntity<MoyenPrevenu>(moyenToSave, HttpStatus.OK);
	}
	
	// Permet de récuperer un objet moyenprevenus pour voir l'afficher
	@GetMapping("/{moyenId}")
	public ResponseEntity<MoyenPrevenu> loadMoyen(@PathVariable("moyenId") String moyenId) {
		Optional<MoyenPrevenu> moyen = moyenRepository.findById(Long.valueOf(moyenId));
		return new ResponseEntity<MoyenPrevenu>(moyen.get(), HttpStatus.OK);
	}

}
