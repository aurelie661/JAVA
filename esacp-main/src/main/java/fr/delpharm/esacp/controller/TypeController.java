package fr.delpharm.esacp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.delpharm.esacp.domain.Repartition;
import fr.delpharm.esacp.domain.Type;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.RepartitionService;
import fr.delpharm.esacp.service.TypeService;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author GS
 * API CRUD types
 */
@Slf4j
@RestController
@RequestMapping("/types")
public class TypeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TypeService typeRepository;

	@Autowired
	private RepartitionService repartitionRepository;

	// Permet de d'afficher une liste d'objet types
	@GetMapping
	public ResponseEntity<List<Type>> listTypes(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Type> types = typeRepository.findAll();
		return new ResponseEntity<List<Type>>(types, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet types en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<Type>> listTypesaffiche(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Type> types = typeRepository.findByIsAfficheTrue();
		return new ResponseEntity<List<Type>>(types, HttpStatus.OK);
	}

	// Permet d'ajouter un objet types
	@PostMapping
	public ResponseEntity<Type> addType(@RequestBody @Valid Type type, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
		Optional<Repartition> repartition = repartitionRepository.findById(type.getRepartitionId());
		if (repartition.isPresent()) {
			type.setRepartition(repartition.get());
		} else {
			return new ResponseEntity<Type>(HttpStatus.BAD_REQUEST);
		}
		typeRepository.save(type);
		return new ResponseEntity<Type>(type, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet types
	@DeleteMapping(value = "/{typeId}")
	public ResponseEntity<Object> deleteType(@PathVariable("typeId") Long typeId, Principal principal) {
		typeRepository.deleteById(typeId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet types
	@PutMapping(value = "/{typeId}")
	public ResponseEntity<Type> updateBook(@PathVariable("typeId") String typeId, @Valid @RequestBody Type type,
			Principal principal) {
		Optional<Type> typeToUpdate = typeRepository.findById(Long.valueOf(typeId));
		log.info("le type envoyer" + type.toString());
		if (!typeToUpdate.isPresent()) {
			return new ResponseEntity<Type>(HttpStatus.BAD_REQUEST);
		}
		log.info("typeRepository.findById(Long.valueOf(typeId)" + typeToUpdate.toString());
		Type typeToSave = typeToUpdate.get();
		Optional<Repartition> repartition = repartitionRepository.findById(type.getRepartitionId());
		typeToSave.setRepartition(repartition.get());
		typeToSave.setAccOrigine(type.getAccOrigine());
		typeToSave.setOrigine(type.getOrigine());
		typeRepository.save(typeToSave);
		return new ResponseEntity<Type>(type, HttpStatus.OK);
	}

	// Permet de récuperer un objet types pour voir l'afficher
	@GetMapping("/{typeId}")
	public ResponseEntity<Type> loadType(@PathVariable("typeId") String typeId) {
		Optional<Type> type = typeRepository.findById(Long.valueOf(typeId));
		return new ResponseEntity<Type>(type.get(), HttpStatus.OK);
	}

}