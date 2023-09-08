package com.cts.ecart;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.cts.ecart.dao.UserDao;



@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Component
public class ApplicationSecurity{

	@Autowired private UserDao userRepo;
	
	@Autowired private com.cts.ecart.jwt.JwtTokenFilter jwtTokenFilter;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    //@Autowired
   // private UserDetailsService userDetailsService;
   
	
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

		http.authorizeRequests()
				.antMatchers("/auth/login").permitAll() //<- allow requests to this auth/login end
				.anyRequest().authenticated(); // <- all other requests needs full authentication;
		
		
		
		
        http.exceptionHandling()
                .authenticationEntryPoint(
                    (request, response, ex) -> {
                    	System.out.println(">>>>>>>>>>>> "+response.getWriter()+"<<<<< "+ex.getMessage());
                        response.sendError(
                            HttpServletResponse.SC_UNAUTHORIZED,
                            ex.getMessage()
                            //System.out.println(ex.getMessage());
                        );
                    }
                );
        
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		http.addFilterAfter(jwtTokenFilter, BasicAuthenticationFilter.class); // <- add your JWT authentication filter into the chain
	    return http.build();
	}


 
	
    /*
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) 
	  throws Exception {
		
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(username -> userRepo.findByEmail(username).orElse(null))
	      .passwordEncoder(bCryptPasswordEncoder)
	      .and()
	      .build();
	    
	    
	}
	*/
	 @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration authenticationConfiguration) throws Exception {
		 
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	
	
	

	
	
	
	
	
	
	
}
