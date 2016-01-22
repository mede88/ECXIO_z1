package com.ecxio.springhibernate.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.ecxio.springhibernate.dao.DataDAO;
import com.ecxio.springhibernate.model.Data;
 
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

    // METODA SE POZIVA IZ AdminPage.xhtml
    // BUG je da ako se stranica refresha onda approva sve redke koji su ispod buttona s kojim se zadnje approvalo.
	@Override
	public void updateData(Data d) {
		d.setApproved(true);
		this.dataDAO.updateData(d);
		
	}
	
	
	/*
	 * OVO SAM PROBAO KORISTITI UMJESTO BUTTONA U ADMINPAGE.XHTML, 
	 * U TOM SLUCAJU IMAM OVE DVE METODE DOLE, AL NI TO MI NIJE RADILO
	   <!-- <h:commandLink  action="#{dataService.approve}" value="Approve"> -->
	   <!-- <f:param name="selectedRowIndex" value="#{data.id}"/> -->
	   <!-- </h:commandLink> -->
	*/
	public String approve() {
	     Data data = getData("selectedRowIndex");
	     updateData(data);
	     return "OK";
	   }
	
	public Data getData(String s){
		Data data = this.dataDAO.getData(Integer.parseInt(s));
		return data;
	}
  
}