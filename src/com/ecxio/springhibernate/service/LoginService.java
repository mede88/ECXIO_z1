package com.ecxio.springhibernate.service;

import com.ecxio.springhibernate.model.Login;

public interface LoginService {

	public String validateUsernamePassword(Login l);
}
