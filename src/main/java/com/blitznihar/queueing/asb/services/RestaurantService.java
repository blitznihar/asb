package com.blitznihar.queueing.asb.services;

import java.util.List;

import com.blitznihar.queueing.asb.constants.ControllerConstants;
import com.blitznihar.queueing.asb.entities.RestaurantModel;
import com.blitznihar.queueing.asb.repositories.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    public RestaurantRepository restaurantRepository;

    public List<RestaurantModel> getRestaurantsAll()
    {
        return restaurantRepository.findAll();
        
    }

    public int saveRestaurantsAll(List<RestaurantModel> restaurants)
    {
        return restaurantRepository.saveAll(restaurants).size();
    }



    public int saveRestaurantqueue(RestaurantModel restaurant) {
        jmsTemplate.convertAndSend(ControllerConstants.DESTINATION_NAME, restaurant);
        return 1;
    }

    public int saveRestaurantsAllqueue(List<RestaurantModel> restaurants) {
        
        for (RestaurantModel restaurant : restaurants) {
            jmsTemplate.convertAndSend(ControllerConstants.DESTINATION_NAME, restaurant);
        }
        
        return restaurants.size();
    }
}
