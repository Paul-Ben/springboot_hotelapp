package com.hotel.hotel.services;

import java.util.List;

import com.hotel.hotel.entities.Hotel;

public interface HotelService {
    Hotel createHotel(Hotel hotel)throws DulicateHotelException ;
    Hotel getHotelById(Long id);
    List<Hotel> getAllHotels(Hotel hotel);
    Hotel updateHotel(Hotel hotel, Long id);
    void deleteHotel(Hotel hotel);

}
