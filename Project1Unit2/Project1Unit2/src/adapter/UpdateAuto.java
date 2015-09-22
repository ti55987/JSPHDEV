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
	public void updateOptionSetName(String Modelname, String OptionSetname, 
									String newName);
	public void updateOptionPrice(String Modelname, String Optionname, 
									String Option, float newprice);
	
}
