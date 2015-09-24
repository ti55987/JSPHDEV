/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * 1.proxyAutomobile class implements all methods in CreatAuto/BuildAuto/FixAuto
 * 2.Use LinkedHashMap to store the model name and its corresponding Automobile object
*/

package adapter;

import java.util.LinkedHashMap;

import exception.AutoException;
import util.Util;
import model.Automobile;

public abstract class proxyAutomobile 
{
	private static LinkedHashMap<String, Automobile> mAutoMap = 
						new LinkedHashMap<String, Automobile>();  
	
	public void BuildAuto(String filename)
	{
		Util util = new Util();
		boolean problemfixed = false;
		Automobile auto = new Automobile();
		do{
			try {
				problemfixed = util.buildAutoObject(filename, auto);
				String modelName = auto.getModel();
				mAutoMap.put(modelName, auto);
			} catch (AutoException e) {
				System.out.println("Catch Exception: " + e.getErrorMsg());
				System.out.println("Reset filename...");
				filename = e.fix(e.getErrorCode());
			}
		}while(problemfixed == false);
	}
	
	public void printAuto(String Modelname)
	{
		Automobile auto = mAutoMap.get(Modelname);
		if(auto != null)
			auto.print();
		else
		{
			System.out.println("printAuto(): Error: Model <" +
					Modelname + ">" + "is not exist");
		}
	}
	
	public void updateOptionSetName(String Modelname, String OptionSetname, 
			String newName)
	{
		Automobile auto = mAutoMap.get(Modelname);
		if(auto != null)
			auto.UpdateOptionSetName(OptionSetname, newName);
		else
		{
			System.out.println("updateOptionSetName(): Error: Model <" +
					Modelname + ">" + "is not exist");
		}
	}
	public void updateOptionPrice(String Modelname, String Optionname, 
			String Option, float newprice)
	{
		Automobile auto = mAutoMap.get(Modelname);
		if(auto != null)
			auto.UpdateOption(Optionname, Option, Option, newprice);
		else
		{
			System.out.println("updateOptionPrice(): Error: Model <" +
					Modelname + ">" + "is not exist");
		}
	}
	
	public void fix(int errno)
	{
		
	}
}
