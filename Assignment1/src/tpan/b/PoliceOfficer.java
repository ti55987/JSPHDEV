/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.b;

public class PoliceOfficer {
	
	public PoliceOfficer(String name, double num)
	{
		this.name = name;
		badge_number = num;
	}
	
	public void Examine(ParkedCar car, ParkingMeter meter)
	{
		double diff = car.getParkedMin() -  meter.getPurchasedTime();
		
		if(diff > 0)
		{
			ParkingTicket ticket = new ParkingTicket();
			double basefine = 25;
			double fine = basefine;
			
			diff -= 60;
			while(diff > 0)
			{
				basefine += 10;
				fine += basefine;
				diff -= 60;
			}
			
			ticket.ReportCar(car);
			ticket.ReportFine(fine);
			ticket.ReportPoliceOfficer(this);
		}
		
		System.out.println("Check Finished");
		System.out.println("---------------------------------");
			
	}
	
	public void setBadgeNumber(double num)
	{
		badge_number = num;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getBadgeNumber()
	{
		return badge_number;
	}
	public String getName()
	{
		return name;
	}
	
	
	private double badge_number;
	private String name;
	

}
