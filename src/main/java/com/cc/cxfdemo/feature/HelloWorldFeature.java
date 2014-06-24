package com.cc.cxfdemo.feature;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.cc.cxfdemo.interceptor.HelloInInterceptor;

public class HelloWorldFeature extends AbstractFeature {

	@Override
	protected void initializeProvider(InterceptorProvider provider, Bus bus) {
		provider.getInInterceptors().add(new LoggingInInterceptor());  
        provider.getInInterceptors().add(new HelloInInterceptor());  
        provider.getOutInterceptors().add(new LoggingOutInterceptor());
	}

}
