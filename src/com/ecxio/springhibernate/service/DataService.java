package com.ecxio.springhibernate.service;

import java.util.List;

import com.ecxio.springhibernate.model.Data;
import com.ecxio.springhibernate.model.Login;
  
public interface DataService {
  
    public void addData(Data d);
    public List<Data> listData();
    public List<Data> listAdmin();
    public String validateUsernamePassword(Login l);
    public void updateUser(Data d);
      
}