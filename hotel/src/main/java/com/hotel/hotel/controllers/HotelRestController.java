package com.hotel.hotel.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.entities.Hotel;

import com.hotel.hotel.services.HotelService;
import com.hotel.hotel.services.RandomIdGen;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/hotels")
@NoArgsConstructor
@AllArgsConstructor
public class HotelRestController {

    @Autowired
    HotelService hotelService;

    @Autowired
    RandomIdGen randomIdGen;

    // Create model entity
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody @Valid Hotel hotel) {

        
        String appId = randomIdGen.genrateRandomId();
        hotel.setHotelId(appId);
        Hotel newHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);

    }

    // Read all created entities
    @GetMapping
    public ResponseEntity<List<Hotel>> getMethodName(@RequestBody Hotel hotel) {
        List<Hotel> allHotels = hotelService.getAllHotels(hotel);
        return ResponseEntity.status(HttpStatus.OK).body(allHotels);
    }

    // Read a single entity by its id
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@RequestBody Hotel hotel, @PathVariable Long id) {
        Hotel hotelbyId = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotelbyId);
    }

    // Update an entity by its id
    @PutMapping("edit/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Hotel hotel_to_edit = hotelService.getHotelById(id);
        hotel_to_edit.setHotelName(hotel.getHotelName());
        hotel_to_edit.setHotelAddress(hotel.getHotelAddress());
        hotel_to_edit.setHotelStarRating(hotel.getHotelStarRating());
        hotel_to_edit.setHotelPhone(hotel.getHotelPhone());
        hotel_to_edit.setHotelEmail(hotel.getHotelEmail());
        hotel_to_edit.setNumber_of_rooms(hotel.getNumber_of_rooms());

        Hotel updatedHotel = hotelService.updateHotel(hotel_to_edit, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedHotel);
    }

    // Delete a entity
    @DeleteMapping("/{id}")
    public String deleteHotel(@RequestBody Hotel hotel, @PathVariable Long id) {
        Hotel hotel_to_delete = hotelService.getHotelById(id);
        hotelService.deleteHotel(hotel_to_delete);
        return "Hotel with name " + hotel_to_delete.getHotelName() + " deleted.";
    }

}
