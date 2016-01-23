package com.ecxio.springhibernate.model;

import javax.faces.bean.ManagedBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@ManagedBean(name="login" )
public class Login {

	@Id
	@Column(name="username")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;
	private String password;
	private int enabled;

	//Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password  + ", enabled=" + enabled + "]";
	}

}
