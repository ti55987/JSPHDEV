/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.b;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PoliceOfficer officer = new PoliceOfficer("Bob", 1234);
		ParkedCar car = new ParkedCar();
		ParkingMeter meter = new ParkingMeter();
		
		car.setColor("Blue");
		car.setMake("TOYOTA");
		car.setModel("RAV4");
		car.setLicenseNumber(12345);
		car.setParkedMin(120);
		
		// within the parking time purchased
		System.out.println("Within the parking purchased");
		meter.setPurchasedTime(130);
		officer.Examine(car, meter);
		// out of the parking purchased
		System.out.println("Out of the parking purchased");
		meter.setPurchasedTime(10);
		officer.Examine(car, meter);		
		// just in the parking purchased
		System.out.println("Just in the parking purchased");
		meter.setPurchasedTime(120);
		officer.Examine(car, meter);

		// more than one hour
		System.out.println("More than one hour");
		meter.setPurchasedTime(20);
		officer.Examine(car, meter);
		// less than one hour
		System.out.println("Less than one hour");
		meter.setPurchasedTime(110);
		officer.Examine(car, meter);
	}

}
