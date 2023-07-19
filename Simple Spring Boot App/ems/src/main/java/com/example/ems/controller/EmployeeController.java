package com.example.ems.controller;

import com.example.ems.dto.EmployeeDTO;
import com.example.ems.dto.ResponseDTO;
import com.example.ems.service.EmployeeService;
import com.example.ems.util.VarList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

  //to use the service functions
  @Autowired
  private EmployeeService employeeService;

  //to use the response Dto
  @Autowired
  private ResponseDTO responseDTO;

  //create
  @PostMapping(value = "/saveEmployee")
  public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    try {
      String res = employeeService.saveEmployee(employeeDTO);

      if (res.equals("00")) {
        responseDTO.setCode(VarList.RSP_SUCCESS);
        responseDTO.setMessage("Success");
        responseDTO.setContent(employeeDTO);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
      } else if (res.equals("06")) {
        responseDTO.setCode(VarList.RSP_DUPLICATED);
        responseDTO.setMessage("Employee registered");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      } else {
        responseDTO.setCode(VarList.RSP_FAIL);
        responseDTO.setMessage("Error");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      }

    } catch (Exception ex) {
      responseDTO.setCode(VarList.RSP_ERROR);
      responseDTO.setMessage(ex.getMessage());
      responseDTO.setContent(null);
      return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //update
  @PutMapping(value = "/updateEmployee")
  public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
    try {
      String res = employeeService.updateEmployee(employeeDTO);

      if (res.equals("00")) {
        responseDTO.setCode(VarList.RSP_SUCCESS);
        responseDTO.setMessage("Success");
        responseDTO.setContent(employeeDTO);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
      } else if (res.equals("01")) {
        responseDTO.setCode(VarList.RSP_FAIL);
        responseDTO.setMessage("Not a registered employee");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      } else {
        responseDTO.setCode(VarList.RSP_FAIL);
        responseDTO.setMessage("Error");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      }

    } catch (Exception ex) {
      responseDTO.setCode(VarList.RSP_ERROR);
      responseDTO.setMessage(ex.getMessage());
      responseDTO.setContent(null);
      return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //retrieve
  @GetMapping("/getAllEmployees")
  public ResponseEntity getAllEmployees() {
    try {
      List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployee();

      responseDTO.setCode(VarList.RSP_SUCCESS);
      responseDTO.setMessage("Success");
      responseDTO.setContent(employeeDTOList);
      return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

    } catch (Exception ex) {
      responseDTO.setCode(VarList.RSP_ERROR);
      responseDTO.setMessage(ex.getMessage());
      responseDTO.setContent(null);
      return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/searchEmpolyee/{empID}")
  public ResponseEntity searchEmpolyee(@PathVariable int empID) {
    try{

      EmployeeDTO employeeDTO = employeeService.searchEmployee(empID);

      if(employeeDTO != null){
        responseDTO.setCode(VarList.RSP_SUCCESS);
        responseDTO.setMessage("Success");
        responseDTO.setContent(employeeDTO);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
      }else {
        responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
        responseDTO.setMessage("no employee available for this empID");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      }

    }catch (Exception ex){
      responseDTO.setCode(VarList.RSP_ERROR);
      responseDTO.setMessage(ex.getMessage());
      responseDTO.setContent(null);
      return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //native
  @GetMapping("/getEmp/{empID}")
  public ResponseEntity getEmp(@PathVariable int empID){
    try{

      EmployeeDTO employeeDTO = employeeService.getEmp(empID);

      if(employeeDTO != null){
        responseDTO.setCode(VarList.RSP_SUCCESS);
        responseDTO.setMessage("Success");
        responseDTO.setContent(employeeDTO);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
      }else {
        responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
        responseDTO.setMessage("no employee available for this empID");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      }

    }catch (Exception ex){
      responseDTO.setCode(VarList.RSP_ERROR);
      responseDTO.setMessage(ex.getMessage());
      responseDTO.setContent(null);
      return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //delete
  @DeleteMapping("/deleteEmpolyee/{empID}")
  public ResponseEntity deleteEmpolyee(@PathVariable int empID) {
    try{

      String res = employeeService.deleteEmployee(empID);

      if(res.equals("00")){
        responseDTO.setCode(VarList.RSP_SUCCESS);
        responseDTO.setMessage("Success");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
      }else {
        responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
        responseDTO.setMessage("no employee available for this empID");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
      }

    }catch (Exception ex){
      responseDTO.setCode(VarList.RSP_ERROR);
      responseDTO.setMessage(ex.getMessage());
      responseDTO.setContent(null);
      return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
