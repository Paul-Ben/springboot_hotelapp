package com.hotel.hotel.services;

import java.util.List;

import com.hotel.hotel.entities.Room;
import com.hotel.hotel.exceptions.DuplicateRoomException;
import com.hotel.hotel.exceptions.RoomNotFoundException;

public interface RoomService {
    Room createRoom(Room room)throws DuplicateRoomException;
    Room getRoomById(Long id) throws RoomNotFoundException;
    List<Room> getAllRooms(Room room);
    Room updateRoom(Room room, Long id);
    void deleteRoomById(Room room, Long id);
}
