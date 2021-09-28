package com.blitznihar.queueing.asb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blitznihar.queueing.asb.entities.RestaurantModel;
@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantModel, String> {
    
}
