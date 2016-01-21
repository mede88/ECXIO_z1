package com.ecxio.springhibernate.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.ecxio.springhibernate.dao.DataDAO;
import com.ecxio.springhibernate.model.Data;
import com.ecxio.springhibernate.model.Login;
 
@Service
@ManagedBean(name="dataService")
@SessionScoped
public class DataServiceImpl implements DataService {
 
    private DataDAO dataDAO;
      
    public void setDataDAO(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }
  
    @Override
    @Transactional
    public void addData(Data d) {
        this.dataDAO.addData(d);
    }
  
    @Override
    @Transactional
    public List<Data> listData() {
        return this.dataDAO.listData();
    }
    
    @Override
    @Transactional
    public List<Data> listAdmin() {
        return this.dataDAO.listAdmin();
    }

	@Override
	 @Transactional
	public String validateUsernamePassword(Login l) {
		 return this.dataDAO.validateUsernamePassword(l);
		
	}

	@Override
	public void updateUser(Data d) {
		this.dataDAO.updateUser(d);
		
	}
  
}