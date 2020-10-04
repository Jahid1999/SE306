package assignment;

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
			System.out.println("WELCOME TO THE BANK!\n1.Create account\n2.Log in\n3.Exit\n");
			
			int choice;
			choice = cin.nextInt();
			
			if(choice==3) break;
			else if(choice==1) func.createAccount();
			else if(choice==2) func.beforeLogIn();
			
			System.out.println();
		}
	}
}
