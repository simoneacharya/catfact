package com.example.catfact.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.catfact.Service.CatService;
import com.example.catfact.dto.CatFactsForUsers;


@RestController
public class CatFactController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CatService catService;
	
	private static final Logger logger = LoggerFactory.getLogger(CatFactController.class);
	
	@GetMapping("/catfacts")
	public ResponseEntity<CatFactsForUsers> getCatFact() {
		
		logger.info("Cat fact retrieved");
		
		var response = catService.getCatFacts();
		
	     CatFactsForUsers body = new CatFactsForUsers(response.getFact());
	     
	     return ResponseEntity.ok(body);
	
	}
	

}
