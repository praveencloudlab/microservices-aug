package com.cts.ecart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.UserDao;
import com.cts.ecart.entity.UserInfo;
import com.cts.ecart.exception.UsernameNotFoundException;

@Service
public class MyUserDetails implements UserDetailsService{
	
	
	 @Autowired
	 private  UserDao userRepository;

	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    final UserInfo appUser = userRepository.findByUserName(username).orElse(null);

	    if (appUser == null) {
	      throw new UsernameNotFoundException("User '" + username + "' not found");
	    }
	    

	    return appUser;
	  }
	

}
