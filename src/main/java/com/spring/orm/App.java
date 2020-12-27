package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.EmployeeDao;
import com.spring.orm.entitites.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/orm/utilities/config.xml");
    	EmployeeDao employeeDao = applicationContext.getBean("employeeDao",EmployeeDao.class);
    	
    	Employee employee=new Employee();
    	employee.setId(101);
    	employee.setName("Hemendra Singh Chouhan");
    	employee.setContact(7999996891l);
    	
    	
    	System.out.println(employeeDao.insertStudent(employee));
    	
    	System.out.println("--------------------------------");
    	
    	System.out.println(employeeDao.getEmployeeById(101));
    	
    }
}
