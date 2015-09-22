/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * This class aims for test the functionalities of 
 * adding choice/print the choice sets and the total price
 * 
*/
package driver;

import exception.AutoException;
import model.Automobile;
import util.Util;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Util util = new Util();
		boolean problemfixed = false;
		Automobile auto = new Automobile();
		String filename = "./testcases/Ford.txt";
		do{
			try {
				problemfixed = util.buildAutoObject(filename, auto);
				auto.print();
			} catch (AutoException e) {
				System.out.println("Catch Exception: " + e.getErrorMsg());
				System.out.println("Reset filename...");
				filename = e.fix(e.getErrorCode());
			}
		}while(problemfixed == false); 
		
		auto.setOptionChoice("Color", "Twilight Blue");
		auto.setOptionChoice("Color", "Non this color"); // should not take efftect
		auto.setOptionChoice("Brakes/Traction Control", "ABS"); // +400
		auto.setOptionChoice("Transmission", "manual"); // -815
		auto.setOptionChoice("Side Impact Air Bags", "none"); // -815
		auto.setOptionChoice("Power Moonroof", "selected"); // -815
		auto.printChoice();
	}

}
