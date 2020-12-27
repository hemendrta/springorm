package com.spring.orm.dao;

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
		
		Employee employee=new Employee();
		
		employee = hibernateTemplate.get(Employee.class, id);
		
		return employee;
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
