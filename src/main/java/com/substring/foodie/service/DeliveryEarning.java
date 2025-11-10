package com.substring.foodie.service;

import com.substring.foodie.dto.DeliveryEarningDto;

import java.util.List;

public interface DeliveryEarning {

    List<DeliveryEarningDto> getDeliveryEarningByDeliveryBoy(String deliveryBoyId);
}
