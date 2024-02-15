package org.jsp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateUser {
	public static void main(String[] args) {
		String sql = "update user set name='xyz',password='xyz123' where id=1";
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		int r = template.update(sql);
		System.out.println(r + "rows updated");
	}
}
