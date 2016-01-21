package com.ecxio.springhibernate.dao;

import java.util.List;
import com.ecxio.springhibernate.model.Data;
import com.ecxio.springhibernate.model.Login;
  
public interface DataDAO {
  
    public void addData(Data d);
    public List<Data> listData();
	public List<Data> listAdmin();
	public String validateUsernamePassword(Login l);
	public void updateUser(Data d);
}