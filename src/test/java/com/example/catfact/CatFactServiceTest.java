package com.example.catfact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.example.catfact.Service.CatService;
import com.example.catfact.dto.CatFacts;

@ExtendWith(MockitoExtension.class)
public class CatFactServiceTest {
	
	@InjectMocks
	private CatService catService;
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@Test
	private void getCatFactsTest(){
		
		//making a fake data -- arrange
				
				CatFacts mockresponse = new CatFacts();
				mockresponse.setFact("Cats sleep a lot");
				
				// instead of calling service, we set our fake data here
				when(restTemplate.getForObject("https://catfact.ninja/fact", CatFacts.class)).thenReturn(mockresponse);
				
				// action
				CatFacts result = catService.getCatFacts();
				
				//assert
				assertEquals("Cats sleep a lot", result.getFact());
				
	}

}
