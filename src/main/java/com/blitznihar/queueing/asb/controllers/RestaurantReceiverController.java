package com.blitznihar.queueing.asb.controllers;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.queueing.asb.constants.ControllerConstants;
import com.blitznihar.queueing.asb.entities.RestaurantModel;
import com.blitznihar.queueing.asb.services.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantReceiverController {



    @Autowired
    private RestaurantService restaurantService;

    @JmsListener(destination = ControllerConstants.DESTINATION_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(RestaurantModel restaurant) {
        List<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();
        restaurants.add(restaurant);
        restaurantService.saveRestaurantsAll(restaurants);
    }
}
