package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repo.EmployeeRepo;
import com.example.employeemanagementsystem.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

  @Autowired private EmployeeRepo employeeRepo;

  @Autowired private ModelMapper modelMapper;

  public String saveEmployee(EmployeeDTO employeeDTO) {
    if (employeeRepo.existsById(employeeDTO.getId())) {
      return VarList.RSP_DUPLICATED;
    } else {
      employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
      return VarList.RSP_SUCCESS;
    }
  }

  public String updateEmployee(EmployeeDTO employeeDTO) {
    if (employeeRepo.existsById(employeeDTO.getId())) {
      employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
      return VarList.RSP_SUCCESS;
    } else {
      return VarList.RSP_NO_DATA_FOUND;
    }
  }
}
