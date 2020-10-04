package file;

import java.io.File;
import java.util.Scanner;

public class FileRead 
{
	public static void main(String[] args) 
	{
		try
		{
			File file = new File("/home/abdullah-al-jahid/Desktop/iit/info.txt");
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext())
			{
				String reg = scanner.next();				
				String name = scanner.next();
				String nid = scanner.next();
				
				System.out.println("Reg: "+reg +"\nName: "+name+"\nNID: "+ nid);
				
			}
			
			scanner.close();
			
		}
		catch(Exception e)
		{
			
			System.out.println(e);
		}
		
	}

}
