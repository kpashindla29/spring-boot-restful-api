package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ab.dto.DeptEmployeeDto;
import com.ab.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
  @Query("SELECT new com.ab.DeptEmploeee(d.deptId,d.deptName,e.employeeName) FROM Department d INNER JOIN d.employees e ON d.deptId = e.deptId")
  public List<DeptEmployeeDto> loadDeptWithEmployees();
  
}
