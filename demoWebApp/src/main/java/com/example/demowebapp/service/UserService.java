package com.example.demowebapp.service;

import com.example.demowebapp.dto.UserDTO;
import com.example.demowebapp.entity.User;
import com.example.demowebapp.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

  @Autowired private UserRepo userRepo;

  @Autowired private ModelMapper modelMapper;

  public UserDTO saveUser(UserDTO userDTO) {
    userRepo.save(modelMapper.map(userDTO, User.class));
    return userDTO;
  }

  public List<UserDTO> gelAllUsers() {
    List<User> userList = userRepo.findAll();
    return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
  }

  public UserDTO updateUser(UserDTO userDTO) {
    userRepo.save(modelMapper.map(userDTO, User.class));
    return userDTO;
  }
}
