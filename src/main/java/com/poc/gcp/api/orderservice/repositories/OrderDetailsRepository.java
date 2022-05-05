package com.poc.gcp.api.orderservice.repositories;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

import com.poc.gcp.api.orderservice.entities.OrderDetails;

import reactor.core.publisher.Flux;


public interface OrderDetailsRepository extends FirestoreReactiveRepository<OrderDetails>{

	Flux<OrderDetails> findByOrderNo(Long orderNumber);

}