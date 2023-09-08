package com.cts.ecart.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cts.ecart.entity.UserInfo;
import com.cts.ecart.security.MyUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@SuppressWarnings("deprecation")
@Component
public class JwtTokenUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
	
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
	
	@Value("${app.jwt.secret}")
	private String SECRET_KEY;
	
	@Autowired
	private MyUserDetails myUserDetails;
	
	public String generateAccessToken(UserInfo user) {
	    //SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		return Jwts.builder()
				.setSubject(String.format("%s,%s", user.getUserId(), user.getEmail()))
				.setIssuer("CodeJava")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512,SECRET_KEY)
				.compact();
	}
	
	 public Authentication getAuthentication(String token) {
		    System.out.println(">>>>> YYYYAAAAAHHHHHH "+token);
		    UserDetails userDetails = myUserDetails.loadUserByUsername(getSubject(token));
		    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
		  }
	
	public boolean validateAccessToken(String token) {
	   // UserDetails userDetails = myUserDetails.loadUserByUsername(getSubject(token));
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			//Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);

			return true;
		} catch (ExpiredJwtException ex) {
			LOGGER.error("JWT expired", ex.getMessage());
		} catch (IllegalArgumentException ex) {
			LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
		} catch (MalformedJwtException ex) {
			LOGGER.error("JWT is invalid", ex);
		} catch (UnsupportedJwtException ex) {
			LOGGER.error("JWT is not supported", ex);
		} catch (SignatureException ex) {
			LOGGER.error("Signature validation failed");
		}
		
		return false;
	}
	
	
	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}
	
	private Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}
}
