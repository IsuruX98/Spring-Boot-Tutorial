package com.example.demowebapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController // making this call a rest api controller
@RequestMapping(value = "api/v1/user") // mapping the req to the class
@CrossOrigin
public class UserController {

  @GetMapping("/getUser") // making the get req
  public String getUser() {

    return "Get user";
  }

  @PostMapping("/saveUser")
  public String saveUser() {

    return "Save user";
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
