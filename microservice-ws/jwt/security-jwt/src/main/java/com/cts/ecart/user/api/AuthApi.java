package com.cts.ecart.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.UserInfo;
import com.cts.ecart.security.JWTGenerator;

import jakarta.validation.Valid;

@RestController
public class AuthApi {
	
	@Autowired 
	AuthenticationManager authManager;
	@Autowired 
	JWTGenerator jwtGenerator;
	
	 @PostMapping("/auth/login")
	    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		 System.out.println(">>>>>>>>>>>>> request :: "+request);
	        try {
	        	
	            Authentication authentication = authManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            request.getUserName(), request.getPassword())
	            );
	             
	           UserInfo user = (UserInfo) authentication.getPrincipal();
	           System.out.println(">>>>>> user Info: "+user);
	            String accessToken = jwtGenerator.generateToken(authentication);
	            AuthResponse response = new AuthResponse(user.getUserName(), accessToken);
	            
	            return ResponseEntity.ok().body(response);
	             
	        } catch (BadCredentialsException ex) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    }
	
}
