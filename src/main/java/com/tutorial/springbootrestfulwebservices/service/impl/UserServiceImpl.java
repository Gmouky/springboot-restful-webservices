package com.tutorial.springbootrestfulwebservices.service.impl;

import com.tutorial.springbootrestfulwebservices.dto.UserDto;
import com.tutorial.springbootrestfulwebservices.entity.User;
import com.tutorial.springbootrestfulwebservices.exception.EmailAlreadyExistException;
import com.tutorial.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.tutorial.springbootrestfulwebservices.mapper.UserMapper;
import com.tutorial.springbootrestfulwebservices.repository.UserRepository;
import com.tutorial.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if(optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email Already exist for the user");
        }

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = findUserById(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        User existingUser = findUserById(id);
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    private User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id));
    }
}
