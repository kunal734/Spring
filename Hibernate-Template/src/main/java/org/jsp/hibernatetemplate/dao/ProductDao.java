package org.jsp.hibernatetemplate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jsp.hibernatetemplate.dto.Product;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class ProductDao {

	private HibernateTemplate template;

	@Transactional
	public Product saveProduct(Product p) {
		template.save(p);
		return p;
	}

	@Transactional
	public Product updateProduct(Product p) {
		Product dp = template.get(Product.class, p.getId());
		if (dp != null) {
			dp.setName(p.getName());
			dp.setBrand(p.getBrand());
			dp.setCategory(p.getCategory());
			dp.setCost(p.getCost());
			dp.setDescription(p.getDescription());
			template.update(dp);
			return dp;
		}
		return null;
	}

	@Transactional
	public boolean deleteProduct(int id) {
		Product p = template.get(Product.class, id);
		if (p != null) {
			template.delete(p);
			return true;
		} else {
			return false;
		}
	}

	public Product findById(int id) {
		return template.get(Product.class, id);
	}

	public List<Product> findAll() {
		return template.loadAll(Product.class);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
