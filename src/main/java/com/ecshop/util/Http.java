package com.ecshop.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.params.*;

public class Http {
	public static String post(String url, String postContent) {
		String result = "";
		HttpClient httpclient = null;
		try {
			httpclient = new DefaultHttpClient();
			HttpParams params = httpclient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 20000);
			HttpConnectionParams.setSoTimeout(params, 20000);
			HttpPost httppost = new HttpPost(url);
			StringEntity reqEntity = new StringEntity(postContent, "gbk");
			// 设置类型
			reqEntity.setContentType("application/x-www-form-urlencoded");
			// 设置请求的数据
			httppost.setEntity(reqEntity);
			// 执行
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}
		} catch (Exception e) {

		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}

	public static String postByPair(String url,
			List<? extends org.apache.http.NameValuePair> data)
			throws ParseException, IOException {
		org.apache.http.client.HttpClient client = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		httpost.setEntity(new UrlEncodedFormEntity(data, HTTP.UTF_8));
		try {
			HttpResponse response = client.execute(httpost);
			HttpEntity entity = response.getEntity();
			System.out.println("<< Response: " + response.getStatusLine());
			if (entity != null) {
				return EntityUtils.toString(entity);
			}
			return null;
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	public static String get(String url) throws ClientProtocolException,
			IOException {
		org.apache.http.client.HttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		try {
			return client.execute(httpget, new BasicResponseHandler());
		} finally {
			client.getConnectionManager().shutdown();
		}
	}
	
	
	/**
	 * 下载文件到本地目录
	 * @param urlString
	 * @param filename
	 * @param savePath
	 * @throws Exception
	 */
	 public static void download(String urlString, String filename,String savePath) throws Exception {  
	        // 构造URL  
	        URL url = new URL(urlString);  
	        // 打开连接  
	        URLConnection con = url.openConnection();  
	        //设置请求超时为5s  
	        con.setConnectTimeout(15*1000);  
	        // 输入流  
	        InputStream is = con.getInputStream();  
	      
	        // 1K的数据缓冲  
	        byte[] bs = new byte[1024];  
	        // 读取到的数据长度  
	        int len;  
	        // 输出的文件流  
	       File sf=new File(savePath);  
	       if(!sf.exists()){  
	           sf.mkdirs();  
	       }  
	       OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);  
	        // 开始读取  
	        while ((len = is.read(bs)) != -1) {  
	          os.write(bs, 0, len);  
	        }  
	        // 完毕，关闭所有链接  
	        os.close();  
	        is.close();  
	}  
	 
	 /**
	  * 获取http文件流
	  * @param urlString
	  * @param filename
	  * @param savePath
	  * @return
	  * @throws Exception
	  */
	 public static InputStream getInputStream(String urlString) throws Exception {  
	        // 构造URL  
	        URL url = new URL(urlString);  
	        // 打开连接  
	        URLConnection con = url.openConnection();  
	        //设置请求超时为5s  
	        con.setConnectTimeout(5*1000);  
	        // 输入流  
	        return con.getInputStream();  
	      
	 }
}
