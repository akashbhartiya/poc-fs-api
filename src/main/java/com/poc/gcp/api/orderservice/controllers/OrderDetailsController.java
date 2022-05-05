package com.poc.gcp.api.orderservice.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.cloud.gcp.data.firestore.FirestoreTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.poc.gcp.api.orderservice.entities.ADDRESS;
import com.poc.gcp.api.orderservice.entities.OrderDetails;
import com.poc.gcp.api.orderservice.entities.UserInformation;
import com.poc.gcp.api.orderservice.repositories.OrderDetailsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderDetailsController {

	private final OrderDetailsRepository orderDetailsRepository;

	private final FirestoreTemplate firestoreTemplate;

	public OrderDetailsController(OrderDetailsRepository orderDetailsRepository, FirestoreTemplate firestoreTemplate) {
		this.orderDetailsRepository = orderDetailsRepository;
		this.firestoreTemplate = firestoreTemplate;
	}

	@GetMapping
	private Flux<OrderDetails> getAllOrders() {
		return orderDetailsRepository.findAll();
	}

	@GetMapping("/{orderno}")
	private Flux<OrderDetails> getOrdersByOrderNumber(@PathVariable Long orderno) {
		return orderDetailsRepository.findByOrderNo(orderno);
	}

	
	  @GetMapping("/{orderno}/address")
	  private Mono<Map<ADDRESS, OrderDetails>> getUsersByAge(@PathVariable Long orderno) { 
	  Mono<Map<ADDRESS, OrderDetails>> collectMap = this.orderDetailsRepository.findByOrderNo(orderno).collectMap(x->x.getUserInformation().getADDRESS());
	  return collectMap;
	  }
	 

	@GetMapping("/loadtestdata")
	public Mono<OrderDetails> loadTestData() throws JsonMappingException, JsonProcessingException {

		UserInformation user = new UserInformation();
		user.setFirstname("Akash");
		user.setLastname("Bhartiya");
		user.setMobilenumber("85520111111");
		user.setPincode(302017);

		ADDRESS address = new ADDRESS();
		address.setDist("Jaipur");
		address.setPincode(302017);
		address.setState("Rajasthan");
		address.setLandmark("Daaru ki Dukan ke Piche aa k call kr");

		user.setADDRESS(address);
		List<String> items = Arrays.asList("Iphone 13", "Iphone 13 case Spigen", "Apple Airpods");

		UUID uuid=UUID.randomUUID();   
		OrderDetails od = new OrderDetails();
		od.setDocumentId(uuid.toString());
		od.setOrderComplete("Y");
		od.setOrderNo(1039032L);
		od.setOrderId(1039032L);
		od.setOrderNotes("Do Gift Wrapping");
		od.setTentativeDeliveryDate("02-06-2022");
		od.setUserInformation(user);
		od.setItems(items);

//		return orderDetailsRepository.save(od);
		return this.firestoreTemplate.save(od);
	}
}
