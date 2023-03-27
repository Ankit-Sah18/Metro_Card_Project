package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.module.Input;
import com.example.geektrust.module.Passenger;

public interface CardServiceExcution {
	
	public String excuteCommand(List<Input> arg );
	public Passenger balanceInitailize(List<String>token);
	public void processCheckIn(List<String> token);
	public String printSummary();

}
