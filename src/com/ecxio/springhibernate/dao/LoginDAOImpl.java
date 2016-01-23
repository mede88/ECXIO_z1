package com.ecxio.springhibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ecxio.springhibernate.model.Login;


@Repository
public class LoginDAOImpl implements LoginDAO{

	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@SuppressWarnings("unchecked")
	@Override
	public String validateUsernamePassword(Login l) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Login> logInSuccess = session.createQuery("from Login where username=:username and password=:password").setParameter("username", l.getUsername()).setParameter("password", l.getPassword()).list();
		logger.info("Login validation, Details="+l);
		if (logInSuccess.size() > 0)
			return "admin";
		else
			return "login";
	}

}
