/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * An interface for update the option set name and option price
 * 
*/
package adapter;

public interface UpdateAuto 
{
	/**
	 * This method aims for searching the specified model and update the a certain
	 * OptionSet name
	 * @param Modelname
	 * @param OptionSetname
	 * @param newName
	 */
	public void updateOptionSetName(String Modelname, String OptionSetname, 
									String newName);
	/**
	 * After searching the specified model, it will update the option price in a 
	 * certain optionSet
	 * @param Modelname
	 * @param Optionname
	 * @param Option
	 * @param newprice
	 */
	public void updateOptionPrice(String Modelname, String Optionname, 
									String Option, float newprice);
	
}
