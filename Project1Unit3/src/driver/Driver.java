/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * This driver aims for test the functionalities of 
 * synchronize the data between different threads and 
 * to check if there is data corruption.
 * 
*/
package driver;

import scale.EditOptions;
import scale.SyncUpdateAuto;
import adapter.BuildAuto;
import adapter.CreateAuto;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Build Ford Wagon ZTW ...");
		CreateAuto auto = new BuildAuto();
		auto.BuildAuto("./testcases/Ford.txt");
		auto.printAuto("Focus Wagon ZTW");
		
		SyncUpdateAuto sync_auto = new BuildAuto();
		EditOptions t1 = new EditOptions("Focus Wagon ZTW",  sync_auto);
		EditOptions t2 = new EditOptions("Focus Wagon ZTW",  sync_auto);
		EditOptions t3 = new EditOptions("Focus Wagon ZTW",  sync_auto);
		
		t1.setUpdateOptionSetName("Color", "t1Color", 1);
		t2.setUpdateOptionSetName("t1Color", "t2Color", 1);
		t3.setUpdateOptionPrice("Transmission", "automatic", 19, 2);
		
		t1.start();
		t2.start();
		t3.start();
		// Using join methods to let the master thread not terminated until 
		// all threads are completed.
		t1.join();
		t2.join();
		t3.join();
		
		
		auto.printAuto("Focus Wagon ZTW");
		
	}

}
