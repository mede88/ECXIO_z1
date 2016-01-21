package com.ecxio.springhibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ecxio.springhibernate.model.Data;
import com.ecxio.springhibernate.model.Login;


@Repository
public class DataDAOImpl implements DataDAO{

	private static final Logger logger = LoggerFactory.getLogger(DataDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addData(Data d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Data saved successfully, Details="+d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Data> listData() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Data> dataList = session.createQuery("from Data where approved=:approved").setParameter("approved", 1).list();
		for(Data d : dataList){
			logger.info("Data List::"+d);
		}
		return dataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Data> listAdmin() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Data> dataList = session.createQuery("from Data where approved=:approved").setParameter("approved", 0).list();
		for(Data d : dataList){
			logger.info("Data List::"+d);
		}
		return dataList;
	}

	@Override
	public void updateUser(Data d) {
		this.sessionFactory.getCurrentSession().update(d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String validateUsernamePassword(Login l) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Login> logInSuccess = session.createQuery("from Login where username=:username and password=:password").setParameter("username", l.getUsername()).setParameter("password", l.getPassword()).list();
		if (logInSuccess.size() > 0)
			return "AdminPage";
		else
			return "LogInPage";
	}

}