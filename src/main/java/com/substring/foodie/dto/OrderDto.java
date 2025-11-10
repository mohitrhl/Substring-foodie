package com.substring.foodie.dto;

import com.substring.foodie.enums.OrderStatus;
import com.substring.foodie.enums.PaymentMode;
import com.substring.foodie.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;
    private UserDto user;
    private RestaurantDto restaurant;
    private AddressDto address;
    private int totalAmount;
    private OrderStatus status = OrderStatus.PLACED;
    private LocalDateTime orderedAt;
    private LocalDateTime deliveryTime;
    private UserDto deliveryBoy;
    private List<OrderItemDto> orderItems = new ArrayList<>();
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private String paymentId;
}
