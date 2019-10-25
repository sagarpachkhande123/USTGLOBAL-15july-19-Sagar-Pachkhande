package com.dev.dao;

import com.dev.beans.User;

public interface UserInfoDAO {
	public User getAllInfo();
	public void createProfile(User user);
}
