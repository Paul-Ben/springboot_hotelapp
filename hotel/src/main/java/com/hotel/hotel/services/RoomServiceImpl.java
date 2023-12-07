package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Room;
import com.hotel.hotel.exceptions.DuplicateRoomException;
import com.hotel.hotel.exceptions.RoomNotFoundException;
import com.hotel.hotel.repositories.RoomRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Override
    public Room createRoom(Room room) throws DuplicateRoomException {
        if (roomRepository.existsByRoomNumber(room.getRoomNumber()) && roomRepository.existsByHotelId(room.getHotelId())) {
            throw new DuplicateRoomException("This Room already exists");
        } else {
           return roomRepository.save(room); 
        }
        
    }

    @Override
    public Room getRoomById(Long id) throws RoomNotFoundException {
        if (roomRepository.existsById(id)) {
            return roomRepository.findById(id).get();            
        } else {
            throw new RoomNotFoundException("Room with this ID does not exist");
        }
    }

    @Override
    public List<Room> getAllRooms(Room room) {
        return roomRepository.findAll();
    }

    @Override
    public Room updateRoom(Room room, Long id) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(Room room, Long id) {
        roomRepository.deleteById(id);
    }

}
