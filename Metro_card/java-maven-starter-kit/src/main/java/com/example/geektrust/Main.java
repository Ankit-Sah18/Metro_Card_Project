package com.example.geektrust;

import java.util.List;

import com.example.geektrust.exception.ExceptionHandler;
import com.example.geektrust.module.Input;
import com.example.geektrust.service.CardServiceExcution;
import com.example.geektrust.service.CardServiceExcutionImplememnt;
import com.example.geektrust.utlityDrive.FileProceesingUtility;

public class Main {
    public static void main(String[] args) {
        /*
        Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
             * 
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
        */
    	
    	try {
    		
    		if(args.length != 1)
    		{
    			throw new ExceptionHandler("Input file not supplied , please supply input file..");
    		}
    		String file= args[0];
    		processMetroCardExcution(file);
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e.getMessage());
		}
    	
    }
    
    public static String  processMetroCardExcution(String file) {
		
		FileProceesingUtility reader=new FileProceesingUtility(file);
		List<Input> input= reader.getInputFromFlie();
		CardServiceExcution cardService= new CardServiceExcutionImplememnt();
		String output= cardService.excuteCommand(input);
		return output;
	}
}
