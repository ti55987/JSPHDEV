/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
 * 
 * This is a class including read text file method and 
 * a method for showing the result 
 * 
*/
package tpan.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import tpan.exception.CustomException;
import tpan.model.Average;
import tpan.model.Highest;
import tpan.model.Lowest;
import tpan.model.Student;

public class Util
{
	
	
	
	/**
	 * Read the file and store the students' id and scores into Student object.
	 * @param filename
	 * @param student
	 * @throws CustomException
	 */
	public static void readFile(String filename, Student[] student) throws CustomException
	{
		boolean eof = false;
		int i_stud = 0;
		
		try{
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			
			while (!eof)
			{
				String line = buff.readLine();
				if(line == null)
					eof = true;
				else
				{
					int i = 0;
					int[] score = new int[5];
					Student s = new Student();
					StringTokenizer st = new StringTokenizer(line);
					String id = st.nextToken();
					
					if(!id.equals("Stud"))
					{
						s.setSID(Integer.parseInt(id));
						
						while(st.hasMoreElements())
						{											
							score[i] = Integer.parseInt(st.nextToken());
							i++;
						}
						s.setScores(score);
					
						if(i_stud > 39)
							throw new CustomException("More than 40 records. "
									+ "Take first 40 records");

						student[i_stud] = s;
						i_stud++;
						
					}
					
				}
			}
			buff.close();
		}
		catch(IOException e)
		{
			System.out.println("Error --" + e.toString());
		}

	}
	
	
	/**
	 * Show the result which format is based on the handout.
	 * Instantiate the Lowest, Highet and Average class to compute 
	 * and show the result.
	 * @param student
	 */
	public static void showtable(Student[] student) 
	{
		int num_stu = 40;
		
		System.out.format("%-12s", "Stud");
		System.out.format("%-7s", "Qu1");
		System.out.format("%-7s", "Qu2");
		System.out.format("%-7s", "Qu3");
		System.out.format("%-7s", "Qu4");
		System.out.format("%-7s%n", "Qu5");
		
		for(int i = 0; i < student.length; i++)
		{
			// To compute the number of student
			if(student[i] == null)
			{
				num_stu = i;
				break;
			}
			student[i].print();
			System.out.println();
		}
		
		System.out.println();
		
		Lowest low = new Lowest(student);
		Highest high = new Highest(student);
		Average avg = new Average(student);
		
		low.Compute(num_stu);
		high.Compute(num_stu);
		avg.Compute(num_stu);
		
		high.printResult();
		low.printResult();
		avg.printResult();
	}
	
	

}
