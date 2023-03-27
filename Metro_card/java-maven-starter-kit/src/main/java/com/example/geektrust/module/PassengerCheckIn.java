package com.example.geektrust.module;

import com.example.geektrust.constant.FareConstant;

public class PassengerCheckIn {
	private String metro_card_number;
	private String passenger_type;
	private String from_station;
	private Integer  fare;
	private Journey_Charge_For_Every_Passenger  journeyFare;
	
	public PassengerCheckIn() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getMetro_card_number() {
		return metro_card_number;
	}



	public void setMetro_card_number(String metro_card_number) {
		this.metro_card_number = metro_card_number;
	}



	public String getPassenger_type() {
		return passenger_type;
	}



	public void setPassenger_type(String passenger_type) {
		this.passenger_type = passenger_type;
	}



	public String getFrom_station() {
		return from_station;
	}



	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}



	public Integer getFare() {
		return fare;
	}



	public void setFare(String passenger_type) {
		if(passenger_type.equals("ADULT")) {
			this.fare=FareConstant.Adult_Fare;
		}
		else if(passenger_type.equals("SENIOR_CITIZEN")) {
			 this.fare=FareConstant.Senior_Citizen_Fare;
		}
		else if(passenger_type.equals("KID"))
		{
			this.fare=FareConstant.Kid_Fare;
		}
	}



	public Journey_Charge_For_Every_Passenger getJourneyFare() {
		return journeyFare;
	}



	public void setJourneyFare(Journey_Charge_For_Every_Passenger journeyFare) {
		this.journeyFare = journeyFare;
	}



	public PassengerCheckIn(String metro_card_number, String passenger_type, String from_station) {
		super();
		this.metro_card_number = metro_card_number;
		this.passenger_type = passenger_type;
		this.from_station = from_station;
		setFare(this.passenger_type);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		  if(this==obj) {
			  return true;
		  }
		  if(obj==null || this.getClass()!= obj.getClass())
		  {
			  return false;
		  }
		  
		  PassengerCheckIn passengerCheckIn= (PassengerCheckIn) obj;
			  
		return this.passenger_type.equals(passengerCheckIn.passenger_type)
		&& this.from_station.equals(passengerCheckIn.from_station)
		&& this.metro_card_number.equals(passengerCheckIn.metro_card_number)
		&& this.fare.equals(passengerCheckIn.fare);
		
	}
	
	

}
