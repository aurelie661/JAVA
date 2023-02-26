package fr.delpharm.esacp.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import fr.delpharm.esacp.config.MyUserDetailService;

@Component
public class JwtFilter extends OncePerRequestFilter {

   @Autowired
   private MyUserDetailService service;

   @Autowired
   private Jwtutils jwtutils;


   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
       String requestURI = request.getRequestURI();
       Cookie[] cookies = request.getCookies();
       if (requestURI.equals("/users") || requestURI.contains("swagger") || requestURI.equals("/v2/api-docs") || cookies == null) {
           chain.doFilter(request, response);
           return;
       }

       String jwtToken = getJwtTokenFromBearerOrCookies(cookies, request.getHeader("Authorization"));

       String username = jwtutils.getUsernameFromToken(jwtToken);

       if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
           UserDetails userDetails = service.loadUserByUsername(username);
           if (jwtutils.validateToken(jwtToken, userDetails)) {
               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                       new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(userDetails);
               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }
       }
       chain.doFilter(request, response);
   }

   private String getJwtTokenFromBearerOrCookies(Cookie[] cookies, String requestTokenHeader) {
       if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
           return requestTokenHeader.substring(7);
       }
       for (Cookie cookie : cookies) {
           if (cookie.getName().equals("token")) {
               return cookie.getValue();
           }
       }

       return null;

   }
}
