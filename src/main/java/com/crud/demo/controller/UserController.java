package com.crud.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.dto.UserDTO;
import com.crud.demo.entity.User;
import com.crud.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.addUser(user);

        return "User added successfully";
    }

    @GetMapping()
    public List<User> getUsers(){

        return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){

        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user){

       return userService.updateUser(id, user);

        //return ResponseEntity.noContent().build();
    } 

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

        return "User deleted successfully";
    }

    @PatchMapping("/updatename/{id}")
    public User updateName(@PathVariable Integer id, @RequestBody UserDTO userDTO){

        return userService.updateName(id, userDTO);
    }
}
