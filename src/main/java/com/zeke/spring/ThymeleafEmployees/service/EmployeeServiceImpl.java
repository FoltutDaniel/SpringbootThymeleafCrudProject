package com.zeke.spring.ThymeleafEmployees.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeke.spring.ThymeleafEmployees.entity.Employee;
import com.zeke.spring.ThymeleafEmployees.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return this.employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return this.employeeDao.getEmployee(id);
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		return this.employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public int deleteEmployee(int id) {
		return this.employeeDao.deleteEmployee(id);
	}

}
