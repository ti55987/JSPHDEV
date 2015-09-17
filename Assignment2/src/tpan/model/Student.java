/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
*/
package tpan.model;

import java.io.BufferedWriter;
import java.io.IOException;

public class Student {
	
	public void setSID(int id)
	{
		SID = id;
	}
	
	public void setScores(int[] scores)
	{
		for(int i = 0; i < scores.length; i++)
			this.scores[i] = scores[i];
	}
	
	public int getID()
	{
		return SID;
	}
	
	public int[] getScores()
	{
		return scores;
	}
	
	public void print()
	{
		System.out.format("%-12d",SID);
		for(int i = 0; i < scores.length; i++)
			System.out.format("%-7d",scores[i]);
	}
	
	//add methods to print values of instance variables
	private int SID;
	private int scores[] = new int[5];
}
