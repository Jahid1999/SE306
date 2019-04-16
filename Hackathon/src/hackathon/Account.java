package hackathon;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Serializable
{
	private static final long serialVersionUID = 6468712106990670803L;
	
	private  String accName;
	private  String accNumber;
	private  String nid;
	private  double balance;
	
	public boolean If=false;

	ArrayList <Account> accounts = new ArrayList <Account> ();
	
	public Account(String accName, String accNumber, double balance ,String nid)
	{	
		this.accName= accName;
		this.accNumber = accNumber;
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
			If=true;
			System.out.println("WITHDRAWAL DONE!\n");
			
		}	
		else System.out.println("WITHDRAWAL AMMOUNT IS INVALID!\n");
		
		
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
		return this.accNumber;
	}
		
	public String getAccName()
	{
		return this.accName;
	}
		
	public int search (String s)
	{	
		for(int i=0;i<accounts.size();i++)
		{	
			String s4 = accounts.get(i).getAccNum();
			if(s4.equals(s))
			{	
				return i;
			}
		}
		return -1;
	}
		
		
	public void afterLogIn(Socket client)
	{
		try
		{
			String s = "\nEnter account number: ";
			ObjectOutputStream ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(s);
			ob.flush();
			ObjectInputStream ib = new ObjectInputStream(client.getInputStream());
			String s1 = null;
			s1 = (String)ib.readObject();

			int i = search(s1);

			if(i!=-1)
			{	
					accounts.get(i).withdraw();
					
					if(If)
					{
						
					}
				
			}
				
			else
			{
				s = "\nACCOUNT NOT FOUND!\n";
				ob = new ObjectOutputStream(client.getOutputStream());
				ob.writeObject(s);
				ob.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
