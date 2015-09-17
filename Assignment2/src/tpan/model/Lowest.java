/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
 * 
 * This is a subclass of Statistics.
 * It computes and shows the results of lowest score in class.
*/
package tpan.model;


public class Lowest extends Statistics
{	
	public Lowest(Student[] student) {
		super(student);
	}

	public void Compute(int num)
	{
		for(int i = 0; i < lowscores.length; i++)
		{
			int lowest = Integer.MAX_VALUE;
			for(int j = 0; j < num; j++)
			{
				int[] stuScore = student[j].getScores();
				if(lowest > stuScore[i])
					lowest = stuScore[i];
			}
			lowscores[i] = lowest;
		}
	}
	
	@Override
	public void printResult() 
	{
		System.out.format("%-12s","Low Score");
		for(int i = 0; i < lowscores.length; i++)
		{
			System.out.format("%-7d",lowscores[i]);
		}
		System.out.println();
		
	}
	
	private int[] lowscores  = new int[num_quiz];

}
