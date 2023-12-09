package com.hotel.hotel.services;

import com.hotel.hotel.entities.User;
import com.hotel.hotel.entitydto.UserDto;


public interface UserService {
    User createUser(UserDto userdDto);
}
