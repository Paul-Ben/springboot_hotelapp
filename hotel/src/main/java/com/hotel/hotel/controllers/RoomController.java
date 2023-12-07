package com.hotel.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.entities.Room;
import com.hotel.hotel.services.RoomService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/rooms")
@NoArgsConstructor
@AllArgsConstructor
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        
        Room createdRoom = roomService.createRoom(room);
        return ResponseEntity.ok(createdRoom);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id){
        Room roomById = roomService.getRoomById(id);

        return ResponseEntity.ok(roomById);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(@RequestBody Room room){
        List<Room> allRooms = roomService.getAllRooms(room);
        return ResponseEntity.ok(allRooms);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room, @PathVariable Long id){
        Room room_to_edit = roomService.getRoomById(id);

        room_to_edit.setHotelId(room.getHotelId());
        room_to_edit.setBedType(room.getBedType());
        room_to_edit.setRoomAmenities(room.getRoomAmenities());
        room_to_edit.setRoomAvailability(room.getRoomAvailability());
        room_to_edit.setRoomNumber(room.getRoomNumber());
        room_to_edit.setRoomPrice(room.getRoomPrice());
        room_to_edit.setRoomType(room.getRoomType());

        Room updatedRoom = roomService.updateRoom(room_to_edit, id);

        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long id, @RequestBody Room room){

        Room room_to_delete = roomService.getRoomById(id);
        roomService.deleteRoomById(room, id);
        return "room "+room_to_delete.getRoomNumber()  +" deleted";
    }


}
