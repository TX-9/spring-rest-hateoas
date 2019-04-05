package com.tx9.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tx9.payroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
