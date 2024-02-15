package org.jsp.assignment;

import java.util.List;
import java.util.Scanner;

import org.jsp.controller.UserResultSetExtractor;
import org.jsp.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class FetchByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long phone = sc.nextLong();
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "select * from user where phone=?";
		List<User> users = template.query(sql, new Object[] { phone }, new UserResultSetExtractor());
		for (User u : users) {
			System.out.println("User Id: " + u.getId());
			System.out.println("User Name: " + u.getName());
			System.out.println("User Phone: " + u.getPhone());
			System.out.println("User Password: " + u.getPassword() + " Don't Remember It!!!!");

//			System.out.println(u);
			System.out.println("=============================");
		}
	}

}
