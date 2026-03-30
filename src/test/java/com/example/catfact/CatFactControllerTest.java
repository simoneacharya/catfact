package com.example.catfact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.catfact.Controller.CatFactController;
import com.example.catfact.Service.CatService;
import com.example.catfact.dto.CatFacts;
import com.example.catfact.dto.CatFactsForUsers;

@ExtendWith(MockitoExtension.class)
public class CatFactControllerTest {
	
	@Mock
	private CatService catService;
	
	@InjectMocks
	private CatFactController catFactController;
	
	@Test
	private void testGetCatFact() {
		
		//making a fake data -- arrange
		CatFacts fact = new CatFacts();
		fact.setFact("Cats sleep a lot");
		
		CatFacts response = new CatFacts();
		response.setFact("Cats sleep a lot");
		
		// instead of calling service, we set our fake data here
		when(catService.getCatFacts()).thenReturn(response);
		
		// action -- calling your method
		ResponseEntity<CatFactsForUsers> result = catFactController.getCatFact();
		
		//assert -- check
		assertEquals(200, result.getStatusCode().value());
		assertEquals("Cats sleep a lot", result.getBody().getFact());
		
		
	}
	
	

}
