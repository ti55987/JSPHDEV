/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.a;




public class Simulation 
{	
	
	public Simulation(int count)
	{
		TossCounts = count;
	}
	
	public void setCount(int count)
	{
		TossCounts = count;
	}
	
	public void start() 
	{
		
		coin = new Coin();
		heads_count = 0;
		tails_count = 0;
		
		System.out.println("Initial Face: " + coin.getSideUp());
				
		for(int i = 0; i < TossCounts; i++)
		{
			coin.toss();
			System.out.println( (i+1) + " toss: " + coin.getSideUp());
			if(coin.getSideUp() == SideUp.heads)
				heads_count++;
			else 
				tails_count++;
		}
		
		System.out.println("head counts: " + heads_count);
		System.out.println("tail counts: " + tails_count);
	}
	
	private Coin coin;
	private int TossCounts = 20;
	private int heads_count;
	private int tails_count;

}
