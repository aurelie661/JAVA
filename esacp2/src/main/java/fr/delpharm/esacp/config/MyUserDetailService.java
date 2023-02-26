package fr.delpharm.esacp.config;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.delpharm.esacp.domain.Role;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.UserRepository;

/**
 * @author Guillaume SOULAT
 * Mise en place de MyUserDetailService qui implémente des méthodes de userDetailsService
 * 
 */


@Service
public class MyUserDetailService implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       List<User> users = userRepository.findByEmail(login);
       if (users.isEmpty()) {
           throw new UsernameNotFoundException(login);
       }
       return new UserPrincipal(users.get(0));
   }

   /**
    * @author Guillaume SOULAT
    * Mise en place de UserPrincipal qui implémente des méthodes de userDetails
    *	
    */
   
   public static class UserPrincipal implements UserDetails {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User getUser() {
           return user;
       }

       public void setUser(User user) {
           this.user = user;
       }

       private User user;

       public UserPrincipal(User user) {
           this.user = user;
       }

       @Override
       public Collection<? extends GrantedAuthority> getAuthorities() {
    	     Role role = user.getRole();
    	     
           final List<GrantedAuthority> authorities = new ArrayList<>();
           authorities.add(new SimpleGrantedAuthority("USER"));
          return authorities;
       }

       @Override
       public String getPassword() {
           return this.user.getPassword();
       }

       @Override
       public String getUsername() {
           return this.user.getEmail();
       }

       @Override
       public boolean isAccountNonExpired() {
           return true;
       }

       @Override
       public boolean isAccountNonLocked() {
           return true;
       }

       @Override
       public boolean isCredentialsNonExpired() {
           return true;
       }

       @Override
       public boolean isEnabled() {
           return true;
       }
   }

}
