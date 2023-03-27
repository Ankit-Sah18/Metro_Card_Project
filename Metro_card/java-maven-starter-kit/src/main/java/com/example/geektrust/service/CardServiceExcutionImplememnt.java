package com.example.geektrust.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.geektrust.exception.ExceptionHandler;
import com.example.geektrust.module.Input;
import com.example.geektrust.module.Journey_Charge_For_Every_Passenger;
import com.example.geektrust.module.Passenger;
import com.example.geektrust.module.PassengerCheckIn;
import com.example.geektrust.module.PassengerDetails;
import com.example.geektrust.module.StatisticsStation;
import com.example.geektrust.utlityDrive.InputCheckCommandImplement;

public class CardServiceExcutionImplememnt implements CardServiceExcution {

	// passenger Details
	  private PassengerDetails passengerDetails= new PassengerDetails();
	  
	  // Executing set of command from input file...
	@Override
	public String excuteCommand(List<Input> arg) {
		
		 String output="";
		 
		 for(Input input :arg) {
			 
			 InputCheckCommandImplement inputImplement=new InputCheckCommandImplement();
			 inputImplement.inputCommandCheck(input);
			 if(input.getCommand().equals("BALANCE"))
			 {
				 balanceInitailize(input.getToken());
			 }
			 else if(input.getCommand().equals("CHECK_IN"))
			 {
				 processCheckIn(input.getToken());
			 }
			 else if(input.getClass().equals("PRINT_SUMMARY"))
			 {
				 output=printSummary();
				 System.out.println(output);
			 }
			 else
			 {
				 throw new ExceptionHandler("invalid input..");
			 }
			 
		 }
		
		return output;
	}

	//Initializes user and user's balance
	//adds user to metro card
	@Override
	public Passenger balanceInitailize(List<String> token) {
		// TODO Auto-generated method stub
		String id= token.get(0);
		Integer bal= Integer.parseInt(token.get(1));
		Passenger passenger =new Passenger(id, bal);
		passengerDetails.getPassengerMap().put(id, passenger);
		
		return passenger;
	}

	//Called when invoked Passenger_check_in command
		//Adds checkIn journey to journey List
	@Override
	public void processCheckIn(List<String> token) {
		// TODO Auto-generated method stub
		PassengerCheckIn passengerCheckIn = initiallizeCheckList(token);
	  Journey_Charge_For_Every_Passenger journey_Charge=updateBalance(passengerCheckIn.getMetro_card_number(), passengerCheckIn.getFare());
	  passengerCheckIn.setJourneyFare(journey_Charge);
	  if(passengerCheckIn.getFrom_station().equals("AIRPORT") && passengerDetails.getOrder_type_airport().contains(passengerCheckIn.getPassenger_type()) )
	  {
		  passengerDetails.getOrder_type_airport().add(passengerCheckIn.getPassenger_type());
	  }
	  if(passengerCheckIn.getFrom_station().equals("CENTRAL") && passengerDetails.getOrder_type_central().contains(passengerCheckIn.getPassenger_type())) {
		  
		   passengerDetails.getOrder_type_central().add(passengerCheckIn.getPassenger_type());
	  }
	  passengerDetails.getPassengerCheckIns().add(passengerCheckIn);
		
	}
	
	// Called when print summary invoked..
	@Override
	public String printSummary() {
		
		String output=calculateTotalStatstics(passengerDetails.getPassengerCheckIns());
		return output;
		
	}
	
	
	// Calculating Station statstics and set output in accepted format...
	public String calculateTotalStatstics(List<PassengerCheckIn> passCheckIn)
	{
		Map<String, List<PassengerCheckIn>> passAtAirport=passCheckIn.stream().filter(c-> c.getFrom_station().equals("AIRPORT")).collect(Collectors.groupingBy(c->c.getPassenger_type()));
		List<StatisticsStation> airportStatstics=calculateEachStationStatstics("AIRPORT",passAtAirport);
		String airportDetails= createDetails("AIRPORT",airportStatstics);
		
		Map<String, List<PassengerCheckIn>> passAtCentral=passCheckIn.stream().filter(c-> c.getFrom_station().equals("CENTRAL")).collect(Collectors.groupingBy(c->c.getPassenger_type()));
		List<StatisticsStation> centralStatstics=calculateEachStationStatstics("CENTRAL",passAtCentral);
		String centralDetails= createDetails("CENTRAL",centralStatstics);
		
		//Output Details..
				String output="";
				output+="TOTAL_COLLECTION CENTRAL "+passengerDetails.getTotal_amount_of_centeral()+" "+passengerDetails.getTotal_discount_amount_of_centeral()+"\n";
				output+="PASSENGER_TYPE_SUMMARY\n";
				output+=centralDetails;
				output+="TOTAL_COLLECTION AIRPORT "+passengerDetails.getTotal_amount_of_airport()+" "+passengerDetails.getTotal_discount_amount_of_airport()+"\n";
				output+="PASSENGER_TYPE_SUMMARY\n";
				output+=airportDetails;
				
				return output;
	}
	
	//Returning output of statistics as a list..
	public String createDetails(String station, List<StatisticsStation> statisticsStations ) {
		
		String output="";
		int totalCharge=0, totalDiscount=0;
		for(StatisticsStation stats : statisticsStations) {
			totalCharge+=stats.getTotal_charge();
			totalDiscount+=stats.getTotal_discount();
			output+=stats.getPassenegr_type()+" "+stats.getCount()+"\n";
		}
		
		if(station.equals("AIRPORT"))
		{
			passengerDetails.setTotal_amount_of_airport(totalCharge);
			passengerDetails.setTotal_discount_amount_of_airport(totalDiscount);
		}
		else if(station.equals("CENTRAL"))
		{
			passengerDetails.setTotal_amount_of_centeral(totalCharge);
			passengerDetails.setTotal_discount_amount_of_centeral(totalDiscount);
		}
		
		return output;
	}
	
	public List<StatisticsStation> calculateEachStationStatstics(String fromStation, Map<String, List<PassengerCheckIn>> passAtStation){
		
		List<StatisticsStation>statisticsStationsList= new ArrayList<>();
	    
		 for(Map.Entry<String, List<PassengerCheckIn>> c :passAtStation.entrySet()) {
			 
			 StatisticsStation statistics = new StatisticsStation(c.getKey());
			 
			 if(fromStation.equals("AIRPORT"))
				{
					statistics.setOrder_by_type(passengerDetails.getOrder_type_airport().indexOf(c.getKey()));
				}
			 if(fromStation.equals("CENTRAL"))
				{
					statistics.setOrder_by_type(passengerDetails.getOrder_type_central().indexOf(c.getKey()));
				}
			 for(PassengerCheckIn passengerCheckIn :c.getValue())
			 {
				 statistics.setCount(statistics.getCount()+1);
				 statistics.setTotal_charge(statistics.getTotal_charge()+passengerCheckIn.getJourneyFare().getCost_of_journey());
				 statistics.setTotal_discount(statistics.getTotal_discount()+passengerCheckIn.getJourneyFare().getDiscount());
			 }
			 statisticsStationsList.add(statistics);
		 }
		 
		 statisticsStationsList= sortOnHighestAmount(statisticsStationsList);
		 return statisticsStationsList;
	}
	
	public List<StatisticsStation>sortOnHighestAmount(List<StatisticsStation> statisticsStations){
		
		
		Comparator<StatisticsStation>compareByAmount=(StatisticsStation s1, StatisticsStation s2)-> s2.getTotal_charge().compareTo(s1.getTotal_charge());
		Comparator<StatisticsStation> compareByType=(StatisticsStation s1,StatisticsStation s2  )-> s2.getOrder_by_type().compareTo(s1.getOrder_by_type());
		Collections.sort(statisticsStations,compareByAmount.thenComparing(compareByType));
		return statisticsStations;
	}

	public PassengerCheckIn initiallizeCheckList(List<String> token) {
		// TODO Auto-generated method stub
		String id= token.get(0);
		String type= token.get(1);
		String station= token.get(2);
		PassengerCheckIn passCheckIn= new PassengerCheckIn(id, type, station);
		
		return passCheckIn;
	}

	// calculating  total amount to be paid and discount..
	//updating user balance accordingly to required balance..
	public Journey_Charge_For_Every_Passenger updateBalance(String id, int charge) {
		
		 int totalAmount=0;
		 int totalDiscount=0;
		 Passenger passenger= passengerDetails.getPassengerMap().get(id);
		 if(passenger==null)
		 {
			 throw new ExceptionHandler("Metro card users are not registered..");
		 }
		 passenger.setJourney_count(passenger.getJourney_count()+1);
		 
		//  calculating 50% discount calculated on return journey,
		 if(passenger.getJourney_count()%2==0)
		 {
			 charge =charge/2;
			 totalDiscount =charge;
		 }
		 
		// Checking insufficient balance, calculating service fee and balance required
			// Add sufficient balance, deduct Money from metro card
		 if(passenger.getBalance_in_the_metro_card()<charge)
		 {
			 int requiredBalance= charge-passenger.getBalance_in_the_metro_card();
			 totalAmount +=0.2* requiredBalance;
			 passenger.setBalance_in_the_metro_card(0);
		 }else
		 {
			 passenger.setBalance_in_the_metro_card(passenger.getBalance_in_the_metro_card()-charge);
		 }
		 totalAmount+=charge;
		 
		 // Storing  discount amount  and paid  amount during this journey..
		 Journey_Charge_For_Every_Passenger joEvery_Passenger= new Journey_Charge_For_Every_Passenger(totalDiscount, totalAmount);
		 
		 return joEvery_Passenger;
		 
	}
	

}
