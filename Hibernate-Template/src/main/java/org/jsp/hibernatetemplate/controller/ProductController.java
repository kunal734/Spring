package org.jsp.hibernatetemplate.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibernatetemplate.dao.ProductDao;
import org.jsp.hibernatetemplate.dto.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class ProductController {
	static ProductDao dao;
	static Scanner sc = new Scanner(System.in);
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("product-cfg.xml");
		dao = context.getBean(ProductDao.class);
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Save Product");
			System.out.println("2. Update Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Find Product By Id");
			System.out.println("5. Find All Products");
			System.out.println("6. Exit");
			int op = sc.nextInt();
			switch (op) {
			case 1:
				save();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				findById();
				break;
			case 5:
				findAll();
				break;
			case 6:
				System.exit(op);
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	private static void save() {
		System.out.println("Enter Product Name, Brand, Category, Description, Cost To Register Product:");
		Product p = new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setDescription(sc.next());
		p.setCost(sc.nextDouble());
		dao.saveProduct(p);
	}

	private static void update() {
		System.out.println("Enter Id To Update:");
		int id = sc.nextInt();
		System.out.println("Enter Product Name, Brand, Category, Description, Cost To Update Product:");
		Product p = new Product();
		p.setId(id);
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setDescription(sc.next());
		p.setCost(sc.nextDouble());
		p = dao.updateProduct(p);
		if (p != null)
			System.out.println("Product Updated Successfully");
		else
			System.out.println("Cannot Update as Id is not Present");
	}

	private static void delete() {
		System.out.println("Enter Id To Delete:");
		int id = sc.nextInt();
		boolean flag = dao.deleteProduct(id);
		if (flag) {
			System.out.println("Product Deleted Successfully");
		} else {
			System.out.println("Cannot Find Product");
		}
	}

	private static void findById() {
		System.out.println("Enter Id To Delete:");
		int id = sc.nextInt();
		Product p = dao.findById(id);
		if (p != null) {
			System.out.println(p);
			System.out.println("Product Found Successfully");
		} else {
			System.out.println("Cannot Find Product");
		}
	}

	private static void findAll() {
		List<Product> products = dao.findAll();
		if (products != null) {
			System.out.println(products);
		} else {
			System.out.println("No Products Found");
		}
	}

}
