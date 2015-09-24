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
	public void BuildAuto(String filename);
	public void printAuto(String Modelname);
}
