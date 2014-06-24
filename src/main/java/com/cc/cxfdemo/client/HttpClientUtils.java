package com.cc.cxfdemo.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtils {
	
	/** 连接超时时间 */
	private final static int CONN_TIMEOUT = 5000;
	/** 请求超时时间 */
	private final static int REQUEST_TIMEOUT = 5000;
	
	public static InputStream doGet(String url,Map<String, String> map){
		InputStream inputStream = null;

		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(CONN_TIMEOUT); // 连接超时 设置
		GetMethod getMethod = new GetMethod(url);
		// getMethod.setQueryString(this.getPostParams(map));

		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				REQUEST_TIMEOUT); // get请求超时 设置
		getMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

		try {
			int statusCode = httpClient.executeMethod(getMethod);
			//System.out.println("statusCode:" + statusCode);
			if (statusCode != HttpStatus.SC_OK) {// 如果请求返回的不是成功，则进行处理
				inputStream = getMethod.getResponseBodyAsStream(); 
			} else {
				return null;
			}
		} catch (HttpException e) {
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return inputStream;
	}

}
