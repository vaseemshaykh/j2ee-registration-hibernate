package com.example.hib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.hib.model.User;

public class UserDAO {

	Transaction transaction = null;
	Session session = null;
	SessionFactory sessionFactory = null;

	public UserDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveUser(User user) {

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			System.out.println("user details: "+user.getUsername());

			session.save(user);
			transaction.commit();

			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();

			return false;
		}
	}

}
