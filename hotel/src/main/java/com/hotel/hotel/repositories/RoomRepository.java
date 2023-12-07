package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByHotelId(String hotelId);
    boolean existsByRoomNumber(String roomNumber);
}
