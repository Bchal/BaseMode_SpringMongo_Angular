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
import com.example.domain.Post;
import com.example.domain.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	PostBO postBO;

	@Autowired
	public void setPostBO(PostBO postBO) {
		this.postBO = postBO;
	}

	// Homepage returns lists of messages
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
//		logger.info("Home page requested");
		//get a list of all posts
		List<Post> postList = postBO.getAllPosts();
		//add to session
		model.addAttribute("postList", postList);
		model.addAttribute("postForm", new Post());
		//returns wall.jsp
		// return "wall";
		return "index";
	}
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody Collection<User> hello(Model model) {
		logger.info("hello  page requested");
		// List<Post> postList = postBO.getAllPosts();
		User u1 = new User();
		u1.setName("ian");
		u1.setAge(10);
		
		User u2 = new User();
		u2.setName("chunfeng");
		u2.setAge(10);
		
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		return users;
		
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String posts(Model model) {
		logger.info("posts requested");
		List<Post> postList = postBO.getAllPosts();
		//add to session
		model.addAttribute("postList", postList);
		model.addAttribute("postForm", new Post());
		//returns posts.jsp
		return "posts";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String addpost(@ModelAttribute("postForm") Post post,
			BindingResult result) {

		Date date = new Date();
		post.setDate(date);

		postBO.savePost(post);
		return "redirect:/";
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String reply(@RequestParam("id") String id,
			@ModelAttribute("postForm") Post post, BindingResult result) {

		//get post with id
		Post replyPost = postBO.getPostById(id);
		
		Date date = new Date();
		post.setDate(date);
		
		//embed new post into the replyPost document
		replyPost.addPost(post);

		postBO.savePost(replyPost);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") String id) {
		Post post = postBO.getPostById(id);
		postBO.deletePost(post);
		return "redirect:/";
	}

}
