package com.ecxio.springhibernate.dao;

import com.ecxio.springhibernate.model.Login;

public interface LoginDAO {

	String validateUsernamePassword(Login l);

}
