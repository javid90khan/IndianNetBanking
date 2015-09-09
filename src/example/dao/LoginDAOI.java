package example.dao;

import example.entity.User;

public interface LoginDAOI {
	public String checkUser(String username,String password);
	public void blockUser(User user);
	
}
