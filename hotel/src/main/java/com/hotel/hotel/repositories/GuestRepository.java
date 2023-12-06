package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
