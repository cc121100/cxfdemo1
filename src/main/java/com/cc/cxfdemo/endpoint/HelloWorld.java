package com.cc.cxfdemo.endpoint;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style=Style.RPC)
public interface HelloWorld {
	
	String sayHi(String text);
	
	

}
