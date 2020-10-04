package assignment;


import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass 
{

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		Menu menu = new Menu();
		menu.option();
	}
}