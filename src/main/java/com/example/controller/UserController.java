package com.example.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bo.PostBO;
import com.example.bo.UserBO;
import com.example.domain.Post;
import com.example.domain.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserBO userBO;
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String adduser(@ModelAttribute("userForm") User user,
			BindingResult result) {
		userBO.savePost(user);
		return "redirect:/";
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody Collection<User> users(Model model) {
		List<User> userList = userBO.getAllUsers();
		return userList;
	}
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public @ResponseBody Collection<User> users(Model model, @RequestParam("userid") String userId) {
		List<User> userList = userBO.getAllUsers();
		return userList;
	}
	
	
}
