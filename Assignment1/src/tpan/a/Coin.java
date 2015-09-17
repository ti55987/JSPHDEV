/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.a;
import java.util.Random;


enum SideUp
{
	heads, tails;
}

public class Coin 
{
	public Coin()
	{		
		toss();
	}
	
	public void toss()
	{
		Random head = new Random();
		if(head.nextBoolean())
			sideup = SideUp.heads;
		else
			sideup = SideUp.tails;
	}
	
	public SideUp getSideUp()
	{
		return sideup;
	}
	
	private SideUp sideup;

}
