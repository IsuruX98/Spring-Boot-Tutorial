package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.dto.ResponceDTO;
import com.example.employeemanagementsystem.service.EmployeeService;
import com.example.employeemanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/employee")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @Autowired private ResponceDTO responceDTO;

  @PostMapping(value = "/saveEmployee")
  public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    try {
      String res = employeeService.saveEmployee(employeeDTO);

      if (res.equals("00")) {
        responceDTO.setCode(VarList.RSP_SUCCESS);
        responceDTO.setMessage("Success");
        responceDTO.setObject(employeeDTO);

        return new ResponseEntity(responceDTO, HttpStatus.ACCEPTED);
      } else if (res.equals("06")) {
        responceDTO.setCode(VarList.RSP_DUPLICATED);
        responceDTO.setMessage("employee registered");
        responceDTO.setObject(employeeDTO);

        return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
      } else {
        responceDTO.setCode(VarList.RSP_FAIL);
        responceDTO.setMessage("Error");
        responceDTO.setObject(null);

        return new ResponseEntity(responceDTO, HttpStatus.BAD_REQUEST);
      }

    } catch (Exception ex) {
      responceDTO.setCode(VarList.RSP_ERROR);
      responceDTO.setMessage(ex.getMessage());
      responceDTO.setObject(null);

      return new ResponseEntity(responceDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}