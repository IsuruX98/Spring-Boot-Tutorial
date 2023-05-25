package com.example.demowebapp.controller;

import com.example.demowebapp.dto.UserDTO;
import com.example.demowebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // making this call a rest api controller
@RequestMapping(value = "api/v1/user") // mapping the req to the class
@CrossOrigin
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/getUser") // making the get req
  public String getUser() {

    return "Get user";
  }

  @PostMapping("/saveUser")
  public UserDTO saveUser(@RequestBody UserDTO userDTO) {

   return userService.saveUser(userDTO);
  }

  @PutMapping("/updateUser")
  public String updateUser() {

    return "Update user";
  }

  @DeleteMapping("/deleteUser")
  public String deleteUser() {

    return "Delete user";
  }
}
