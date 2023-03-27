package com.example.geektrust.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import com.example.geektrust.module.Input;
import com.example.geektrust.utlityDrive.FileProceesingUtility;

public class FileProssesingUtilityTest {
	
	private FileProceesingUtility utility;
	
	
	@BeforeEach
	void setUp() {
		
		 utility= new FileProceesingUtility();
	}
	
	public void parseInteger()
	{
		  List<String> token= new ArrayList<>();
		  token.add("MC1");
		  Integer balance= 100;
		  token.add(balance.toString());
		  Input exceptedInput= new Input("BALANCE", token);
		  Input actualInput= utility.parseInput("BALANCE, MC1, 100");
		  assertEquals(exceptedInput, actualInput);
		  
	}

}
