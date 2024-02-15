package org.jsp.hibernatetemplate.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("product-cfg.xml");
		HibernateTemplate t = context.getBean("hibernateTemplate", HibernateTemplate.class);
		System.out.println(t);
	}
}
