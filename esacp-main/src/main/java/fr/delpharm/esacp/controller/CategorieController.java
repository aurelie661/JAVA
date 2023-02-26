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

import fr.delpharm.esacp.domain.Categorie;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.CategorieService;

/**
 * 
 * @author GS
 * API CRUD categories
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
public class CategorieController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategorieService categorieRepository;

	// Permet de d'afficher une liste de catégories
	@GetMapping
	public ResponseEntity<List<Categorie>> listCategories(Principal principal) {
		UserController.getUserConnectedId(principal);
		List<Categorie> categories = categorieRepository.findAll();
		return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste de catégories en filtrant sur un Boolean = "True" 
	@GetMapping("/affiche")
	public ResponseEntity<List<Categorie>> listCategoriesAffiche(Principal principal) {
		UserController.getUserConnectedId(principal);
		List<Categorie> categories = categorieRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
	}

	// Permet d'ajouter une catégorie
	@PostMapping
	public ResponseEntity<Categorie> addCategorie(@RequestBody @Valid Categorie categorie, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
//		if (user.isPresent()) {
//			user.setUser(user.get());
//		} else {
//			return new ResponseEntity("You must provide a valid user", HttpStatus.BAD_REQUEST);
//		}
		categorieRepository.save(categorie);
		return new ResponseEntity<Categorie>(categorie, HttpStatus.CREATED);
	}

	// Permet de supprimer une catégorie
	@DeleteMapping(value = "/{categorieId}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable("categorieId") Long categorieId, Principal principal) {
		categorieRepository.deleteById(categorieId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier une catégorie
	@PutMapping(value = "/{categorieId}")
	public ResponseEntity<Categorie> updateBook(@PathVariable("categorieId") String categorieId, @Valid @RequestBody Categorie categorie, Principal principal) {
		categorie.setId(Long.valueOf(categorieId));
		Categorie categorieToSave = categorieRepository.save(categorie);
		return new ResponseEntity<Categorie>(categorieToSave, HttpStatus.OK);
	}

	// Permet de récuperer une catégorie pour voir l'afficher
	@GetMapping("/{categorieId}")
	public ResponseEntity<Categorie> loadCategorie(@PathVariable("categorieId") String categorieId) {
		Optional<Categorie> categorie = categorieRepository.findById(Long.valueOf(categorieId));
		return new ResponseEntity<Categorie>(categorie.get(), HttpStatus.OK);
	}

}
