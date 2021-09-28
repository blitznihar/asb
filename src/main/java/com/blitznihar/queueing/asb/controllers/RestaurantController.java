package com.blitznihar.queueing.asb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.blitznihar.queueing.asb.constants.ControllerConstants;
import com.blitznihar.queueing.asb.entities.RestaurantModel;
import com.blitznihar.queueing.asb.services.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(ControllerConstants.RESTAURANT)
public class RestaurantController {
    
    @Autowired
    public RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantModel> getRestaurantAll() {
        return restaurantService.getRestaurantsAll();
    }

   @PostMapping
   public int insertRestaurantAll(@RequestBody List<RestaurantModel> restaurantModel) {
       restaurantService.saveRestaurantsAll(restaurantModel);
       return restaurantModel.size();
   }

   @PostMapping("/queue")
   public int insertRestaurantAllQueue(@RequestBody List<RestaurantModel> restaurantModel) {
       restaurantService.saveRestaurantsAllqueue(restaurantModel);
       return restaurantModel.size();
   }

}
