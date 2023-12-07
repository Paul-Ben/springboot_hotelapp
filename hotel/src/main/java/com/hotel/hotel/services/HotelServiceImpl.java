package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Hotel;
import com.hotel.hotel.repositories.HotelRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        if (hotelRepository.existsByHotelEmail(hotel.getHotelEmail())) {
            throw new DulicateHotelException("Hotel with this email already exists");
        } else {
            return hotelRepository.save(hotel);
        }

    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public List<Hotel> getAllHotels(Hotel hotel) {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(Hotel hotel, Long id) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

}
