package com.example.geektrust.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PassengerDetails {
     
	  private HashMap<String, Passenger> passengerMap;
	  private List<PassengerCheckIn> passengerCheckIns;
	  private Integer total_amount_of_airport;
	  private Integer total_amount_of_centeral;
	  private Integer  total_discount_amount_of_airport;
	  private Integer total_discount_amount_of_centeral;
	  private List<String> order_type_airport;
	  private List<String> order_type_central;
	  
	  public PassengerDetails() {
		// TODO Auto-generated constructor stub
		  this.passengerMap=new HashMap<>();
		  this.passengerCheckIns=new ArrayList<>();
		  this.total_discount_amount_of_airport=0;
		  this.total_amount_of_centeral=0;
		  this.order_type_airport=new ArrayList<>();
		  this.order_type_central=new ArrayList<>();
		  
		  
	}

	public HashMap<String, Passenger> getPassengerMap() {
		return passengerMap;
	}

	public void setPassengerMap(HashMap<String, Passenger> passengerMap) {
		this.passengerMap = passengerMap;
	}

	public List<PassengerCheckIn> getPassengerCheckIns() {
		return passengerCheckIns;
	}

	public void setPassengerCheckIns(List<PassengerCheckIn> passengerCheckIns) {
		this.passengerCheckIns = passengerCheckIns;
	}

	public Integer getTotal_amount_of_airport() {
		return total_amount_of_airport;
	}

	public void setTotal_amount_of_airport(Integer total_amount_of_airport) {
		this.total_amount_of_airport = total_amount_of_airport;
	}

	public Integer getTotal_amount_of_centeral() {
		return total_amount_of_centeral;
	}

	public void setTotal_amount_of_centeral(Integer total_amount_of_centeral) {
		this.total_amount_of_centeral = total_amount_of_centeral;
	}

	public Integer getTotal_discount_amount_of_airport() {
		return total_discount_amount_of_airport;
	}

	public void setTotal_discount_amount_of_airport(Integer total_discount_amount_of_airport) {
		this.total_discount_amount_of_airport = total_discount_amount_of_airport;
	}

	public Integer getTotal_discount_amount_of_centeral() {
		return total_discount_amount_of_centeral;
	}

	public void setTotal_discount_amount_of_centeral(Integer total_discount_amount_of_centeral) {
		this.total_discount_amount_of_centeral = total_discount_amount_of_centeral;
	}

	public List<String> getOrder_type_airport() {
		return order_type_airport;
	}

	public void setOrder_type_airport(List<String> order_type_airport) {
		this.order_type_airport = order_type_airport;
	}

	public List<String> getOrder_type_central() {
		return order_type_central;
	}

	public void setOrder_type_central(List<String> order_type_central) {
		this.order_type_central = order_type_central;
	}
}
