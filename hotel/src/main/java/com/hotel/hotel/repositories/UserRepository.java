package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
