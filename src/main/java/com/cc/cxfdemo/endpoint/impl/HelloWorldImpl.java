package com.cc.cxfdemo.endpoint.impl;

import javax.jws.WebService;

import com.cc.cxfdemo.endpoint.HelloWorld;

@WebService(endpointInterface = "com.cc.cxfdemo.endpoint.HelloWorld") 
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHi(String text) {
		return "Hello u!";
	}

}
