package com.example.catfact.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.catfact.dto.CatFacts;

@Service
public class CatService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(CatService.class);
	
	public CatFacts getCatFacts() {
		
		logger.info("Calling url for catfacts");
		
		String url = "https://catfact.ninja/fact";
		
		try {
		return restTemplate.getForObject(url, CatFacts.class);
		}
		catch(Exception ex) {
			logger.error("failed to grab any catfact");
			throw ex;
		}
	}

}
