package com.tutorial.springbootrestfulwebservices.service;

import com.tutorial.springbootrestfulwebservices.dto.UserDto;
import com.tutorial.springbootrestfulwebservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userdto);

    UserDto getUserById(long id);

    List<UserDto> getAllUser();
    UserDto updateUser(long id, UserDto userDto);

    void deleteUser(long id);
}
