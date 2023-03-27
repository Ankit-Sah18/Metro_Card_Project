package com.example.geektrust.module;

public class Passenger {
	
	private String metro_card_number;
	private Integer balance_in_the_metro_card;
	private Integer journey_count;
	
	 public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String metro_card_number, Integer balance_in_the_metro_card) {
		super();
		this.metro_card_number = metro_card_number;
		this.balance_in_the_metro_card = balance_in_the_metro_card;
		journey_count=0;
	}

	public String getMetro_card_number() {
		return metro_card_number;
	}

	public void setMetro_card_number(String metro_card_number) {
		this.metro_card_number = metro_card_number;
	}

	public Integer getBalance_in_the_metro_card() {
		return balance_in_the_metro_card;
	}

	public void setBalance_in_the_metro_card(Integer balance_in_the_metro_card) {
		this.balance_in_the_metro_card = balance_in_the_metro_card;
	}

	public Integer getJourney_count() {
		return journey_count;
	}

	public void setJourney_count(Integer journey_count) {
		this.journey_count = journey_count;
	}
	
	
	

}
