/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * OptionSet class encapsulates the attributes of a model.
 * There is an inner class "Option" : 
 * which contains the different options of a attribute.
 * 
 * OptionSet
 * 		Overview of the all properties:
 * 		1. the list of options
 * 		2. option set name
 * 		3. the option choice of the buyer.
 * 
 * 		Overview of the all methods:
 * 		1. getter and setter for all properties
 * 		2. find/update/delete for properties
 *  	3. print the option set 
 * Option
 * 		Overview of the all properties:
 * 		1. the price of the option
 * 		2. option name
 * 
 * 		Overview of the all methods:
 * 		1. getter and setter for all properties
*/
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet 
{
	protected class Option implements Serializable
	{
		Option(String n, float price)
		{
			name = n;
			this.price = price;
		}
		
		protected String getName()
		{
			return name;
		}
		protected float getPrice()
		{
			return price;
		}
		protected void setName(String n)
		{
			name = n;
		}
		protected void setPrice(float p)
		{
			price = p;
		}
		private String name;
		private float price;
	}
	
	OptionSet(String n)
	{
		opt = new ArrayList<Option>();
		name = n;
		optionChoice = null;
	}
	
	protected String getName()
	{
		return name;
	}
	
	protected Option getOption(int idx)
	{
		return opt.get(idx);
	}
	
	protected ArrayList<Option> getOption()
	{
		return opt;
	}
	
	protected Option getOptionChoice()
	{
		return optionChoice;
	}

	protected void setName(String n)
	{
		name = n;
	}
	
	protected void setOption(ArrayList<Option> option)
	{
		opt = option;
	}
	
	protected void setChoice(String optionName)
	{
		Option o = findOption(optionName);
		if(o != null)
			optionChoice = o;
	}
	
	protected void addOption(String name, float price)
	{
		Option o = new Option(name, price);
		opt.add(o);
	}
	
	protected Option findOption(String name)
	{
		for(int i = 0; i < opt.size(); i++)
			if( opt.get(i).getName().equals(name))
				return opt.get(i);
		
		return null;
	}
	
	protected int findOptionIdx(String name)
	{
		for(int i = 0; i < opt.size(); i++)
			if(opt.get(i).getName().equals(name))
				return i;
		
		return -1;
	}
	
	protected boolean updateOption(String name, String new_name, float val)
	{
		Option  o = findOption(name);
		if(o != null)
		{
			o.setName(new_name);
			o.setPrice(val);
			return true;
		}
		return false;
		
	}
	
	protected boolean deleteOption(String name)
	{
		int idx = findOptionIdx(name);
		if(idx != -1)
		{
			opt.remove(idx);
			return true;
		}
		return false;
	}
	
	protected boolean deleteOption(int idx)
	{
		if(idx >= opt.size())
			return false;
		else
			opt.remove(idx);
		
		return true;
	}
	
	protected void print()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" - ");
		for(int i = 0; i< opt.size(); i++)
		{
			sb.append(opt.get(i).getName());
			sb.append("(");
			sb.append(opt.get(i).getPrice());
			sb.append(")");
			sb.append(", ");
		}
		System.out.print(sb.toString());
		System.out.println();
	}
	
	private ArrayList<Option> opt;
	private String name;
	private Option optionChoice;
	
}
