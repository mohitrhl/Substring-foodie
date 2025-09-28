package com.substring.foodie.service;

import com.substring.foodie.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {

    // add logic
    RestaurantDto add(RestaurantDto restaurantDto);
    RestaurantDto update(RestaurantDto restaurantDto , String id);
    void delete(String delete);

    //single get
    RestaurantDto get(String id);


    // get all
    Page<RestaurantDto>getAll(Pageable pagable);

    List<RestaurantDto> searchByName(String keyword);

    //----if extra service need
    Page<RestaurantDto>getOpenRestaurants(Pageable pagable);

    // get single

//    update

//    delete
}
