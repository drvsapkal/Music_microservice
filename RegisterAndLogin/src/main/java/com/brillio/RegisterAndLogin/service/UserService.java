package com.brillio.RegisterAndLogin.service;

import java.util.List;

import com.brillio.RegisterAndLogin.model.User;

public interface UserService {

	public User save(User user);

	public boolean delete(User user);

	public boolean validate(String email, String password);

	public User getUser(String email);

	public String getToken(String email, String password) throws Exception;
}