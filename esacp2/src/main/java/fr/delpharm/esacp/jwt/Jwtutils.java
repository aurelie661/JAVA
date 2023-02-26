package fr.delpharm.esacp.jwt;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import fr.delpharm.esacp.config.MyUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class Jwtutils {

   public static final long JWT_TOKEN_VALIDITY = 60 * 60 * 30;

   @Value("${jwt.secret}")
   private String secret;

   public String generateToken(MyUserDetailService.UserPrincipal userDetails) {
       Map<String, Object> claims = new HashMap<>();
       return doGenerateToken(claims, userDetails.getUsername());
   }

   private String doGenerateToken(Map<String, Object> claims, String subject) {
       return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
               .signWith(SignatureAlgorithm.HS512, secret).compact();
   }

   //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

   private Boolean isTokenExpired(String token) {
       final Date expiration = getExpirationDateFromToken(token);
       return expiration.before(new Date());
   }

   //retrieve expiration date from jwt token
   public Date getExpirationDateFromToken(String token) {
       return getClaimFromToken(token, Claims::getExpiration);
   }

   String getUsernameFromToken(String token) {
       return getClaimFromToken(token, Claims::getSubject);
   }

   private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
       final Claims claims = getAllClaimsFromToken(token);
       return claimsResolver.apply(claims);
   }

   //for retrieveing any information from token we will need the secret key
   private Claims getAllClaimsFromToken(String token) {
       return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
   }

}
