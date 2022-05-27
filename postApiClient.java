package com.app.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.data.UsersData;
import com.app.rest.TestBase;
import com.app.restclient.Restclient;

import com.fasterxml.jackson.databind.ObjectMapper;

public class postApiClient  extends TestBase{

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

	@Test
	public void postApiTest() throws  IOException {
		restclient = new Restclient();

		HashMap<String, String> headermap= new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");

		// jackson api 
		ObjectMapper mapper= new ObjectMapper();
		UsersData user= new UsersData("morpheus", "leader");
		// object to json file
		mapper.writeValue(new File("/home/am-pc-41/Am-pc-Backup/eclipse-workspace/restApiAutomatin/src/main/java/com/app/data/users.json"), user);


		//java object to json in String:
		String usersJsonString = mapper.writeValueAsString(user);
		System.out.println(usersJsonString);
	}
}
