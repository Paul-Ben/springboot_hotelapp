package com.hotel.hotel.entitydto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDto {
    private Long id;
    private String hotelName;
    private String hotelId;
    private String hotelAddress;
    private String hotelStarRating;
    private String hotelPhone;
    private String hotelEmail;
    private Integer number_of_rooms;
}
