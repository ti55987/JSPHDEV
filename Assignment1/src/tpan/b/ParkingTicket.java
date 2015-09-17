/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.b;

public class ParkingTicket 
{
	public void ReportCar(ParkedCar car)
	{
		System.out.println("Illegally Parked Car:");
		System.out.println("  Make:" + car.getMake());
		System.out.println("  Model:" + car.getModel());
		System.out.println("  Color:" + car.getColor());
		System.out.println("  License Number:" + car.getLicenseNumber());	
	}
	
	public void ReportFine(double fine)
	{
		System.out.println("Fine:");
		System.out.println("  $" + fine);
	}

	public void ReportPoliceOfficer(PoliceOfficer officer)
	{
		System.out.println("Issued by Officer:");
		System.out.println("  Name:" + officer.getName());
		System.out.println("  Badge Number:" + officer.getBadgeNumber());

	}
	
}
