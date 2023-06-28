package com.crud.demo.service;

import java.util.List;

import com.crud.demo.dto.UserDTO;
import com.crud.demo.entity.User;

public interface UserService {

    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);

    User updateName(Integer id, UserDTO userDTO);
    
}
