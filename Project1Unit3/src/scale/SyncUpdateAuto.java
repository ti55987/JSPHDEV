/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 */
package scale;

public interface SyncUpdateAuto 
{
	/**
	 * This method aims for searching the specified model and update the a certain
	 * OptionSet name while synchronize between multiple threads. 
	 * 
	 * @param modelName
	 * @param OptionSetName
	 * @param newName
	 */
	public void syncUpdateOptionSetName(String modelName, String OptionSetName, 
			String newName);
	/**
	 * After searching the specified model, it will update the option price in a 
	 * certain optionSet while synchronize between multiple threads.
	 * 
	 * @param modelName
	 * @param OptionName
	 * @param Option
	 * @param newPrice
	 */
	public void syncUpdateOptionPrice(String modelName, String OptionName, 
			String Option, float newPrice);
}
