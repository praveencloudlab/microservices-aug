package com.cts.ecart.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.cts.ecart.entity.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint, AuthenticationProvider {
	
	@Autowired
	private MyUserDetails myUserDetails;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}

    @SuppressWarnings("serial" )
    private static List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>(1) {{
       // add(new GrantedAuthorityImpl("ROLE_USER"));
    }};
	 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// All your user authentication needs
		System.out.println("==Authenticate Me==");
		
		 UserDetails userDetails = myUserDetails.loadUserByUsername(authentication.getPrincipal().toString());
         UserInfo user = (UserInfo) userDetails;
		 
         if ((user.getUserName().equals(authentication.getPrincipal())) && BCrypt.checkpw(authentication.getCredentials().toString(),user.getPassword())){
			System.out.println(">>>>>>> !!!! <<<<<< "+authentication.getName()+" >>> "+authentication.getCredentials()+" >>>> "+authentication.getPrincipal());
			return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
		}
		
		throw new BadCredentialsException("Username/Password does not match for " + authentication.getPrincipal());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

	}
}