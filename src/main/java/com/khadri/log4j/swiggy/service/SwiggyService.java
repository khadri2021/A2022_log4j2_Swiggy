package com.khadri.log4j.swiggy.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.khadri.log4j.swiggy.model.PlaceOrderRequest;
import com.khadri.log4j.swiggy.model.PlaceOrderResponse;

@Service
public class SwiggyService {

	public PlaceOrderResponse orderSuccess(PlaceOrderRequest placeOrderRequest) {

		PlaceOrderResponse orderResponse = new PlaceOrderResponse();
		orderResponse.setItemName(placeOrderRequest.getItemName());
		orderResponse.setItemQty(placeOrderRequest.getItemQty());
		orderResponse.setUser(placeOrderRequest.getUser());
		orderResponse.setTotalCost(100.00 * placeOrderRequest.getItemQty());
		orderResponse.setOrderId(UUID.randomUUID());

		return orderResponse;
	}

}
