package assignment;

import java.io.Serializable;
import java.util.Scanner;

public class Account implements Serializable
{
	private static final long serialVersionUID = 6468712106990670803L;
	
	private  String accName;
	public String accNum;
	private  String nid;
	private  double balance;
	private String DOB;
	private String adr;
	private String phn;
	
	public Account(String accName,String DOB, String adr, String phn,String accNum, double balance ,String nid)
	{	
		this.accName= accName;
		this.DOB=DOB;
		this.adr=adr;
		this.phn=phn;
		this.accNum = accNum;
		this.balance = balance;
		this.nid = nid;
	}
		
	

	public void withdraw()
	{
		Scanner cin = new Scanner (System.in);
	
		System.out.print("\nEnter withdrawal ammount: ");
	
		double ammount = cin.nextDouble();
		System.out.println();
		
		if(ammount <= balance-500.00 && ammount>=100.00)
		{
			balance =balance- ammount;
			System.out.println("WITHDRAWAL DONE!\n");
			
		}	
		else System.out.println("WITHDRAWAL AMMOUNT IS INVALID!\n");
		
		System.out.println("Your current balance is: "+balance+'\n');
	}		 
	
	public void deposit()
	{
		Scanner cin = new Scanner (System.in);

		System.out.print("\nEnter deposit ammount: ");
		
		double ammount = cin.nextDouble();
		System.out.println();
		
		if(ammount>=500.00)
		{
			balance =balance+ammount;
			System.out.println("DEPOSIT DONE!\n");
		}
		else System.out.println("DEPOSIT AMMOUNT IS INVALID!\n");
		
		System.out.println("Your current balance is: "+balance+'\n');
	}
		
	public void checkBalance()
	{
		System.out.println("\nYour account balance is: "+balance+'\n');
	}
		
	public String getAccNum()
	{
		return this.accNum;
	}
		
	public String getAccName()
	{
		return this.accName;
	}
		
	public void printAllInfo()
	{
		System.out.println("\nACCOUNT INFORMATION\nName: " +accName + "\nAccount number: " + accNum+ "\nNID: "+ nid +
			"\nBalance: "+ balance+'\n');
		
	}
		
		
	public void afterLogIn()
	{
		Scanner cin = new Scanner (System.in);
		
		System.out.print("\nWelcome "+accName+"!");
			
		while(true)
		{
			
			System.out.println("\n1.Check balance\n2.Withdraw money\n3.Deposit money\n4.Print account info\n5.Log out\n");
			
			int choice;
			choice = cin.nextInt();
				
			if(choice==5) break;
			else if(choice==1) System.out.println("\nYour account balance is: "+balance+'\n');
			else if(choice==2) withdraw();
			else if(choice==3) deposit();
			else if(choice==4) printAllInfo();
		}
	}
}