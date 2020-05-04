package com.coder.DescussionBoard.JWTsecurity.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.coder.DescussionBoard.JWTsecurity.services.UserPrinciple;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtProvider {

	 private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	    @Value("${grokonez.app.jwtSecret}")
	    private static String jwtSecret = "jwtGrokonezSecretKey";

	    @Value("${grokonez.app.jwtExpiration}")
	   // private static int jwtExpiration= 10;
	    private static int jwtExpiration= 86400;

	    public static String generateJwtToken(Authentication authentication) {

	    	  UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
	          
	          return Jwts.builder() 
	    		            .setSubject((userPrincipal.getUsername()))
	    		            .setIssuedAt(new Date(System.currentTimeMillis()))
	    		            .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration * 10))
	    		          //  .setIssuedAt(new Date()).setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
	  		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
	  		                .compact();
	      }
	      
	    public boolean  checkcredential(String authToken){
      	  Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        return true;
        }
	    
	      public boolean validateJwtToken(String authToken) {
	    	  try {
	    		  if(checkcredential(authToken) && !isTokenExpired(authToken)) {
	             // Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	              return true;
	              }
	          } catch (SignatureException e) {
	              logger.error("Invalid JWT signature -> Message: {} ", e);
	          } catch (MalformedJwtException e) {
	              logger.error("Invalid JWT token -> Message: {}", e);
	          } catch (ExpiredJwtException e) {
	              logger.error("Expired JWT token -> Message: {}", e);
	          } catch (UnsupportedJwtException e) {
	              logger.error("Unsupported JWT token -> Message: {}", e);
	          } catch (IllegalArgumentException e) {
	              logger.error("JWT claims string is empty -> Message: {}", e);
	          }
	          
	          return false;
	      }
	      
	      public String getUserNameFromJwtToken(String token) {
	          return Jwts.parser()
	  			                .setSigningKey(jwtSecret)
	  			                .parseClaimsJws(token)
	  			                .getBody().getSubject();
	      }
	      
	    //for retrieveing any information from token we will need the secret key
	      private Claims getAllClaimsFromToken(String token) {
	      return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	      }
	      
	    //retrieve expiration date from jwt token
	      public Date getExpirationDateFromToken(String token) {
	      return getClaimFromToken(token, Claims::getExpiration);
	      }

	      public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	    	  final Claims claims = getAllClaimsFromToken(token);
	    	  return claimsResolver.apply(claims);
	    	  }
	      
	    //check if the token has expired
	      private Boolean isTokenExpired(String token) {
	      final Date expiration = getExpirationDateFromToken(token);
	      System.out.println("Target expiry time =====>" + 
	      new Date(System.currentTimeMillis() + jwtExpiration * 1000));
	      System.out.println("Current expiry time ----->" + expiration);
	      System.out.println("Current time ----->" + new Date());
	      System.out.println("----->" + expiration.before(new Date()));
	      return expiration.before(new Date());
	      }


    }