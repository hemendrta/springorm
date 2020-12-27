package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entitites.Employee;

public class EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	/* Insert Data */

	@Transactional
	public int insertStudent(Employee employee) {

		Integer row = (Integer) hibernateTemplate.save(employee);
		return row;

	}

	/* Get Single Object */

	public Employee getEmployeeById(int id) {

		Employee employee = new Employee();

		employee = hibernateTemplate.get(Employee.class, id);

		return employee;

	}

	/* Get Multiple Objects */

	public List<Employee> getAllEmployees() {

		List<Employee> employees = hibernateTemplate.loadAll(Employee.class);

		return employees;

	}

	/* Delete Object from the Database */

	@Transactional
	public void deleteById(int id) {

		Employee employee = hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);

	}
	
	@Transactional
	public Employee updateEmployee(Employee employee) {
		
		hibernateTemplate.update(employee);
		
		Employee employee2 = hibernateTemplate.get(Employee.class, employee.getId());
		
		return employee2;
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
