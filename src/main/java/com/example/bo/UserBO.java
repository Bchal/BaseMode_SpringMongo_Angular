package com.example.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.domain.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;

	public void savePost(User user) {
		userDAO.savePost(user);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
