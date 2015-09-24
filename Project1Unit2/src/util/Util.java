/*
 * Andrew ID: tpan
 * Author: Ti-Fen Pan
 * 
 * In Util class, it provides Serialize FileIO methods
 * and build automobile object from input files. 
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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import exception.AutoException;
import exception.EnumAutoErrorCode;

import model.Automobile;



public class Util {


	/**
	 * Serialize the Automobile object and write an object in memory to disk.
	 * @param auto
	 * @param filename
	 */
	public void serializeAuto(Automobile auto, String filename)
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
	public Automobile deserializeAuto(String filename)
	{
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(filename));
			
			return (Automobile) in.readObject();
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
	 * Read a text file and build Automobile object
	 * @param filename
	 * @return
	 * @throws AutoException 
	 */
	public boolean buildAutoObject(String filename, 
			Automobile auto) throws AutoException 
	{
		boolean flag = false;
		
		try{
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			String line = buff.readLine();
			
			StringTokenizer st = new StringTokenizer(line);			
			String make = st.nextToken(",");
			String model = st.nextToken(",");
			float base = Float.parseFloat(st.nextToken(","));
			if (base < 0)
			{
				try {
					throw new AutoException(EnumAutoErrorCode.HAVEING_NEGATIVE_BASEPRICE
							,"log.txt");
				} catch (AutoException e) {
					base = base * (-1);
					System.out.println(e);
					System.out.println("Convert it to positive");
				}
			}
			int set_sz = Integer.parseInt(st.nextToken(","));
			boolean eof = false;
			auto.setBasePrice(base);
			auto.setMake(make);
			auto.setModel(model);
			
			loadOptionSet(buff, auto, set_sz);
			
			while (!eof)
			{
				line = buff.readLine();
				if(line == null)
					eof = true;
				else
				{
					int sz = Integer.parseInt(line);
					loadOption(buff, auto, sz);
				}
			}
			buff.close();
			flag = true;
		}catch(FileNotFoundException f){
			throw new AutoException(EnumAutoErrorCode.MISSING_FILE_NAME,"log.txt");
		}catch(IOException  e){
			
		}
		
		return flag;

	}
	
	/**
	 * 
	 * Help to set the options into an Automobile object
	 * @param buff
	 * @param auto
	 * @param sz
	 * @param idx
	 * @throws AutoException 
	 */
	public void loadOption(BufferedReader buff, Automobile auto, int sz) throws AutoException
	{
		try {			
			List<String> name = new ArrayList<String>();
			List<Float> price = new ArrayList<Float>();
			int i = 0;
			String line = buff.readLine();
			String[] options = line.split(":");
			if(options.length-1  < sz)
			{
				try {
					throw new AutoException(EnumAutoErrorCode.MISSING_OPTION_DATA
												,"log.txt");
				} catch (AutoException e) {
					System.out.println("Catch Exception: " + e.getErrorMsg());
				}
			}
			while(i < options.length-1)
			{
				String[] opt = options[i+1].split(",");
				if(opt.length  < 2)
				{			
					try{
						throw new AutoException(EnumAutoErrorCode.MISSING_PRICE,"log.txt");
					}catch (AutoException e) {
						System.out.println("Catch Exception: " + e.getErrorMsg());
					}
				}
				else
				{
					name.add(opt[0]);
					price.add(Float.parseFloat(opt[1]));
				}
				i++;
			}
			
			auto.setOption(options[0], name, price);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Help set the option set into an Automobile object
	 * @param buff
	 * @param auto
	 * @param sz
	 */
	public void loadOptionSet(BufferedReader buff, Automobile auto, int sz)
	{
		try {
			List<String> set_name = new ArrayList<String>();
			int i = 0;
			String line = buff.readLine();
			String[] optionSet = line.split(":");
			if(optionSet.length < sz)
			{
				try {
					throw new AutoException(EnumAutoErrorCode.MISSING_OPTIONSET_DATA
										,"log.txt");
				} catch (AutoException e) {
					System.out.println("Catch Exception: " + e.getErrorMsg());
				}
			}
			while(i < optionSet.length)
			{
				StringTokenizer st = new StringTokenizer(optionSet[i]);
				set_name.add(st.nextToken(","));
				i++;
			}
			
			auto.setOptionSet(set_name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
