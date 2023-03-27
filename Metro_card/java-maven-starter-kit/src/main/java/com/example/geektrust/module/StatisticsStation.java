package com.example.geektrust.module;

public class StatisticsStation {
	
	private Integer count;
	private String passenegr_type;
	private Integer total_charge;
	private Integer total_discount;
	private Integer order_by_type;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getPassenegr_type() {
		return passenegr_type;
	}
	public void setPassenegr_type(String passenegr_type) {
		this.passenegr_type = passenegr_type;
	}
	public Integer getTotal_charge() {
		return total_charge;
	}
	public void setTotal_charge(Integer total_charge) {
		this.total_charge = total_charge;
	}
	public Integer getTotal_discount() {
		return total_discount;
	}
	public void setTotal_discount(Integer total_discount) {
		this.total_discount = total_discount;
	}
	public Integer getOrder_by_type() {
		return order_by_type;
	}
	public void setOrder_by_type(Integer order_by_type) {
		this.order_by_type = order_by_type;
	}
	public StatisticsStation(String passenegr_type) {
		super();
		this.passenegr_type = passenegr_type;
		this.count=0;
		this.total_charge=0;
		this.total_discount=0;
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
		
		  StatisticsStation statisticsStation = (StatisticsStation) obj;
		  return this.count.equals(statisticsStation.count)
				  && this.passenegr_type.equals(statisticsStation.passenegr_type)
				  && this.total_charge.equals(statisticsStation.total_charge)
				  && this.total_discount.equals(statisticsStation.total_discount);
		
	}
	
	
	
	

}
