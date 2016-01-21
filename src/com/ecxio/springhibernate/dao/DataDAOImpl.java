package com.ecxio.springhibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ecxio.springhibernate.model.Data;


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
		List<Data> dataList = session.createQuery("from Data where approved=:approved").setParameter("approved", true).list();
		for(Data d : dataList){
			logger.info("Data List::"+d);
		}
		return dataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Data> listAdmin() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Data> dataList = session.createQuery("from Data where approved=:approved").setParameter("approved", false).list();
		for(Data d : dataList){
			logger.info("Data List::"+d);
		}
		return dataList;
	}

	@Override
	public void updateData(Data d) {
		this.sessionFactory.getCurrentSession().update(d);
	}

}