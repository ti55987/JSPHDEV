/*
 * AndrewID: tpan
 * Name: Ti-Fen Pan
 * 
 * A Test program for different cases: 
 * 1. records < 40
 * 2. records = 40
 * 3. records > 40
*/
package tpan;

import tpan.exception.CustomException;
import tpan.model.Student;
import tpan.util.Util;

public class Test {

	public static void main(String[] args) {
		
		Student[] student = new Student[40];	
		// records < 40
		try 
		{
			Util.readFile("input.txt", student);
			
		} catch (CustomException e) 
		{
			System.out.println("Custom exception: " + e.getMessage());
		}

		Util.showtable(student);
		System.out.println();
		// records = 40
		try 
		{
			Util.readFile("input2.txt", student);
			
		} catch (CustomException e) 
		{
			System.out.println("Custom exception: " + e.getMessage());
		}

		Util.showtable(student);
		System.out.println();
		// records > 40
		try 
		{
			Util.readFile("input3.txt", student);
			
		} catch (CustomException e) 
		{
			System.out.println("Custom exception: " + e.getMessage());
		}

		Util.showtable(student);

	}

}
