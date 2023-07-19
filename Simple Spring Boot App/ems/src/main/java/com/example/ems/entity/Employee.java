package com.example.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empID;
  private String empName;
  private String empAddress;
  private String empMobile;

}
