package com.example.geektrust.module;

public class Journey_Charge_For_Every_Passenger {
	private Integer discount;
	private Integer cost_of_journey;
	
	public Journey_Charge_For_Every_Passenger(Integer discount, Integer cost_of_journey) {
		super();
		this.discount = discount;
		this.cost_of_journey = cost_of_journey;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getCost_of_journey() {
		return cost_of_journey;
	}

	public void setCost_of_journey(Integer cost_of_journey) {
		this.cost_of_journey = cost_of_journey;
	}
	
	
	
	

}
