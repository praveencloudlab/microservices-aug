package com.cts.ecart.user.api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.UserInfo;
import com.cts.ecart.jwt.JwtTokenUtil;

@RestController
public class AuthApi {
	
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	
	 @PostMapping("/auth/login")
	    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
	        try {
	            Authentication authentication = authManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            request.getEmail(), request.getPassword())
	            );
	            
	            System.out.println(">>>>>> "+authentication.getPrincipal());
	             
	            UserInfo user = (UserInfo) authentication.getPrincipal();
	            String accessToken = jwtUtil.generateAccessToken(user);
	            System.out.println(">>> Token:: "+accessToken);
	            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
	            return ResponseEntity.ok().body(response);
	             
	        } catch (BadCredentialsException ex) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    }
	
	
	@GetMapping("/user")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess()
    {
        System.out.println("---------------- test User ");
        return "User Content.";
    }
	
}
