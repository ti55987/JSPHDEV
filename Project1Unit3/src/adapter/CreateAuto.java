/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * An interaface for build and print the automobile object
 * 
*/
package adapter;

public interface CreateAuto 
{
	/**
	 * Parse the data in the specified file and build an Automobile object
	 * @param filename
	 */
	public void BuildAuto(String filename);
	/**
	 * Print the optionSet, Option, price, model name and its base price
	 * @param Modelname
	 */
	public void printAuto(String Modelname);
}
