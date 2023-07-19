package com.example.ems.repo;

import com.example.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

  @Query(value = "SELECT * FROM Employee WHERE empID = ?1", nativeQuery = true)
  Employee getEmployeeById(int empID);

}
