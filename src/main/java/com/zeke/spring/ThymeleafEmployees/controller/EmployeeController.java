package com.zeke.spring.ThymeleafEmployees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeke.spring.ThymeleafEmployees.entity.Employee;
import com.zeke.spring.ThymeleafEmployees.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String showAll(Model theModel) {
		
		//get employee list from employee service
		List<Employee> listEmployees = employeeService.findAll();
		theModel.addAttribute("employees",listEmployees);
		
		return "list-employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		return "add-form";
	}
	
	@PostMapping("/save")
	public String addEmployee() {
		return null;
	}
}

