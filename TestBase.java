package com.app.rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public int Response_Status_Code_200= 200;
	public int Response_Status_Code_201= 201;
	public int Response_Status_Code_400=400;
	public int Response_Status_Code_401=401;
	public int Response_Status_Code_500=500;
	public int Response_Status_Code_403=403;
	public static Properties	props ;
	
		public TestBase() {
		try {

			props	= new Properties();
			FileInputStream ip = new FileInputStream("/home/am-pc-41/Am-pc-Backup/eclipse-workspace/restApiAutomatin/src"
					+ "/main/java/com/app/config/config.properties");
			props.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException io) {
			// TODO: handle exception
			io.printStackTrace();
		}
	}
}
