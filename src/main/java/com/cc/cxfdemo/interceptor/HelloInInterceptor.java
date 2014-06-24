package com.cc.cxfdemo.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class HelloInInterceptor extends AbstractPhaseInterceptor<Message> {

	public HelloInInterceptor() {  
        super(Phase.RECEIVE);  
    }
	
	public HelloInInterceptor(String phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(Message arg0) throws Fault {
		System.out.println("***********HelloInInterceptor********");
		
	}

}
