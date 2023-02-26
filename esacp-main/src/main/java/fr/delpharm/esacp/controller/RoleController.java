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

import fr.delpharm.esacp.domain.Role;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.RoleService;
/**
 * 
 * @author GS
 * API CRUD roles
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleRepository;

	// Permet de d'afficher une liste d'objet Role
	@GetMapping
	public ResponseEntity<List<Role>> listRoles(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Role> roles = roleRepository.findAll();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}

	// Permet d'ajouter un objet Role
	@PostMapping
	public ResponseEntity<Role> addRole(@RequestBody @Valid Role role, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Optional<User> user = userRepository.findById(userConnectedId);
//		if (user.isPresent()) {
//			user.setUser(user.get());
//		} else {
//			return new ResponseEntity("You must provide a valid user", HttpStatus.BAD_REQUEST);
//		}
		roleRepository.save(role);
		return new ResponseEntity<Role>(role, HttpStatus.CREATED);
	}

	// Permet de supprimer un objet Role
	@DeleteMapping(value = "/{roleId}")
	public ResponseEntity<Object> deleteRole(@PathVariable("roleId") Long roleId, Principal principal) {
		roleRepository.deleteById(roleId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet Role
	@PutMapping(value = "/{roleId}")
	public ResponseEntity<Role> updateBook(@PathVariable("roleId") String roleId, @Valid @RequestBody Role role, Principal principal) {
		role.setId(Long.valueOf(roleId));
		Role roleToSave = roleRepository.save(role);
		return new ResponseEntity<Role>(roleToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet Role pour voir l'afficher
	@GetMapping("/{roleId}")
	public ResponseEntity<Role> loadRole(@PathVariable("roleId") String roleId) {
		Optional<Role> role = roleRepository.findById(Long.valueOf(roleId));
		return new ResponseEntity<Role>(role.get(), HttpStatus.OK);
	}

}
