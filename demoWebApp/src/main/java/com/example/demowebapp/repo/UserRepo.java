package com.example.demowebapp.repo;

import com.example.demowebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {}
