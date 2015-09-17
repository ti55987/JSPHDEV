/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.a;




public class Test 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 20;
		System.out.println("Toss "+ count + " times simulation: ");
		Simulation simulate = new Simulation(count);
		simulate.start();
		
		count = 0;
		System.out.println("Toss "+ count + " times simulation: ");
		simulate.setCount(count);
		simulate.start();
		
		count = 30;
		System.out.println("Toss "+ count + " times simulation: ");
		simulate.setCount(count);
		simulate.start();
		
	}

}
