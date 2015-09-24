/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * Automotive class encapsulates the configuration of a car model
 * It contains OptionSet class which properties are all protected 
 * such that it enforces outside classes can only access OptionSet
 * via Automotive object.
 * 
 * OptionSet
 * 		Overview of the all properties:
 * 		1. the list of optionset 
 * 		2. model name
 * 		3. maker name
 * 		3. base price
 * 
 * 		Overview of the all methods:
 * 		1. getter and setter for all properties
 * 		2. find/update/delete for properties
 *  	3. print the option set 
 *  	4. print the option choice
 *  	5. calculate the total price
*/
package model;

import java.util.ArrayList;
import java.util.List;

import model.OptionSet.Option;

public class Automobile 
{
	public Automobile()
	{
		opset = new ArrayList<OptionSet>();
	}
	
	public Automobile(String model, String make, float price)
	{
		this.model = model;
		this.make = make;
		baseprice = price;
		opset = new ArrayList<OptionSet>();
	}
	
	public String getMake()
	{
		return make;
	}
	public String getModel()
	{
		return model;
	}
	public double getPrice()
	{
		return baseprice;
	}
	public OptionSet getOptionSet(int idx)
	{
		return opset.get(idx);
	}
	public List<OptionSet> getOptionSet()
	{
		return opset;
	}
	public String getOptionChoice(String setName)
	{
		OptionSet set = FindOptionSet(setName);
		return set.getOptionChoice().getName();
	}
	public float getOptionChoicePrice(String setName)
	{
		OptionSet set = FindOptionSet(setName);
		return set.getOptionChoice().getPrice();
	}
	public void setModel(String m)
	{
		model = m;
	}
	public void setMake(String m)
	{
		make = m;
	}
	public void setBasePrice(float price)
	{
		baseprice = price;
	}
	
	public void setOptionSet(List<String> name)
	{
		for(int i = 0; i < name.size(); i++)
		{
			OptionSet set = new OptionSet(name.get(i));
			opset.add(set);
		}
	}
	
	public void setOption(String set_name, List<String> name, List<Float> price)
	{
		OptionSet set = FindOptionSet(set_name);
		
		for(int i = 0; i < name.size(); i++)
		{
			set.addOption(name.get(i), price.get(i));
		}
		
	}
	
	public void setOption(int idx, List<String> name, List<Float> price)
	{
		OptionSet set = opset.get(idx);
		for(int i = 0; i < name.size(); i++)
		{
			set.addOption(name.get(i), price.get(i));
		}
	}
	
	public void setOptionChoice(String setName, String optionName)
	{
		OptionSet set = FindOptionSet(setName);
		if(set != null)
			set.setChoice(optionName);
	}
	/**
	 * Find OptionSet by name
	 * return null if fails
	 * @param name
	 * @return
	 */
	public OptionSet FindOptionSet(String name)
	{
		for(int i = 0; i < opset.size(); i++)
			if(opset.get(i).getName().equals(name))
				return opset.get(i);
		
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
		for(int i = 0; i < opset.size(); i++)
			if(opset.get(i).getName().equals(name))
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
	
	public boolean UpdateOptionSetName(String name, String newName)
	{
		OptionSet set = FindOptionSet(name);
		if(set == null)
			return false;
		
		set.setName(newName);
		
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
		
		opset.remove(idx);
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
		if(idx >= opset.size())
			return false;
		
		opset.remove(idx);
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
		if(set_idx >= opset.size())
			return false;
		OptionSet set = opset.get(set_idx);
		return set.deleteOption(opt_idx);
	}
	
	public void print()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Model Name: ");
		sb.append(model);
		sb.append("\n");
		sb.append("Base Price: ");
		sb.append(baseprice);
		System.out.println(sb.toString());
		System.out.println("OptionSets: ");
		for(int i = 0; i < opset.size(); i++)
		{
			opset.get(i).print();
		}
		System.out.println("-------------------");
	}
	
	public void printChoice()
	{
		System.out.println("User Choice Set: ");
		StringBuilder sb = new StringBuilder();
		for(OptionSet set: opset)
		{
			sb.append(set.getName());
			sb.append(": ");
			sb.append(set.getOptionChoice().getName());
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println("Total price: " + getTotalPrice());
		System.out.println("-------------------");
	}
	/**
	 * Print a certain OptionSet by index
	 * @param idx
	 */
	public void printOptionSet(int idx)
	{
		opset.get(idx).print();
	}
	
	public float getTotalPrice()
	{
		float price = baseprice;
		for(OptionSet set: opset)
		{
			float val = set.getOptionChoice().getPrice();
			price += val;
		}
		return price;
	}
	
	private ArrayList<OptionSet> opset;
	private String model;
	private String make;
	private float baseprice;

}
