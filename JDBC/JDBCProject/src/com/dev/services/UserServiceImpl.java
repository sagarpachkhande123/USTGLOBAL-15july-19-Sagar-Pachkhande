package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.UserDAOJDBCImpl;
import com.dev.dao.UserInfoDAO;

public class UserServiceImpl implements UserServices {

	UserInfoDAO dao = new UserDAOJDBCImpl();

	@Override
	public User getAllInfo() {
		return dao.getAllInfo();
	}

	@Override
	public void createProfile(User user) {
		dao.createProfile(user);
	}

}
