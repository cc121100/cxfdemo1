package com.cc.cxfdemo.client;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cc.cxfdemo.domain.User;

public class RSETServiceClient1 {

	private static WebClient client;
    
    @Before
    public void init() {
        // 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
        String url = "http://localhost:8080/cxfdemo/rest/";
        client = WebClient.create(url);
 
        // 从Spring Ioc容器中拿webClient对象
        /*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-client.xml");
        client = ctx.getBean("webClient", WebClient.class);*/
    }
    
    @After
    public void destory(){
    }
    
    @Test
    public void testGet() {
        System.out.println(client.path("userservice/users").accept(MediaType.APPLICATION_XML).get(User.class));
    }
    
    /*@Test
    public void testRequest() {
        System.out.println(client.path("sample/request/234234").accept(MediaType.TEXT_PLAIN).get(String.class));
    }
    
    @Test
    public void testBean() {
        User user = client.path("sample/bean/{id}", 25).accept(MediaType.APPLICATION_XML).get(User.class);
        System.out.println(user);
    }
    
    @Test
    public void testList() {
        System.out.println(client.path("sample/list").accept(MediaType.APPLICATION_XML).get(Users.class).getUsers());
    }
    
    @Test
    public void testMap() {
        System.out.println(client.path("sample/map").accept(MediaType.APPLICATION_XML).get(MapBean.class).getMap());
    }
    
    @Test
    public void testDeleteData() {
        client.path("sample/removeData/23").delete();
    }
    
    @Test
    public void testPostData() {
        User user = new User();
        user.setId(21432134);
        user.setAddress("hoojo#gz");
        user.setEmail("hoojo_@126.com");
        user.setName("hoojo");
        System.out.println(client.path("sample/postData").accept(MediaType.APPLICATION_XML).post(user, User.class));
    }
    
    @Test
    public void testPutData() {
        User user = new User();
        user.setId(21432134);
        System.out.println(client.path("sample/putData/1").accept(MediaType.APPLICATION_XML).put(user).getEntity());
    }*/
	
}
