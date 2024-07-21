package com.nt.dao;

public interface ILoginDAO {
	public int authenticate(String username, String password);
	public int addUser(String user, String role);
}
