package fr.delpharm.esacp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.delpharm.esacp.config.MyUserDetailService;
import fr.delpharm.esacp.domain.Role;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.jwt.Jwtutils;
import fr.delpharm.esacp.service.RoleService;
import fr.delpharm.esacp.service.UserService;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author GS
 * API CRUD users
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userRepository;
	
	@Autowired
	private RoleService roleRepository;

	@Autowired
	private Jwtutils jwtUtils;

	// Permet d'ajouter un objet users
	@PostMapping
	public ResponseEntity<Object> addUSer(@RequestBody @Valid User user, HttpServletResponse response) {
		List<User> users = userRepository.findByEmail(user.getEmail());
		if (!users.isEmpty()) {
			return new ResponseEntity<Object>("User already existing", HttpStatus.BAD_REQUEST);
		}
		log.info("***********************************************************");
		log.info(user.toString());
		log.info("***********************************************************");
		
		Long roleID = (Long) user.getRoleID();
		Optional<Role> role = roleRepository.findById(roleID);

		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setLastName(StringUtils.capitalize(user.getLastName()));
		user.setFirstName(StringUtils.capitalize(user.getFirstName()));
		user.setRole(role.get());
		
		userRepository.save(user);
		log.info(user.toString());
		String token = jwtUtils.generateToken(new MyUserDetailService.UserPrincipal(user));
		Cookie cookie = new Cookie("token", token);
		response.addCookie(cookie);

		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
	}

	// Permet de d'afficher une liste d'objet users
	@GetMapping
	public ResponseEntity<List<User>> listCategories(Principal principal) {
		log.info("******************** U S E R S ****************************");
//		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<User> users = userRepository.findAll();
		log.info("***********************************************************");
		log.info(users.toString());
		log.info("***********************************************************");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// Permet d'afficher une liste d'objet users en filtrant sur un Boolean = "True"
	@GetMapping("/affiche")
	public ResponseEntity<List<User>> listCategoriesaffiche(Principal principal) {
		log.info("******************** U S E R S ****************************");
//		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<User> users = userRepository.findByIsAfficheTrue();
		log.info("***********************************************************");
		log.info(users.toString());
		log.info("***********************************************************");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	public static Long getUserConnectedId(Principal principal) {
		if (!(principal instanceof UsernamePasswordAuthenticationToken)) {
			throw new RuntimeException(("User not found"));
		}
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
		Long userId = ((MyUserDetailService.UserPrincipal) token.getPrincipal()).getUser().getId();

		return userId;
	}
	
	// Permet d'afficher une liste d'objet users pour savoir qui est pilote
	@GetMapping("/pilotes")
	public ResponseEntity<List<User>> listPiloteaffiche(Principal principal) {
		log.info("******************** U S E R S ****************************");
//		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<User> users = userRepository.findByPiloteTrue();
		log.info("***********************************************************");
		log.info(users.toString());
		log.info("***********************************************************");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}


	// Permet de supprimer un objet users
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId, Principal principal) {
		Optional<User> userToDelete = userRepository.findById(Integer.valueOf(userId));
		if (!userToDelete.isPresent()) {
			return new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);
		}
		User updatedUser = userToDelete.get();
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet users
	@PutMapping(value = "/{userId}")
	public ResponseEntity<Object> updateBook(@PathVariable("userId") String userId, @Valid @RequestBody User user,
			Principal principal) {
		Optional<User> userToUpdate = userRepository.findById(Integer.valueOf(userId));
		if (!userToUpdate.isPresent()) {
			return new ResponseEntity<Object>("User not existing", HttpStatus.BAD_REQUEST);
		}
		User userToSave = userToUpdate.get();
		userRepository.save(userToSave);

		return new ResponseEntity<Object>(userToSave, HttpStatus.OK);
	}

	// Permet de récuperer un objet users pour voir l'afficher
	@GetMapping("/{userId}")
	public ResponseEntity<User> loadUser(@PathVariable("userId") String userId) {
		Optional<User> user = userRepository.findById(Integer.valueOf(userId));
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}

}
