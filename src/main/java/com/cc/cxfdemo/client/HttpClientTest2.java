package com.cc.cxfdemo.client;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.FileUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasParentFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;
import org.junit.Test;

public class HttpClientTest2 {

	@Test
	public void test1() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		
		GetMethod getMethod = new GetMethod("http://bbs.tianya.cn/list-fans-1.shtml");
		
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				5000); // get请求超时 设置
		getMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		int statusCode = httpClient.executeMethod(getMethod);
		
		String html = getMethod.getResponseBodyAsString();
		
		System.out.println("statusCode:" + statusCode);
		
		//System.out.println("response:" + html);
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		
		getMethod.releaseConnection();
		
		Parser parser = null;
		NodeVisitor visitor = null;
		
		try {
			parser = new Parser(html);
			visitor = new NodeVisitor() {
				@Override
				public void visitTag(Tag tag){
					if(tag instanceof LinkTag){
						LinkTag linkTag = (LinkTag) tag;
						String linkString  = linkTag.getLink();
						System.out.println(linkString);
					}
					
				}
			};
			parser.visitAllNodesWith(visitor);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void test2() throws HttpException, IOException {
		
		HttpClient httpClient = new HttpClient();
		
		GetMethod getMethod = new GetMethod("http://bbs.tianya.cn/list-fans-1.shtml");
		
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				5000); // get请求超时 设置
		getMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		int statusCode = httpClient.executeMethod(getMethod);
		
		String html = getMethod.getResponseBodyAsString();
		
		System.out.println("statusCode:" + statusCode);
		
		//System.out.println("response:" + html);
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		System.out.println("===============================");
		
		getMethod.releaseConnection();
		
		try {
			Parser parser = new Parser(html);
			NodeList nodeList = parser.extractAllNodesThatMatch(new NodeFilter() {
				@Override
				public boolean accept(Node node) {
					if(node instanceof LinkTag){
						return true;
					}
					return false;
				}
			});
			for (int i = 0; i < nodeList.size(); i++) {  
                LinkTag n = (LinkTag) nodeList.elementAt(i);  
                //System.out.print(n.getStringText() + " ==>> ");  
                System.out.println(n.extractLink());  
            }  
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void test3() throws HttpException, IOException, ParserException {
		
		HttpClient httpClient = new HttpClient();
		
		GetMethod getMethod = new GetMethod("http://bbs.tianya.cn/list-fans-1.shtml");
		
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				15000); // get请求超时 设置
		getMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		int statusCode = httpClient.executeMethod(getMethod);
		
		String html = getMethod.getResponseBodyAsString();
		
		File file = new File("d:/1.html");
		
		FileUtils.writeStringToFile(file, html);
		
		System.out.println("statusCode:" + statusCode);
		
		//System.out.println("response:" + html);
		System.out.println("===============================");
		System.out.println("===============================");
		
		getMethod.releaseConnection();
		
		Parser parser = new Parser(html);
		
		//NodeFilter filter = new HasAttributeFilter("class", "td-title faceblue");
		
		AndFilter andFilter = new AndFilter (
				new TagNameFilter("a"),
				new HasParentFilter(new HasAttributeFilter("class", "td-title faceblue"))
				
		);   
		
		NodeList nodeList = parser.extractAllNodesThatMatch(andFilter);
		
			int count = 0;
			String str = "";
		  for (NodeIterator i = nodeList.elements (); i.hasMoreNodes(); ) {
			  if(count >= 20){
				  break;
			  }
			  Node node = i.nextNode();
			  
			// 正则表达式校验  
		        Pattern p = Pattern.compile("<a\\s+href\\s*=\\s*\"?(.*?)[\"|>]",  
                Pattern.CASE_INSENSITIVE);  
		        
		        Matcher m = p.matcher(node.toHtml());
		        while (m.find()) {  
		        	String link = m.group(1).trim();
		        	System.out.println(link);
		        	str += link + " - ";
		        	
		        }
		        count ++;
			  /*System.out.println("============toHtml================");
			  System.out.println(node.toHtml());*/
		  }
		  System.out.println("before md5:" + str);
		  System.out.println("after md5:" + DigestUtils.md5Hex(str));
		
		
	}

}
