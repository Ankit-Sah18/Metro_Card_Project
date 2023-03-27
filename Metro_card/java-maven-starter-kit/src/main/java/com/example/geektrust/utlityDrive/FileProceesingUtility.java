package com.example.geektrust.utlityDrive;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.geektrust.exception.ExceptionHandler;
import com.example.geektrust.module.Input;

public class FileProceesingUtility {

	  private String file_path;
	  
	  public FileProceesingUtility() {
			// TODO Auto-generated constructor stub
		}
	  
	  public FileProceesingUtility( String file_path) {
		// TODO Auto-generated constructor stub
		  this.file_path=file_path;
	}
	  
	  // collecting input command as a list..
	  
	 

	public List<Input> getInputFromFlie() throws ExceptionHandler{
		  
		  try(Stream<String> lines=Files.lines(Paths.get(this.file_path)))
		  {
			  return lines.filter(line -> ! checkEmptyOrComment(line)).map(line -> parseInput(line)).collect(Collectors.toList());
		  }
		  catch (Exception e) {
			
			  throw new ExceptionHandler("some error occured..");
		}
		  
		 
		  
	  }
	  
	  public boolean checkEmptyOrComment(String line) {
		  
		  return   line.trim().isEmpty()|| line.trim().startsWith("#");
	  }
	  
	  public Input parseInput(String str) {
		  
		  try {
			  
			    String[] commandWithArg=str.split(" ");
			    List<String> token= Arrays.stream(commandWithArg).skip(1).collect(Collectors.toList());
			    Input input=new Input(commandWithArg[0], token);
			    return input;
		  }
		  catch (Exception e) {
			 throw new UnsupportedOperationException("Invalid command comming "+ str);
		}
	  }
	  
}
