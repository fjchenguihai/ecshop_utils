package com.ecshop.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url) {
    	String result="";
    	System.out.println(url);
    	HttpGet httpRequst = new HttpGet(url);  
        HttpResponse httpResponse;
		try {
			httpResponse = new DefaultHttpClient().execute(httpRequst);
			if(httpResponse.getStatusLine().getStatusCode() == 200)  
	        {  
	            HttpEntity httpEntity = httpResponse.getEntity(); 
	            result = EntityUtils.toString(httpEntity, "UTF-8");
	        } 
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = e.getMessage().toString();  
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage().toString();  
		}
        return result; 
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
    	HttpPost httpPost = new HttpPost(url);
		StringEntity postEntity = new StringEntity(param, "UTF-8");
        httpPost.setEntity(postEntity);
        
        HttpResponse response2;
        String result="";
		try {
			response2 = new DefaultHttpClient().execute(httpPost);
			HttpEntity entity = response2.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");	
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    } 
    
    
    public static String sendPostXml(String url, String param) {
    	HttpPost httpPost = new HttpPost(url);
		StringEntity postEntity = new StringEntity(param, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
        
        HttpResponse response2;
        String result="";
		try {
			response2 = new DefaultHttpClient().execute(httpPost);
			HttpEntity entity = response2.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");	
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }    
}