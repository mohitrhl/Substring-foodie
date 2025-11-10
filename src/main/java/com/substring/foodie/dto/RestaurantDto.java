package com.substring.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private String id;

    private String name;

    private String description;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Boolean open = true;
    private AddressDto address;
    private UserDto owner;

    private boolean isActive = true;
    private LocalDateTime createdDate;
    private List<FoodItemDto> foodItems = new ArrayList<>();

    private String bannerImageUrl;
}
