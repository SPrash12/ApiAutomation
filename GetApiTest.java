package com.app.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.rest.TestBase;
import com.app.restclient.Restclient;
import com.app.util.TestUtil;

public class GetApiTest extends TestBase{

	public static TestBase testBase;
	public static String serviceurl;
	public static String apiurl;
	public static String url;
	public static Restclient restclient;
	public static CloseableHttpResponse closableresponse;
	public static int perpageValue1 =6;
	@BeforeMethod
	public void setup()  {
		testBase= new TestBase();

		serviceurl = props.getProperty("URL");
		apiurl= props.getProperty("serviceURL");

		url= serviceurl+ apiurl;


	}

	@Test(priority = 1)
	public void getApiTestWithoutHeaders() throws ClientProtocolException, IOException {
		restclient= new Restclient();
		closableresponse = restclient.Get(url);

		System.out.println(closableresponse);
		// status code
		int code1= closableresponse.getStatusLine().getStatusCode();
	//	int statuscode = resposne.getStatusLine().getStatusCode();
		System.out.println("status code --->" +code1);//Printing the received status code
	    Assert.assertEquals(code1, Response_Status_Code_200 ,"Status code is not 200");
		
		// http response
		String responseString =EntityUtils.toString(closableresponse.getEntity(),"UTF-8");// converting respose to string
		JSONObject jsonResponse = new JSONObject(responseString); // converting respose to json formt
		System.out.println("json response --> "+ jsonResponse);
	 
		//per page value
      	String per_pageValue=  TestUtil.getValueByJpath(jsonResponse, "/per_page");	
		System.out.println("per page value is  ----> "  +per_pageValue);
      	
		Assert.assertEquals(Integer.parseInt(per_pageValue), perpageValue1);
	 // fetching value from jason arrary
		String last_name =TestUtil.getValueByJpath(jsonResponse, "/data[0]/last_name");
		String id =TestUtil.getValueByJpath(jsonResponse, "/data[0]/id");
		String avatar =TestUtil.getValueByJpath(jsonResponse, "/data[0]/avatar");
		String first_name =TestUtil.getValueByJpath(jsonResponse, "/data[0]/first_name");
		String email =TestUtil.getValueByJpath(jsonResponse, "/data[0]/email");
		
	   	System.out.println("last_name is - "+last_name);
	   	System.out.println("id:" +id);
	   	System.out.println("avatar: "+avatar);
	   	System.out.println("first_name is :"+first_name);
	   	System.out.println("email is -" +email);
	   	// all headers
		Header[] headerArray =closableresponse.getAllHeaders(); // get all header 
		HashMap<String , String> allheaders = new HashMap<String , String>();

		for(Header header: headerArray) {
			allheaders.put(header.getName(), header.getName());
		}
		System.out.println("Header Arraye ---> " +allheaders);
	}
	
	@Test(priority =2)
	public void getApiWithHeaders() throws ClientProtocolException, IOException {
		restclient= new Restclient();
		
		HashMap<String, String> headermap= new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
	
		closableresponse = restclient.Get(url,headermap);

		System.out.println(closableresponse);
		// status code
		int code1= closableresponse.getStatusLine().getStatusCode();
	//	int statuscode = resposne.getStatusLine().getStatusCode();
		System.out.println("status code --->" +code1);//Printing the received status code
	    Assert.assertEquals(code1, Response_Status_Code_200 ,"Status code is not 200");
		
		// http response
		String responseString =EntityUtils.toString(closableresponse.getEntity(),"UTF-8");// converting respose to string
		JSONObject jsonResponse = new JSONObject(responseString); // converting respose to json formt
		System.out.println("json response --> "+ jsonResponse);
	 
		//per page value
      	String per_pageValue=  TestUtil.getValueByJpath(jsonResponse, "/per_page");	
		System.out.println("per page value is  ----> "  +per_pageValue);
      	
		Assert.assertEquals(Integer.parseInt(per_pageValue), perpageValue1);
	 // fetching value from jason arrary
		String last_name =TestUtil.getValueByJpath(jsonResponse, "/data[0]/last_name");
		String id =TestUtil.getValueByJpath(jsonResponse, "/data[0]/id");
		String avatar =TestUtil.getValueByJpath(jsonResponse, "/data[0]/avatar");
		String first_name =TestUtil.getValueByJpath(jsonResponse, "/data[0]/first_name");
		String email =TestUtil.getValueByJpath(jsonResponse, "/data[0]/email");
		
	   	System.out.println("last_name is - "+last_name);
	   	System.out.println("id:" +id);
	   	System.out.println("avatar: "+avatar);
	   	System.out.println("first_name is :"+first_name);
	   	System.out.println("email is -" +email);
	   	// all headers
		Header[] headerArray =closableresponse.getAllHeaders(); // get all header 
		HashMap<String , String> allheaders = new HashMap<String , String>();

		for(Header header: headerArray) {
			allheaders.put(header.getName(), header.getName());
		}
		System.out.println("Header Arraye ---> " +allheaders);
	}
}

