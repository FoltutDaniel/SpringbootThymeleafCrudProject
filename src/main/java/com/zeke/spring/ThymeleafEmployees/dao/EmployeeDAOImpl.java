package com.zeke.spring.ThymeleafEmployees.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeke.spring.ThymeleafEmployees.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class); //getting current hibernate session
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the list

		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
		return employee;
	}

	@Override
	public int deleteEmployee(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.delete(currentSession.get(Employee.class, id));
		
		return id;
	}

}
