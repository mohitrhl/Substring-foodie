package com.substring.foodie.payload;

import com.substring.foodie.dto.UserDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private  String accessToken;
    private  String refreshToken;
    private UserDto user;
}
