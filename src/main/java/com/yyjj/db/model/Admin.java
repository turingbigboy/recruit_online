package com.yyjj.db.model;

import java.io.Serializable;

/**
 * <p>
 * 管理员信息
 * </p>
 *
 * @author yml
 * @since 2020-03-18
 */
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String account;

    private String password;

    private String name;

    private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", email="
				+ email + "]";
	}

  
}
