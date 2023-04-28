package io.github.AugustoMello09.strproducer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.AugustoMello09.strproducer.services.StringProducerService;

@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {
	
	@Autowired
	private StringProducerService service;
	
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message){
		service.sendMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
