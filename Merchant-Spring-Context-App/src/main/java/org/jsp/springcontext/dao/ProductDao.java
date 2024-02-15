package org.jsp.springcontext.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.springcontext.dto.Merchant;
import org.jsp.springcontext.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private EntityManager manager;

	public Product saveProduct(Product p, int mer_id) {
		Merchant m = manager.find(Merchant.class, mer_id);
		if (m != null) {
			m.getProducts().add(p);
			p.setMerchant(m);
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(p);
			transaction.begin();
			transaction.commit();
			return p;
		}
		return null;
	}

	public Product updateProduct(Product p) {
		Product p1 = manager.find(Product.class, p.getId());
		if (p1 != null) {
			p1.setName(p.getName());
			p1.setBrand(p.getBrand());
			p1.setCategory(p.getCategory());
			p1.setDescription(p.getDescription());
			p1.setCost(p.getCost());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return p1;
		}
		return null;
	}

	public List<Product> findProductByMerchantId(int mer_id) {
		Query q = manager.createQuery("select m.products from Merchant m where m.id=?1");
		q.setParameter(1, mer_id);
		return q.getResultList();
	}

	public List<Product> findProductByBrand(String brand) {
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);
		return q.getResultList();
	}

	public List<Product> findProductByCategory(String category) {
		Query q = manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, category);
		return q.getResultList();
	}

}
