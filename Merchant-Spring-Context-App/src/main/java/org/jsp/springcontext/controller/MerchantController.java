package org.jsp.springcontext.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.springcontext.MyConfig;
import org.jsp.springcontext.dao.MerchantDao;
import org.jsp.springcontext.dao.ProductDao;
import org.jsp.springcontext.dto.Merchant;
import org.jsp.springcontext.dto.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MerchantController {
	static MerchantDao mDao;
	static ProductDao pDao;
	static Scanner sc = new Scanner(System.in);
	static {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		mDao = context.getBean(MerchantDao.class);
		pDao = context.getBean(ProductDao.class);
	}

	public static void main(String[] args) {
		System.out.println("=====Welcome To Merchant-Product Database=====");
		while (true) {
			System.out.println("1.Save Merchant");
			System.out.println("2.Update Merchant");
			System.out.println("3.Find Merchant By Id");
			System.out.println("4.Verify Merchant By Phone");
			System.out.println("5.Verify Merchant By Email");
			System.out.println("6.Save Product");
			System.out.println("7.Update Product");
			System.out.println("8.Find Product By Merchant Id");
			System.out.println("9.Find Product By Brand");
			System.out.println("10.Find Product By Category");

			int op = sc.nextInt();
			switch (op) {
			case 1:
				saveMerchant();
				break;
			case 2:
				updateMerchant();
				break;
			case 3:
				findById();
				break;
			case 4:
				verifyByPhone();
				break;
			case 5:
				verifyByEmail();
				break;
			case 6:
				saveProduct();
				break;
			case 7:
				updateProduct();
				break;
			case 8:
				findProductByMerId();
				break;
			case 9:
				findProductByBrand();
				break;
			case 10:
				findProductByCat();
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	public static void saveMerchant() {
		System.out.println("Enter Name,Phone,Email,Password To Register Merchant: ");
		Merchant m = new Merchant();
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		mDao.saveMerchant(m);
	}

	public static void updateMerchant() {
		System.out.println("Enter Merchant id to update: ");
		int id = sc.nextInt();
		System.out.println("Enter the name,phone,email and password to Update Employee: ");
		Merchant m = new Merchant();
		m.setId(id);
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		m = mDao.updateMerchant(m);
		if (m != null) {
			System.out.println("Merchant updated!!!");
		} else {
			System.out.println("Cannot update Merchant!!!");
		}
	}

	public static void findById() {
		System.out.println("Enter Id to Fetch the Merchant Details:-");
		int id = sc.nextInt();
		Merchant m = mDao.findMerById(id);
		if (m != null) {
			System.out.println("Merchant Id: " + m.getId());
			System.out.println("Merchant Name: " + m.getName());
			System.out.println("Merchant Phone: " + m.getPhone());
			System.out.println("Merchant Email: " + m.getEmail());
			System.out.println("===================================");
		} else {
			System.out.println("Invalid Id!!!");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter Phone and Password to Verify the Merchant Details:-");
		System.out.println("Enter Phone: ");
		long phone = sc.nextLong();
		System.out.println("Enter Password: ");
		String password = sc.next();
		Merchant m = mDao.verifyMerByPhone(phone, password);
		if (m != null) {
			System.out.println("Merchant Id: " + m.getId());
			System.out.println("Merchant Name: " + m.getName());
			System.out.println("Merchant Phone: " + m.getPhone());
			System.out.println("Merchant Email: " + m.getEmail());
			System.out.println("=======================================");
		} else {
			System.out.println("Invalid Phone or Password!!!");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter Email and Password to Verify the Merchant Details:-");
		System.out.println("Enter Email: ");
		String email = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		Merchant m = mDao.verifyMerByEmail(email, password);
		if (m != null) {
			System.out.println("Merchant Id: " + m.getId());
			System.out.println("Merchant Name: " + m.getName());
			System.out.println("Merchant Phone: " + m.getPhone());
			System.out.println("Merchant Email: " + m.getEmail());
			System.out.println("=======================================");
		} else {
			System.out.println("Invalid Email or Password!!!");
		}
	}

	public static void saveProduct() {

		System.out.println("Enter Merchant Id To Save Product:-");
		int mId = sc.nextInt();
		Product p = new Product();
		System.out.println("Enter Product Name,Brand,Category,Description,Cost To save Product:");
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setDescription(sc.next());
		p.setCost(sc.nextDouble());
		p = pDao.saveProduct(p, mId);
		if (p != null) {
			System.out.println("Product added with Id: " + p.getId());
		} else {
			System.out.println("Cannot Save as Invalid Merchant Id ");
		}
	}

	public static void updateProduct() {
		System.out.println("Enter Id To Update Details:-");
		int id = sc.nextInt();
		System.out.println("Enter the product Name, Brand, Category, Description, Cost To Update:-");

		Product p = new Product();
		p.setId(id);
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setDescription(sc.next());
		p.setCost(sc.nextDouble());
		p = pDao.updateProduct(p);
		if (p != null) {
			System.out.println("Product Details has been Updated");
		} else {
			System.err.println("Cannot Update product Details");
		}
	}

	public static void findProductByMerId() {
		System.out.println("Enter Merchant Id to Fetch The Details:-");
		int mer_id = sc.nextInt();
		List<Product> products = pDao.findProductByMerchantId(mer_id);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id: " + p.getId());
				System.out.println("Product Name: " + p.getName());
				System.out.println("Product Brand: " + p.getBrand());
				System.out.println("Product Category: " + p.getCategory());
				System.out.println("Product Description: " + p.getDescription());
				System.out.println("Product Cost: " + p.getCost());
				System.out.println("---------------------------------");
			}
		} else {
			System.err.println("Invalid Id");
		}
	}

	public static void findProductByBrand() {
		String brand = sc.next();
		List<Product> products = pDao.findProductByBrand(brand);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id: " + p.getId());
				System.out.println("Product Name: " + p.getName());
				System.out.println("Product Brand: " + p.getBrand());
				System.out.println("Product Category: " + p.getCategory());
				System.out.println("Product Description: " + p.getDescription());
				System.out.println("Product Cost: " + p.getCost());
				System.out.println("---------------------------------");
			}
		} else {
			System.err.println("Invalid Brand");
		}
	}

	public static void findProductByCat() {
		String category = sc.next();
		List<Product> products = pDao.findProductByCategory(category);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id: " + p.getId());
				System.out.println("Product Name: " + p.getName());
				System.out.println("Product Brand: " + p.getBrand());
				System.out.println("Product Category: " + p.getCategory());
				System.out.println("Product Description: " + p.getDescription());
				System.out.println("Product Cost: " + p.getCost());
				System.out.println("---------------------------------");
			}
		} else {
			System.err.println("Invalid Category");
		}
	}
}
