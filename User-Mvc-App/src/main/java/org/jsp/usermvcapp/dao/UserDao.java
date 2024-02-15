package org.jsp.usermvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public User saveUser(User user) {
		manager.persist(user);
		EntityTransaction t = manager.getTransaction();
		t.begin();
		t.commit();
		return user;
	}

	public User updateUser(User user) {
		User dbUser = findUserById(user.getId());
		if (dbUser != null) {
			EntityTransaction t = manager.getTransaction();
			dbUser.setName(user.getName());
			dbUser.setAge(user.getAge());
			dbUser.setGender(user.getGender());
			dbUser.setPhone(user.getPhone());
			dbUser.setEmail(user.getEmail());
			dbUser.setPassword(user.getPassword());
			t.begin();
			t.commit();
			return dbUser;
		} else {
			return null;
		}
	}

	public User findUserById(int id) {
		return manager.find(User.class, id);
	}

	public boolean deleteUser(int id) {
		EntityTransaction t = manager.getTransaction();
		User u = manager.find(User.class, id);
		if (u != null) {
			manager.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}

	public User verifyUserById(int id, String password) {
		Query q = manager.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUserByPhone(long phone, String password) {
		Query q = manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUserByEmail(String email, String password) {
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
