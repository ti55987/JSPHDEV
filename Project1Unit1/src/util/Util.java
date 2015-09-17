/*
 * Andrew ID: tpan
 * Name: Ti-Fen Pan
 * 
 * In Util class, it provides Serialize FileIO methods
 * and build automotive object from input files. 
*/
package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import model.Automotive;



public class Util {


	/**
	 * Serialize the Automotive object and write an object in memory to disk.
	 * @param auto
	 * @param filename
	 */
	public void serializeAuto(Automotive auto, String filename)
	{
		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream(filename));
			
			os.writeObject(auto);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deserialize the object, and store it into memory.  
	 * @param filename
	 * @return
	 */
	public Automotive deserializeAuto(String filename)
	{
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(filename));
			
			return (Automotive) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Read a text file and build Automotive object
	 * @param filename
	 * @return
	 */
	public Automotive buildAutoObject(String filename) 
	{
		Automotive auto = null;
		
		try{
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			String line = buff.readLine();
						
			StringTokenizer st = new StringTokenizer(line);
			String name = st.nextToken(",");
			float base = Float.parseFloat(st.nextToken(","));
			int set_sz = Integer.parseInt(st.nextToken(","));
			int i = 0;
			auto = new Automotive(name, base, set_sz);
			
			loadOptionSet(buff, auto, set_sz);
			
			while (i < set_sz)
			{
				line = buff.readLine();
				int sz = Integer.parseInt(line);
				loadOption(buff, auto, sz, i);
				i++;
			}
			buff.close();
		}
		catch(IOException e)
		{
			System.out.println("Error --" + e.toString());
		}
		
		return auto;

	}
	
	/**
	 * 
	 * Help to set the options into an Automotive object
	 * @param buff
	 * @param auto
	 * @param sz
	 * @param idx
	 */
	public void loadOption(BufferedReader buff, Automotive auto, int sz, int idx)
	{
		try {			
			String[] name = new String[sz];
			float[] price = new float[sz];
			int i = 0;
			
			while(i < sz)
			{
				String line = buff.readLine();
				StringTokenizer st = new StringTokenizer(line);
				name[i] = st.nextToken(",");
				price[i] = Float.parseFloat(st.nextToken(","));
				i++;
			}
			auto.setOption(idx, name, price);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Help set the option set into an Automotive object
	 * @param buff
	 * @param auto
	 * @param sz
	 */
	public void loadOptionSet(BufferedReader buff, Automotive auto, int sz)
	{
		try {
			String set_name[] = new String[sz];
			int[] opt_sz = new int[sz];
			int i = 0;
			
			while(i < sz)
			{
				String line = buff.readLine();
				StringTokenizer st = new StringTokenizer(line);
				set_name[i] = st.nextToken(",");
				opt_sz[i] = Integer.parseInt(st.nextToken(","));
				i++;
			}
			auto.setOptionSet(set_name, opt_sz);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
