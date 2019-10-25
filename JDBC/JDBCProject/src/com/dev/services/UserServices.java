package com.dev.services;

import com.dev.beans.User;

public interface UserServices {
	public User getAllInfo();
	public void createProfile(User user);
}
