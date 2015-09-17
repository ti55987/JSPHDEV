/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
 * 
 * This is a subclass of Statistics.
 * It computes and shows the results of highest score in class.
*/
package tpan.model;


public class Highest extends Statistics
{

	public Highest(Student[] student) {
		super(student);
	}

	public void Compute(int num)
	{
		for(int i = 0; i < highscores.length; i++)
		{
			int highest = 0;
			for(int j = 0; j < num; j++)
			{
				int[] stuScore = student[j].getScores();
				if(highest < stuScore[i])
					highest = stuScore[i];
			}
			highscores[i] = highest;
		}
	}
	
	@Override
	public void printResult() 
	{
		System.out.format("%-12s", "High Score");
		for(int i = 0; i < highscores.length; i++)
		{
			System.out.format("%-7d",highscores[i]);
		}
		System.out.println();
	}

	private int[] highscores = new int[num_quiz];
}
