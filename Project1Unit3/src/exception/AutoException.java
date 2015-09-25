/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * 1. getter and setter for error message and error id.
 * 2. print the error message
 * 3. fix the problem
 * 4. create the logging file to track the exception messages.
 * 
*/
package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoException extends Exception
{
	public AutoException(EnumAutoErrorCode code, String logfile)
	{
		errorCode = code.getId();
		errorMsg = code.getmsg();
		logging(logfile);
	}
	
	public int getErrorCode()
	{
		return errorCode;
	}
	public String getErrorMsg()
	{
		return errorMsg;
	}
	public void logging(String logfile)
	{
		try {
			FileWriter fw = new FileWriter(logfile, true);// append data 
			BufferedWriter bw = new BufferedWriter(fw);
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			bw.write("[" + format.format(new Date()) + "]: ");
			bw.write(printproblem());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String fix(int errno)
	{
		Fix1to100 f1 = new Fix1to100();
		
		switch(errno)
		{
			case 4: 
				return f1.fix4(errno);
		}
		
		return null;
		
	}
	
	public String printproblem()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("AutoException [errorCode=");
		sb.append(errorCode);
		sb.append(", errorMsg=");
		sb.append(errorMsg);
		sb.append("]\n");
		return sb.toString();
	}

	private String errorMsg;
	private int errorCode;
}
