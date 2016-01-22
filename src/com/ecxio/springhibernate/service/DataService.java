package com.ecxio.springhibernate.service;

import java.util.List;

import com.ecxio.springhibernate.model.Data;
  
public interface DataService {
  
    public void addData(Data d);
    public List<Data> listData();
    public List<Data> listAdmin();
    public String approve();
    public void updateData(Data d);
    public Data getData(String s);
      
}