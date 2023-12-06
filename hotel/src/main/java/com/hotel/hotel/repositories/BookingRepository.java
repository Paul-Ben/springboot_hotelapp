package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
