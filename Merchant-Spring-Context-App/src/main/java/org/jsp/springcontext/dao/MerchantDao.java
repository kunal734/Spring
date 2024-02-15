package org.jsp.springcontext.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.springcontext.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private EntityManager manager;

	public Merchant saveMerchant(Merchant mer) {
		manager.persist(mer);
		EntityTransaction t = manager.getTransaction();
		t.begin();
		t.commit();
		return mer;
	}

	public Merchant updateMerchant(Merchant mer) {
		Merchant dbMer = findMerById(mer.getId());
		if (dbMer != null) {
			EntityTransaction t = manager.getTransaction();
			dbMer.setId(mer.getId());
			dbMer.setName(mer.getName());
			dbMer.setEmail(mer.getEmail());
			dbMer.setPhone(mer.getPhone());
			dbMer.setPassword(mer.getPassword());
			t.begin();
			t.commit();
			return dbMer;
		} else {
			return null;
		}
	}

	public Merchant findMerById(int id) {
		return manager.find(Merchant.class, id);
	}

	public Merchant verifyMerByPhone(long phone, String password) {
		Query q = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant verifyMerByEmail(String email, String password) {
		Query q = manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
