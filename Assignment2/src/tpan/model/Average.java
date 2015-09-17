/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
 * 
 * This is a subclass of Statistics.
 * It computes and shows the results of average score in class.
*/
package tpan.model;



public class Average extends Statistics
{
	public Average(Student[] student) {
		super(student);
	}

	public void Compute(int num)
	{
		for(int i = 0; i < avgscores.length; i++)
		{
			int avg = 0;
			for(int j = 0; j < num; j++)
			{
				int[] stuScore = student[j].getScores();
				avg += stuScore[i];
			}
			avgscores[i] = avg/num;
		}
	}
	
	@Override
	public void printResult() 
	{
		System.out.format("%-12s", "Average");
		for(int i = 0; i < avgscores.length; i++)
		{
			System.out.format("%-7.2f",avgscores[i]);
		}	
		System.out.println();
	}

	private float[] avgscores = new float[num_quiz];
}
