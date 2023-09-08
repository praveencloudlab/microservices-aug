package com.cts.configclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl {
	
	@Autowired
	private ColorService cs;
	
	public String getColorName() {
		return cs.getColorName();
	}
	
	
	
	
	
	

}
