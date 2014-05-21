package com.cc.cxfdemo.dao;

import java.util.List;

import com.cc.cxfdemo.data.Datas;
import com.cc.cxfdemo.domain.User;

public class UserDao {
	
	public List<User> getAllUsers(){
		return Datas.getUsers();
	}
	
	public User getUserById(String id){
		User user = null;
		for(User u : Datas.getUsers()){
			if(u.getId().equals(id)){
				user = u;
				break;
			}
		}
		
		return user;
	}
	
	public void addUser(User user){
		Datas.getUsers().add(user);
	}

}
