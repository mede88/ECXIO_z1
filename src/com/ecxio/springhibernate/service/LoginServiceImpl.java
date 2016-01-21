package com.ecxio.springhibernate.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.ecxio.springhibernate.dao.LoginDAO;
import com.ecxio.springhibernate.model.Login;
 
@Service
@ManagedBean(name="loginService")
@SessionScoped
public class LoginServiceImpl implements LoginService {
 
    private LoginDAO loginDAO;
      
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

	@Override
	 @Transactional
	public String validateUsernamePassword(Login l) {
		 return this.loginDAO.validateUsernamePassword(l);
		
	}

  
}
