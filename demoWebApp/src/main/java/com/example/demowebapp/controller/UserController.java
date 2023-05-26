package com.example.demowebapp.controller;

import com.example.demowebapp.dto.UserDTO;
import com.example.demowebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // making this call a rest api controller
@RequestMapping(value = "api/v1/user") // mapping the req to the class
@CrossOrigin
public class UserController {

  @Autowired private UserService userService;

  @GetMapping("/getUsers") // making the get req
  public List<UserDTO> getUser() {

    return userService.gelAllUsers();
  }

  @PostMapping("/saveUser")
  public UserDTO saveUser(@RequestBody UserDTO userDTO) {

    return userService.saveUser(userDTO);
  }

  @PutMapping("/updateUser")
  public UserDTO updateUser(@RequestBody UserDTO userDTO) {

    return userService.updateUser(userDTO);
  }

  @DeleteMapping("/deleteUser")
  public boolean deleteUser(@RequestBody UserDTO userDTO) {

    return userService.deleteUser(userDTO);
  }
}
