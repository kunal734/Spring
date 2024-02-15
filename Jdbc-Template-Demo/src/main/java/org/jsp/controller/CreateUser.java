package org.jsp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateUser {
	public static void main(String[] args) {
		String sql = "create table user (id int not null, name varchar(45) not null, phone bigInt(20) not null unique, password varchar(45) not null, primary key(id))";
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		template.execute(sql);
		System.out.println("User Table Created");
	}
}
