package fr.delpharm.esacp.jwt;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.delpharm.esacp.config.MyUserDetailService;

@RestController
public class JwtController {

   @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private Jwtutils jwtutils;

   @Autowired
   private MyUserDetailService service;

   @PostMapping("/authenticate")
   public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request,
                                                      HttpServletResponse response) throws Exception {

       authenticate(request.getEmail(), request.getPassword());
       MyUserDetailService.UserPrincipal principal = (MyUserDetailService.UserPrincipal) service.loadUserByUsername(request.getEmail());

       String token = jwtutils.generateToken(principal);

       Cookie cookie = new Cookie("token", token);
       response.addCookie(cookie);
       
       System.out.println("******************* ID de la personne connectée *******************" + principal.getUser().getRole());

       return ResponseEntity.ok(new JwtResponse(
               principal.getUser().getId(),
               principal.getUser().getFirstName() + " " + principal.getUser().getLastName(),
               principal.getUser().getRole().getId() ));
 

   }


   
   private void authenticate(String email, String password) {
       this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
   }

}
