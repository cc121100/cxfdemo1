package com.cc.cxfdemo.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cc.cxfdemo.domain.User;

public class Datas {
	
	private static List<User> users = new ArrayList<User>();
	
	static{
		users.add(new User("001", "user1", "passw0rd1", 21, new Date(), "user1@qq.com"));
		users.add(new User("002", "user2", "passw0rd2", 22, new Date(), "user2@qq.com"));
		users.add(new User("003", "user3", "passw0rd3", 23, new Date(), "user3@qq.com"));
		users.add(new User("004", "user4", "passw0rd4", 24, new Date(), "user4@qq.com"));
		
	}

	public static List<User> getUsers() {
		return users;
	}
	

}
