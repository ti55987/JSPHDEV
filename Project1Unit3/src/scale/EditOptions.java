/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * EditOptions realizes the multiple threads situations to make
 * the whole system more flexible and scalable.
 * SyncUpdateAuto object builds a bridge between this class and 
 * Automobile such that we could update the objects
*/
package scale;


public class EditOptions implements Runnable
{
	private String modelName;
	private int change;
	private String optSetName;
	private String optName;
	private String newSetName;
	private float newPrice;
	private SyncUpdateAuto auto;
	private Thread t;
	
	public EditOptions(String model, SyncUpdateAuto auto)
	{
		this.auto = auto;
		modelName = model;
		t = new Thread(this);
	}
	
	public void setModel(String model)
	{
		modelName = model;
	}
	
	public String getModel()
	{
		return modelName;
	}
	
	public void setOptSetName(String name)
	{
		optSetName = name;
	}
	
	public String getOptSet()
	{
		return optSetName;
	}
	
	public void setOpt(String name)
	{
		optName = name;
	}
	
	public String getOpt()
	{
		return optName;
	}
	
	public void setAuto(SyncUpdateAuto auto)
	{
		this.auto = auto;
	}
	
	public SyncUpdateAuto getAuto()
	{
		return auto;
	}
	
	public float getNewPrice()
	{
		return newPrice;
	}
	
	public String getNewSetName()
	{
		return newSetName;
	}
	
	public void setUpdateOptionSetName(String set, String newName, int c)
	{
		optSetName = set;
		newSetName = newName;
		change = c;
	}
	
	public void setUpdateOptionPrice(String set, String option, float price, int c)
	{
		optSetName = set;
		optName = option;
		newPrice = price;
		change = c;
	}
	
	
	public void run() {
		// If we disable the synchronize here, then the data corruption will occur.
		synchronized(auto)
		{
			// If change is one, then we know the optionSet is updated
			// While if the change is two, the price should be updated by calling
			// SyncUpdateAuto object.
			switch(change)
			{
				case 1:
					System.out.print("\n[Try Update]\n-->Update from: " + optSetName);
					System.out.println(" to: " + newSetName);
					auto.syncUpdateOptionSetName(modelName, optSetName, newSetName);
					break;
				case 2:
					System.out.print("\n[Try Update]\n-->Update price to: " + newPrice);
					System.out.println(" of option: " + optSetName + "." + optName);
					auto.syncUpdateOptionPrice(modelName, optSetName, optName, newPrice);
					break;
			}
				
		}
		
	}
	// Since the class just implement the runnable instead of 
	// extend Thread class. So I need to new a Thread in this class
	// and write my own start and join methods to enable the threads.
	public void start()
	{
		t.start();
	}

	public void join()
	{
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
