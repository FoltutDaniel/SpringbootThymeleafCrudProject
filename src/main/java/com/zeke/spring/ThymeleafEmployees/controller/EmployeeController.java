package com.zeke.spring.ThymeleafEmployees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		//get employee from service
		Employee theEmployee = employeeService.getEmployee(theId);
		theModel.addAttribute("employee",theEmployee);
		
		return "add-form";
	}
	
	@GetMapping("/delete")
	public String  delete(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteEmployee(theId);
		return "redirect:/employees/list";
	}
}

