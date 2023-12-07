package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByHotelEmail(String hotelEmail);
}
