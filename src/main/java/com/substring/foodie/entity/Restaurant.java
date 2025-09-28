package com.substring.foodie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalTime;

@Entity
@Table(name = "foodie_restaurant")
@Getter
@Setter
public class Restaurant {

    @Id
    private String id;

    private String name;

    @Lob
    private String description;

    private String address;

    private LocalTime openTime;

    private LocalTime closeTime;

    private boolean open = true;

    private String banner;

    @ManyToOne
    private  User user;

}
