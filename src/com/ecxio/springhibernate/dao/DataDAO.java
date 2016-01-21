package com.ecxio.springhibernate.dao;

import java.util.List;
import com.ecxio.springhibernate.model.Data;
  
public interface DataDAO {
  
    public void addData(Data d);
    public List<Data> listData();
	public List<Data> listAdmin();
	public void updateData(Data d);
}