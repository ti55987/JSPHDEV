/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * This class aims for test the functionalities of
 * 1. buildAuto
 * 2. printAuto
 * 3. updateAuto
 * 4. build two different models
 * 5. Exception handlers:
 * 		a. missing file name
 * 		b. missing option set
 * 		c. missing option 
 *      d. missing price
 * 		e. having negative base price 
*/
package driver;

import adapter.*;

public class ProxyDriver 
{
	public static void main(String[] args) {
	
		CreateAuto auto = new BuildAuto();
		auto.BuildAuto("./testcases/Ford.txt");
		auto.BuildAuto("./testcases/Toyota.txt");
		auto.printAuto("Focus Wagon ZTW");
		auto.printAuto("2016 Camry");
		
		System.out.println("Update Focus Wagon ZTW " +
							"Color Optionset Name to Appearance");
		UpdateAuto auto2 = new BuildAuto();
		auto2.updateOptionSetName("Focus Wagon ZTW", "Color", "Appearance");
		auto.printAuto("Focus Wagon ZTW");

		System.out.println("Update 2016 Camry Transmission " +
							"Option Price from 500 to 200");
		auto2.updateOptionPrice("2016 Camry", "Transmission", 
										"automatic", 200);
		auto.printAuto("2016 Camry");
	
		auto.BuildAuto("./testcases/MissingFile.txt");
		auto.BuildAuto("./testcases/Negative_BasePrice.txt");
		auto.BuildAuto("./testcases/MissingOption.txt");
		auto.BuildAuto("./testcases/MissingPrice.txt");
		auto.BuildAuto("./testcases/MissingOptionSet.txt");
	}
}
