package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserDAO {

	@Autowired
	MongoOperations mongoTemplate;

	public void savePost(User user) {
		mongoTemplate.save(user);
	}

	public List<User> getAllUsers() {
		Query query = new Query();
//		query.with(new Sort(Sort.Direction.DESC,"u"));
		ArrayList<User> allUserList = (ArrayList<User>) mongoTemplate
				.find(query, (User.class));
		return allUserList;
	}
	
}
