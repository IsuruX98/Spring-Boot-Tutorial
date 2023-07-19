package com.example.ems.service;

import com.example.ems.dto.EmployeeDTO;
import com.example.ems.entity.Employee;
import com.example.ems.repo.EmployeeRepo;
import com.example.ems.util.VarList;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

  //to use jpa methods we have to inject the dto to this class
  @Autowired
  private EmployeeRepo employeeRepo;

  //to map the classes
  @Autowired
  private ModelMapper modelMapper;

  public String saveEmployee(EmployeeDTO employeeDTO) {
    //to check data already exists
    if (employeeRepo.existsById(employeeDTO.getEmpID())) {
      return VarList.RSP_DUPLICATED;
    } else {
      employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
      return VarList.RSP_SUCCESS;
    }
  }

  public String updateEmployee(EmployeeDTO employeeDTO) {
    //to check data already exists
    if (employeeRepo.existsById(employeeDTO.getEmpID())) {
      employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
      return VarList.RSP_SUCCESS;
    } else {
      return VarList.RSP_NO_DATA_FOUND;
    }
  }

  public List<EmployeeDTO> getAllEmployee() {
    List<Employee> employeeList = employeeRepo.findAll();
    return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>() {
    }.getType());
  }

  public EmployeeDTO searchEmployee(int empID) {
    if (employeeRepo.existsById(empID)) {
      Employee employee = employeeRepo.findById(empID).orElse(null);
      return modelMapper.map(employee, EmployeeDTO.class);
    } else {
      return null;
    }
  }

  public String deleteEmployee(int empID) {
    if (employeeRepo.existsById(empID)) {
      employeeRepo.deleteById(empID);
      return VarList.RSP_SUCCESS;
    } else {
      return VarList.RSP_NO_DATA_FOUND;
    }
  }

  public EmployeeDTO getEmp(int empID){
    Employee employee = employeeRepo.getEmployeeById(empID);
    return modelMapper.map(employee,EmployeeDTO.class);
  }

}
