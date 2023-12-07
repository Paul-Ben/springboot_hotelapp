package com.hotel.hotel.services;

import java.util.List;

import com.hotel.hotel.entities.Hotel;
import com.hotel.hotel.exceptions.HotelNotFoundException;

public interface HotelService {
    Hotel createHotel(Hotel hotel)throws DulicateHotelException ;
    Hotel getHotelById(Long id) throws HotelNotFoundException;
    List<Hotel> getAllHotels(Hotel hotel);
    Hotel updateHotel(Hotel hotel, Long id);
    void deleteHotel(Hotel hotel);

}
