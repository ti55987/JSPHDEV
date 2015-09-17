/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.b;

public class ParkedCar 
{
	public void setMake(String make)
	{
		this.make = make;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setLicenseNumber(double number)
	{
		license_number = number;
	}
	public void setParkedMin(double min)
	{
		parked_minutes = min;
	}
	public String getMake()
	{
		return make;
	}
	public String getModel()
	{
		return model;
	}
	public String getColor()
	{
		return color;
	}
	public double getLicenseNumber()
	{
		return license_number;
	}
	public double getParkedMin()
	{
		return parked_minutes;
	}
	private String make;
	private String model;
	private String color;
	private double license_number;
	private double parked_minutes;
	
}
