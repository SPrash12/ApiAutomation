package com.app.data;

public class UsersData {

	String name;
	String job;

	
	// default constructor
	public UsersData() {

	}
	// parameterised constructor
	public UsersData(String name, String job) {
        this.name= name;
        this.job= job;
		// getters and setters method	   
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
