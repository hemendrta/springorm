package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.EmployeeDao;
import com.spring.orm.entitites.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/spring/orm/utilities/config.xml");
		EmployeeDao employeeDao = applicationContext.getBean("employeeDao", EmployeeDao.class);

		/* Insert Data to the Database */

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Hemendra Singh Chouhan");
		employee.setContact(7999996891l);

		Employee employee2 = new Employee();
		employee2.setId(102);
		employee2.setName("Subhash Singh Chouhan");
		employee2.setContact(7999996892l);

		Employee employee3 = new Employee();
		employee3.setId(103);
		employee3.setName("Nisha Singh Chouhan");
		employee3.setContact(7999996893l);

		Employee employee4 = new Employee();
		employee4.setId(104);
		employee4.setName("Aditi Singh Chouhan");
		employee4.setContact(7999996894l);

		Employee employee5 = new Employee();
		employee5.setId(105);
		employee5.setName("Sunny Singh Chouhan");
		employee5.setContact(7999996895l);

		System.out.println(employeeDao.insertStudent(employee));
		System.out.println(employeeDao.insertStudent(employee2));
		System.out.println(employeeDao.insertStudent(employee3));
		System.out.println(employeeDao.insertStudent(employee4));
		System.out.println(employeeDao.insertStudent(employee5));

		System.out.println("--------------------------------");

		/* Fetching Single Object from the Database */

		System.out.println(employeeDao.getEmployeeById(101));

		/* Fetching Multiple Objects from the Database */

		List<Employee> employees = employeeDao.getAllEmployees();

		System.out.println("---------------------------------");

		employees.stream().forEach(e -> System.out.println(e));

		/* Update Object */

		employee5.setName("Kishore");

		employeeDao.updateEmployee(employee5);

		System.out.println("----------------------------------");

		System.out.println(employeeDao.getEmployeeById(105));

		System.out.println("----------------------------------");

		/* Deleting Object from the Database */

		employeeDao.deleteById(105);

		System.out.println("----------------------------------");

		List<Employee> employees2 = employeeDao.getAllEmployees();

		employees2.stream().forEach(e -> System.out.println(e));

	}
}
