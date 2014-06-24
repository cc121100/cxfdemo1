package com.cc.cxfdemo.client;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;

import com.cc.cxfdemo.domain.User;

public class HttpClientTest1 {
	/** 本地测试 */
	private final static String HTTP_URL = "http://localhost:8080/cxfdemo/rest/userservice/";

	/** 生产测试 */
	// private final static String HTTP_URL="http://XXXX:8080/demo/webservice/";

	/** 连接超时时间 */
	private final static int CONN_TIMEOUT = 5000;
	/** 请求超时时间 */
	private final static int REQUEST_TIMEOUT = 5000;

	private final static String RETURN_FOMATE = "json";// 支持json、xml

	/**
	 * 请求服务器入口 创 建 人: XX 创建时间: 2012-11-7 下午03:39:55
	 * 
	 * @param methodName
	 *            方法名
	 * @param map
	 *            上送输入参数集合
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public String doPost(String methodName, Map<String, String> map,String jsonStr) {
		String uri = HTTP_URL + methodName;

		String result = null;
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(CONN_TIMEOUT); // 连接超时 设置
		PostMethod postMethod = new PostMethod(uri);

//		postMethod.setRequestBody(this.getPostParams(map));
		postMethod.setRequestBody(jsonStr);
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				REQUEST_TIMEOUT); // post请求超时 设置
		postMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		postMethod.setRequestHeader("Content-Type","application/json");
		try {
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {// 如果请求返回的不是成功，则进行处理
				return new String(postMethod.getResponseBodyAsString());
			} else {
				result = new String(postMethod.getResponseBodyAsString());
			}
		} catch (HttpException e) {
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
			return e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}

	public String doGet(String methodName, Map<String, String> map) {
		String uri = HTTP_URL + methodName;
		String result = null;

		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(CONN_TIMEOUT); // 连接超时 设置
		GetMethod getMethod = new GetMethod(uri);
		// getMethod.setQueryString(this.getPostParams(map));

		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				REQUEST_TIMEOUT); // get请求超时 设置
		getMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

		try {
			int statusCode = httpClient.executeMethod(getMethod);
			System.out.println("statusCode:" + statusCode);
			if (statusCode != HttpStatus.SC_OK) {// 如果请求返回的不是成功，则进行处理
				return new String(getMethod.getResponseBodyAsString());
			} else {
				result = new String(getMethod.getResponseBodyAsString());
			}
		} catch (HttpException e) {
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
			return e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			getMethod.releaseConnection();
		}
		return result;
	}

	private NameValuePair[] getPostParams(Map<String, String> map) {
		map.put("_type", RETURN_FOMATE);
		NameValuePair[] data = new NameValuePair[map.size()];
		Iterator<String> it = map.keySet().iterator();
		int i = 0;
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			data[i] = new NameValuePair(key, value);
			i++;
		}
		return data;
	}

	public static void main(String[] args) throws IOException {
		HttpClientTest1 client1 = new HttpClientTest1();
		System.out.println("----");
		Map<String , String> map = new HashMap<String, String>();
		map.put("id", "001");
		System.out.println(client1.doGet("users", null));

		/*User user = new User("005", "dasd", "aaa", 29, new Date(),
				"asdasd@qq.com");
		ObjectMapper objectMapper = new ObjectMapper();
		String userStr = objectMapper.writeValueAsString(user);

		Map<String, String> map = new HashMap<String, String>();
		System.out.println("param:" + userStr);
		String aa = "{'user':{'id':'005','name':'dasd','password':'aaa','age':29,'birthday':'1400379680911',email':'asdasd@qq.com'}}";
		map.put("user", userStr);
		System.out.println(client1.doPost("user/add", null,userStr));*/
		
		/*Map<String, String> map = new HashMap<String, String>();
		map.put("id", "005");
		map.put("name", "asdasd");
		map.put("password", "asdasd");
		map.put("age", "34");
		map.put("birthady", "2013-10-10");
		map.put("email", "22@qq.com");

		System.out.println(client1.doPost("user/add", map));*/
		
	}
}
