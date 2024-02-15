package org.jsp.controller;

import java.util.List;
import org.jsp.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class FetchUsers {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		List<User> users = template.query("select * from user", new UserResultSetExtractor());
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
