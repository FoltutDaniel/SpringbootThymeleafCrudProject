package com.zeke.spring.ThymeleafEmployees.dao;

import java.util.List;

import com.zeke.spring.ThymeleafEmployees.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee getEmployee(int id);
	
	public Employee saveEmployee(Employee employee);
	
	public int deleteEmployee(int id);
}
