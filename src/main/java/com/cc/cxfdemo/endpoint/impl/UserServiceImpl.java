package com.cc.cxfdemo.endpoint.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.cc.cxfdemo.dao.UserDao;
import com.cc.cxfdemo.domain.User;
import com.cc.cxfdemo.endpoint.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public Response addUser(User user) {
		if (userDao.getUserById(user.getId()) != null) {  
            return Response.status(Status.BAD_REQUEST).build();  
        } else {  
        	userDao.addUser(user);
            return Response.ok(user).build();  
        }  
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
