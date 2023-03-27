package com.example.geektrust.module;

import java.util.List;

public class Input {
	private String command;
	private List<String> token;
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public List<String> getToken() {
		return token;
	}
	public void setToken(List<String> token) {
		this.token = token;
	}
	public Input(String command, List<String> token) {
		super();
		this.command = command;
		this.token = token;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj==null || this.getClass()!=obj.getClass())
		{
			return false;
		}
		
		Input input= (Input) obj;
		return this.command.equals(input.command)
				&& this.token.equals(input.token);
		
	}

}
