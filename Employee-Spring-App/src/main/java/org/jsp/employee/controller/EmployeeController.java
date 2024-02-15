package org.jsp.employee.controller;

import org.jsp.employee.dto.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeController {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Employee e = context.getBean(Employee.class);
		System.out.println("=====Welcome To Employee Database=====");
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("3.Find Employee By Desg");
		System.out.println("3.Find Employee By Salary");
		System.out.println("3.Find Employee By Name");
		System.out.println("3.Verify Employee By Id");
		System.out.println("3.Verify Employee By Email");
		System.out.println("3.Verify Employee By Phone");
		System.out.println("3.Filter Employee By Salary");

	}
}
