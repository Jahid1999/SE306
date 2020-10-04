package file;

import java.io.File;

public class MakeDir {

	public static void main(String[] args) 
	{
		File dir = new File("/home/abdullah-al-jahid/Desktop/iit");
		
		dir.mkdir();
		
		String dirPath = dir.getAbsolutePath();
		
		File file1= new File(dirPath+"/person.txt");
		File file2= new File(dirPath+"/info.txt");
		
		try
		{
			file1.createNewFile();
			file2.createNewFile();
			
		}
		
		catch(Exception e)
		{
			
			System.out.println(e);
		}
		
	/*	if(file1.exists())
		{
			System.out.println("file1 exixts");
		}
		
		file2.delete();
		
		if(file2.exists())
		{
			System.out.println("file2 exists");
		}
		
		else
		{
			System.out.println("file2 doesn't exist");
		}
		*/
		
	}

}
