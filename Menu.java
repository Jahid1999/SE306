package hackathon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Menu 
{
	int choice=-1,i=0;
	Scanner cin= new Scanner(System.in);
	
	public void option() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		FunctionsClass func=new FunctionsClass();
		
		while(true)
		{
			System.out.println("WELCOME TO STUDENTSHIP CERTIFICATE GIVER!\n1.Sign In\n2..Exit\n");
			
			int choice;
			choice = cin.nextInt();
			
			if(choice==2) break;
			else if(choice==1) func.beforeLogIn();
			System.out.println();
		}
	}
}
