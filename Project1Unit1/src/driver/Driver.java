/*
 * Andrew ID: tpan
 * Name: Ti-Fen Pan
 * 
 * A test class to check the correctness of all functionalities
*/
package driver;

import model.Automotive;
import util.Util;

public class Driver {

	public static void main(String[] args) {
		
		Util util = new Util();
		Automotive FordZTW = util.buildAutoObject("input.txt");
		FordZTW.print();
		util.serializeAuto(FordZTW, "auto1.ser");
		Automotive newFordZTW = util.deserializeAuto("auto1.ser");
		System.out.println("-------------------");
		System.out.println("Deserialize object Ford:");
		newFordZTW.print();
		
		Automotive Toyota = util.buildAutoObject("input2.txt");
		Toyota.print();
		util.serializeAuto(Toyota,"auto2.ser");
		Automotive newToyota = util.deserializeAuto("auto2.ser");
		System.out.println("-------------------");
		System.out.println("Deserialize object Toyota:");
		newToyota.print();
		
		System.out.println("-------------------");
		System.out.println("Delete Option : ABS");
		if(!newFordZTW.DeleteOption("Brakes/Traction Control", "ABS"))
			System.out.println("Delete Failed");
		else
			newFordZTW.printOptionSet(2);
		
		System.out.println("-------------------");
		System.out.println("Update Option:Fort Knox Gold Clearcoat Metallic");
		if(!newFordZTW.UpdateOption("Color", 
				"Fort Knox Gold Clearcoat Metallic", "Gold", 0))
			System.out.println("Update Failed");
		else 
			newFordZTW.printOptionSet(0);

		System.out.println("-------------------");
		System.out.println("Update Option Color");
		String[] newopt = {"Yellow", "Dark"};
		float[] val = {0,0};
		if(!newFordZTW.UpdateOptionSet("Color", "Color", newopt, val))
			System.out.println("Update Failed");
		else 
			newFordZTW.printOptionSet(0);
		
		System.out.println("-------------------");
		System.out.println("Delete Option : Color");
		if(!newFordZTW.DeleteOptionSet("Color"))
			System.out.println("Delete Failed");
		else
			newFordZTW.print();
	}

}
