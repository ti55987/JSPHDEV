/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * Fix the missing file name exception
*/
package exception;

public class Fix1to100 
{
	public String fix4(int errno)
	{
		if(errno == 4)
			return "./testcases/Ford.txt"; // default model text file
		else
			return null;
	}
}
