package org.jsp.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertUser {
	public static void main(String[] args) {
		// Static Query
//		String sql = "insert into user values(2,'ABC',777888,'abc123')";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id, Name, Phone, Password to Insert User:");
		int id = sc.nextInt();
		String name = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		// Dyanamic Query
		String sql = "insert into user values(?,?,?,?)";
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		int r = template.update(sql, id, name, phone, password);
		System.out.println(r + " Rows Inserted");
		sc.close();
	}
}
