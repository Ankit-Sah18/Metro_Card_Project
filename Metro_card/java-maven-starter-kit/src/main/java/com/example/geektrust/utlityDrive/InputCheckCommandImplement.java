package com.example.geektrust.utlityDrive;

import java.util.List;

import com.example.geektrust.exception.ExceptionHandler;
import com.example.geektrust.module.Input;

public class InputCheckCommandImplement implements InputCheckService {

	@Override
	public void inputCommandCheck(Input input) {
		// TODO Auto-generated method stub
		String command=input.getCommand();
		if(command.equals("BALANCE")) {
			commandBalanceCheck(input.getToken());
		}
		else if(command.equals("CHECK_IN")) {
			commandCheckIn(input.getToken());
		}
		else if(command.equals("PRINT_SUMMARY")) {
			commandPrintSummary(input.getToken());
		}
		else
		{
			 throw new ExceptionHandler("invalid input please check it again");
		}
		
	}
	
	public void commandBalanceCheck(List<String> token) {
		
		if(token.size()!=2) {
			throw new ExceptionHandler(" invalid number of command input");
		}
		
		  Integer balance=Integer.parseInt(token.get(1));
		  if(balance<0)
		  {
			  throw new ExceptionHandler("Metro card balance should not be non negative ..");
		  }
	}
	
	public void commandCheckIn(List<String>token) {
		
		 if(token.size()!=3)
		 {
			 throw new ExceptionHandler("Invalid number of argument..");
		 }
		 
		 String passenger_type=token.get(1);
		 
		 if(!passenger_type.equals("ADULT") && ! passenger_type.equals("SENIOR_CITIZEN") && ! passenger_type.equals("KID"))
		 {
			 throw new ExceptionHandler("Passenger Type is not valid..");
		 }
		 
		 String fromStation= token.get(2);
		 
		 if(!fromStation.equals("AIRPORT")&& ! fromStation.equals("CENTRAL")) {
			 throw new ExceptionHandler("Invalid Station.. only stations available are AIRPORT AND CENTRAL");
		 }
	}
	
	public void commandPrintSummary(List<String> token) {
		
		if(token.size()!=0)
		{
			throw new ExceptionHandler("Invalid number of arugment..");
		}
	}

}
