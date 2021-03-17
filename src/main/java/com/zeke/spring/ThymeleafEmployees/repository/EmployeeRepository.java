package com.zeke.spring.ThymeleafEmployees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeke.spring.ThymeleafEmployees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
