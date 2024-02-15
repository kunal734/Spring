package org.jsp.employee.dao;

import java.util.Scanner;

import org.jsp.employee.dto.Employee;

public class EmployeeDao {

	static Scanner sc = new Scanner(System.in);

	public Employee saveEmployee() {
		Employee e = new Employee();
		e.setName(sc.next());
		e.setDesig(sc.next());
		e.setEmail(sc.next());
		e.setPhone(sc.nextLong());
		e.setSalary(sc.nextDouble());
		e.setPassword(sc.next());
		return e;
	}

	public Employee updateEmployee(Employee e) {
		return e;
	}

	public Employee findEmpById(int id) {
		return null;
	}

	public boolean verifyEmployeeById(int id, String password) {
		return false;
	}

	public boolean verifyEmployeeByPhone(long phone, String password) {
		return false;
	}

	public boolean verifyEmployeeByEmail(String email, String password) {
		return false;
	}

	public Employee findEmployeeByDesg(Employee e) {
		return e;
	}

	public Employee findEmployeeByName(Employee e) {
		return e;
	}

	public Employee findEmployeeBySalary(Employee e) {
		return e;
	}

	public Employee filterBySalary(double lowsal, double highsal) {
		return null;
	}
}
