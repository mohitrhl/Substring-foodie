package com.substring.foodie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String name;

    private String description;

    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss a")
    private LocalTime openTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss a")
    private LocalTime closeTime;
    private boolean open = true;


    private String banner;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime createdDate;

    @JsonProperty
    public String imageUrl() {
        return "http://localhost:8080/images/" + banner;
    }



}
