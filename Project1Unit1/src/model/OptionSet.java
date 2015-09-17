/*
 * Andrew ID: tpan
 * Name: Ti-Fen Pan
 * 
 * OptionSet class encapsulates the attributes of a model.
 * There is an inner class "Option" : 
 * which contains the different options of a attribute.
 *   
*/
package model;


import java.io.Serializable;

public class OptionSet implements Serializable{
	
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
	
	OptionSet(String n, int size)
	{
		opt = new Option[size];
		name = n;
	}
	
	protected String getName()
	{
		return name;
	}
	
	protected Option getOption(int idx)
	{
		return opt[idx];
	}
	
	protected Option[] getOption()
	{
		return opt;
	}
	
	protected void setName(String n)
	{
		name = n;
	}
	
	protected void setOption(String[] n, float[] price)
	{
		for(int i = 0; i < n.length; i++)
		{
			Option op = new Option(n[i], price[i]);
			opt[i] = op;
		}
	}
	
	protected Option findOption(String name)
	{
		for(int i = 0; i < opt.length; i++)
			if(opt[i] != null && opt[i].getName().equals(name))
				return opt[i];
		
		return null;
	}
	
	protected int findOptionIdx(String name)
	{
		for(int i = 0; i < opt.length; i++)
			if(opt[i] != null && opt[i].getName().equals(name))
				return i;
		
		return -1;
	}
	
	protected void updateOptionSize(int sz)
	{
		opt = new Option[sz];
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
			opt[idx] = null;
			return true;
		}
		return false;
	}
	
	protected boolean deleteOption(int idx)
	{
		if(idx > opt.length-1)
				return false;
		opt[idx] = null;
		return true;
	}
	
	protected void print()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" - ");
		for(int i = 0; i< opt.length-1; i++)
		{
			if(opt[i] == null)
				continue;
			
			sb.append(opt[i].getName());
			sb.append(", ");
		}
		sb.append(opt[opt.length-1].getName());
		System.out.print(sb.toString());
		System.out.println();
	}
	
	private Option opt[];
	private String name;
	

}
