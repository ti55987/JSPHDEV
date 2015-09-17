/*
 * Andrew ID: tpan
 * Name: Ti-Fen Pan
 * 
 * Automotive class encapsulates the configuration of a car model
 * It contains OptionSet class which properties are all protected 
 * such that it enforces outside classes can only access OptionSet
 * via Automotive object.
*/
package model;

import java.io.Serializable;

import model.OptionSet.Option;

public class Automotive implements Serializable{
	
	
	public Automotive()
	{
		
	}
	
	public Automotive(String n, float price, int size)
	{
		name = n;
		baseprice = price;
		opset = new OptionSet[size];
	}
	
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return baseprice;
	}
	public OptionSet getOptionSet(int idx)
	{
		return opset[idx];
	}
	public OptionSet[] getOptionSet()
	{
		return opset;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setBasePrice(float price)
	{
		baseprice = price;
	}
	
	public void setOptionSet(String[] name, int[] sz)
	{
		for(int i = 0; i < name.length; i++)
		{
			OptionSet set = new OptionSet(name[i], sz[i]);
			opset[i] = set;
		}
	}
	
	public void setOption(String set_name, String[] name, float[] price)
	{
		OptionSet set = FindOptionSet(set_name);
		set.setOption(name, price);
	}
	
	public void setOption(int idx, String[] name, float[] price)
	{
		opset[idx].setOption(name, price);
	}
	
	/**
	 * Find OptionSet by name
	 * return null if fails
	 * @param name
	 * @return
	 */
	public OptionSet FindOptionSet(String name)
	{
		for(int i = 0; i < opset.length; i++)
			if(opset[i] != null && opset[i].getName().equals(name))
				return opset[i];
		
		return null;
	}
	
	/**
	 * Find OptionSet by index
	 * return -1 if fails
	 * @param name
	 * @return
	 */
	public int FindOptionSetIdx(String name)
	{
		for(int i = 0; i < opset.length; i++)
			if(opset[i] != null && opset[i].getName().equals(name))
				return i;
		
		return -1;
	}

	/**
	 * Find option by name
	 * return null if fails
	 * @param set_name
	 * @param opt_name
	 * @return
	 */
	public Option FindOption(String set_name, String opt_name)
	{
		OptionSet set = FindOptionSet(set_name);
		if(set != null)
		{
			return set.findOption(opt_name);
		}
		
		return null;
	}
	
	/**
	 * Update the option set with a new name and update its options
	 * return false if fails
	 * @param name
	 * @param new_name
	 * @param opt_name
	 * @param price
	 * @return
	 */
	public boolean UpdateOptionSet(String name, String new_name, 
							String[] opt_name, float[] price)
	{
		OptionSet set = FindOptionSet(name);
		if(set == null)
			return false;
		
		set.setName(new_name);
		set.updateOptionSize(opt_name.length);
		setOption(new_name, opt_name, price);
		return true;
	}
	
	/**
	 * In a certain option set, update one of its option's name/price
	 * return false if fails 
	 * @param set_name
	 * @param opt_name
	 * @param new_name
	 * @param val
	 * @return
	 */
	public boolean UpdateOption(String set_name, String opt_name, 
							String new_name, float val)
	{
		OptionSet set = FindOptionSet(set_name);
		if(set == null)
			return false;
		
		set.updateOption(opt_name, new_name, val);
		return true;
	}
	
	/**
	 * Delete optionSet by name
	 * return false if fails
	 * @param name
	 * @return
	 */
	public boolean DeleteOptionSet(String name)
	{
		int idx = FindOptionSetIdx(name);
		if(idx == -1)
			return false;
		
		opset[idx] = null;
		return true;
	}
	
	/**
	 * Delete optionSet by index
	 * return false if fails
	 * @param idx
	 * @return
	 */
	public boolean DeleteOptionSet(int idx)
	{
		if(idx > opset.length-1)
			return false;
		
		opset[idx] = null;
		return true;
	}
	
	/**
	 * Delete option by name (in context of optionSet)
	 * return false if fails
	 * @param set_name
	 * @param opt_name
	 * @return
	 */
	public boolean DeleteOption(String set_name, String opt_name)
	{
		OptionSet set = FindOptionSet(set_name);
		if(set == null)
			return false;
		
		set.deleteOption(opt_name);
		return true;
	}
	
	/**
	 *  Delete option by index (in context of optionSet)
	 *  return false if fails
	 * @param set_idx
	 * @param opt_idx
	 * @return
	 */
	public boolean DeleteOption(int set_idx, int opt_idx)
	{
		if(set_idx > opset.length-1)
			return false;
		OptionSet set = opset[set_idx];
		return set.deleteOption(opt_idx);
	}
	
	public void print()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Model Name: ");
		sb.append(name);
		sb.append("\n");
		sb.append("Base Price: ");
		sb.append(baseprice);
		System.out.println(sb.toString());
		System.out.println("OptionSets: ");
		for(int i = 0; i < opset.length; i++)
		{
			if(opset[i] == null)
				continue;
			opset[i].print();
		}
	}
	/**
	 * Print a certain OptionSet by index
	 * @param idx
	 */
	public void printOptionSet(int idx)
	{
		opset[idx].print();
	}
	
	private OptionSet opset[];
	private String name;
	private float baseprice;

}
