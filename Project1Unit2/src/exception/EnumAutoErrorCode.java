/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * Encapsulate all the custom exception properties.
 * 
*/
package exception;

public enum EnumAutoErrorCode 
{
	MISSING_PRICE(1, "Missing price for Automobile in text file"),
	MISSING_OPTIONSET_DATA(2, "Missing OptionSet data (or part of it)"),
	MISSING_OPTION_DATA(3, "Missing Option data"),
	MISSING_FILE_NAME(4, "Missing filename or wrong filename"),
	HAVEING_NEGATIVE_BASEPRICE(5, "Wrong type of price");
	
	private final int id;
	private final String msg;
	
	EnumAutoErrorCode(int id, String msg)
	{
		this.id = id;
		this.msg = msg;
	}
	
	public int getId()
	{
		return id;
	}
	public String getmsg()
	{
		return msg;
	}
}
