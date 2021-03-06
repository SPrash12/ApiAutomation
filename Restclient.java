package com.app.restclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Restclient {
   public static CloseableHttpResponse resposne;
	// Get Request without headers
	public static CloseableHttpResponse Get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient=	HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);   //http get request

		// http response
	     resposne=httpClient.execute(httpget); // hit the get url
        System.out.println("getting http resonse ---->"+resposne);
		return resposne;
}
	// Get request with headers
	public static CloseableHttpResponse Get(String url, HashMap<String, String> headermap) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient=	HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);   //http get request
// for headrs
		for(Map.Entry<String, String> entry: headermap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		// http response
	     resposne=httpClient.execute(httpget); // hit the get url
        System.out.println("getting http resonse ---->"+resposne);
		return resposne;
}
	//Post Request
	
	public CloseableHttpResponse Post(String url, String entityString, HashMap<String, String> headermap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient=	HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);  // post method
		httppost.setEntity(new StringEntity(entityString));  // for payload
		// for headers
		for(Map.Entry<String, String> entry: headermap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		resposne= httpClient.execute(httppost);
		return resposne;
	}
}