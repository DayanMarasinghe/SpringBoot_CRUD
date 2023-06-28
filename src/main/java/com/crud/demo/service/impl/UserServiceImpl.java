package com.crud.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crud.demo.dto.UserDTO;
import com.crud.demo.entity.User;
import com.crud.demo.repository.UserRepository;
import com.crud.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository
            .findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id" +id));

        return user;
    }

    @Override
    public User updateUser(Integer id, User user) {
        userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user"));

        user.setId(id);

        userRepository.save(user);

        return user;
                    
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user"));

        userRepository.delete(user);
    }

    @Override
    public User updateName(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user"));

        user.setName(userDTO.getName());

        userRepository.save(user);

        return user;
    }
    
}
