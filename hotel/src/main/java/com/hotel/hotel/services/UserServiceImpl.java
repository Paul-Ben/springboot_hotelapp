package com.hotel.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.User;
import com.hotel.hotel.entitydto.UserDto;
import com.hotel.hotel.modelMappers.UserMapper;
import com.hotel.hotel.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public User createUser(UserDto userDto) {
        return userRepository.save(userMapper.convertToUser(userDto));
    }

  

}
