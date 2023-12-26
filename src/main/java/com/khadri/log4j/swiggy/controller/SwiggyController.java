package com.khadri.log4j.swiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khadri.log4j.swiggy.model.PlaceOrderRequest;
import com.khadri.log4j.swiggy.model.PlaceOrderResponse;
import com.khadri.log4j.swiggy.service.SwiggyService;

@RestController
@RequestMapping("/swiggy/v1")
public class SwiggyController {

	@Autowired
	private SwiggyService swiggyService;

	@PostMapping("/order/place")
	public ResponseEntity<PlaceOrderResponse> userRequest(@RequestBody PlaceOrderRequest placeOrderRequest) {

		PlaceOrderResponse orderSuccess = swiggyService.orderSuccess(placeOrderRequest);

		return new ResponseEntity<PlaceOrderResponse>(orderSuccess, HttpStatus.CREATED);
	}

}
