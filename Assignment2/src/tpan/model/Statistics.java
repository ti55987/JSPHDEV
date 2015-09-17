/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
 * 
 * This is a superclass for Lowest,Highest and Average class.
 * It implements interface Display 
*/
package tpan.model;

import java.util.Arrays;

public abstract class Statistics implements Display
{
	Statistics(Student[] student)
	{
		this.student = Arrays.copyOf(student, student.length);
	}
	
	abstract void Compute(int num);
	
	protected Student[] student;
	protected int num_quiz = 5;
}
