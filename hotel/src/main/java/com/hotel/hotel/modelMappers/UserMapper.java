package com.hotel.hotel.modelMappers;


import org.springframework.stereotype.Component;

import com.hotel.hotel.entities.User;
import com.hotel.hotel.entitydto.UserDto;


@Component
public class UserMapper {

    public UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }


    public User convertToUser(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

}
