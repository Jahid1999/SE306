package file;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class FileWrite 
{
	public static void main(String[] args) 
	{
		try
		{
			Formatter formtr = new Formatter("/home/abdullah-al-jahid/Desktop/iit/info.txt");
			
			formtr.format("%s,%s,%s\n","123","jahid","ter" );
			formtr.format("%s,%s,%s\n","125","sam","ret");
			
			formtr.close();
		}
		
		catch(FileNotFoundException e)
		{
			
			System.out.println(e);
		}
	}
}
