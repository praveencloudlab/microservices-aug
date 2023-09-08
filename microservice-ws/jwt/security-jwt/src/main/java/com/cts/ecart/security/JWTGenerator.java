package com.cts.ecart.security;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.cts.ecart.entity.UserInfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTGenerator.class);
	@Value("${app.jwt.secret}")
	private String SECRET_KEY;
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour


	public String generateToken(Authentication authentication) {
        UserInfo user = (UserInfo) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject(String.format("%s,%s", user.getUserId(), user.getUserName()))
				.setIssuer("Praveen")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512,SECRET_KEY)
				.compact();
	}

	public String getUsernameFromJWT(String token) {
		
		Claims claims = Jwts.parser()
						.setSigningKey(SecurityConstants.JWT_SECRET)
						.parseClaimsJws(token)
						.getBody();
		
		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			
			return true;
		}catch (ExpiredJwtException ex) {
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
