package assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class FunctionsClass{
	
	private String name;
	private String DOB;
	private String adr;
	private String phn;
	private String accNum;
	private String acctyp;
	private String nid;
	double balance;
	
	private ArrayList<Account> listPerson= new ArrayList<>();
	private ArrayList<Bank> listBank= new ArrayList<>();
	
	Scanner cin= new Scanner(System.in);
	
	public void initialize() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File newFile= new File("personal.txt");
		
		if(newFile.length()==0) return; 
		
		ObjectInputStream PersObj= new ObjectInputStream(new FileInputStream("personal.txt"));
		ObjectInputStream BankObj= new ObjectInputStream(new FileInputStream("bankInfo.txt"));
		
		listPerson= (ArrayList<Account>) PersObj.readObject();
		listBank=(ArrayList<Bank>) BankObj.readObject();
		
	}
	
	public void createAccount() 
	{
		
		boolean df=false;
		cin.nextLine();
		
		System.out.println("Enter name: ");
		name=cin.nextLine();
		
		System.out.println("Enter Date of Birth: ");
		DOB=cin.nextLine();
		
		System.out.println("Enter Address: ");
		adr=cin.nextLine();
		
		System.out.println("Enter NID: ");
		nid=cin.nextLine();
		
		System.out.println("Enter Phone Number: ");
		phn=cin.nextLine();
		
		System.out.println("Enter Account Number: ");
		accNum=cin.nextLine();
		
		System.out.println("Enter Account Type: ");
		acctyp=cin.nextLine();
		
		System.out.println("Enter Account Balance: ");
		balance=cin.nextDouble();
		
		Account account= new Account(name,DOB,adr,phn,accNum,balance,nid);
		Bank bank= new Bank(accNum,acctyp,balance);
		
		for(Account it: listPerson)
		{
			if(it.accNum.equals(accNum))
			{
				for(Bank itr: listBank)
				{
					if(itr.accNum.equals(accNum))
					{		
						System.out.println("An Account has been found with this account number!\n");
						System.out.print(it.toString());
						System.out.print(itr.toString());
						df=true;
						
						System.out.println("What do you want to do now?\n1.Replace it\n2.Leave it\n");
						int i=cin.nextInt();
						
						if(i==1)
						{
							listPerson.remove(it);
							listBank.remove(itr);
							listPerson.add(account);
							listBank.add( bank);
							writer(listPerson,listBank);	
						}
						
						else if(i==2)
						{
							System.out.println("Okay!!try again with new account number\n");
							createAccount();
							
						}
						
						break;
					}
				}
				
				if(df)
					break;
			}	
		}
		
		if(!df)
		{	
			listPerson.add(account);
			listBank.add( bank);
			writer(listPerson,listBank);
		}
	}
	
	
	public void writer(ArrayList<Account> listPerson,ArrayList<Bank> listBank) {
		
		FileOutputStream fout = null;
	    ObjectOutputStream object_out_for_serializable = null;
	        
	    try {
	            fout = new FileOutputStream("persnal.txt");
	            object_out_for_serializable = new ObjectOutputStream(fout);
	            
	            object_out_for_serializable.writeObject(listPerson);
	            object_out_for_serializable.flush();
	            
	            fout = null;
	    	    object_out_for_serializable = null;
	    	    
	    	    fout = new FileOutputStream("bankInfo.txt");
	            object_out_for_serializable = new ObjectOutputStream(fout);
	            
	            object_out_for_serializable.writeObject(listBank);
	            object_out_for_serializable.flush();
	                    
	            System.out.println("Entry added Successfully\n");
	    	} 
	    
	    catch (FileNotFoundException ex) 
	    {
	            System.out.println("FileOutputStream in " + ex.toString());
	    } 
	    catch (IOException ex) 
	    {
	            System.out.println("ObjectOutputStream in " + ex.toString());
	    } 
	}
	
	public void remove() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		String s;
		boolean f=false;

		System.out.println("Enter Account Name:\n");
		s=cin.nextLine();
		
		System.out.println("Enter the Account Number:\n");
		s=cin.next();
		
		for(Account it: listPerson)
		{
			if(it.accNum.equals(s))
			{
				for(Bank itr: listBank)
				{
					if(itr.accNum.equals(s))
					{		
						f=true;
						listPerson.remove(it);
						listBank.remove(itr);
						writer(listPerson,listBank);
						break;
					}
				}
				
				if(f)
					break;
			}
		}
		
		if(f) 
			System.out.println("Account has been successfull deleted");
		else
			System.out.println("No Match found!\nTryAgain");
	}
	
	
	public int search (String s)
	{	
		for(int i=0;i<listPerson.size();i++)
		{	
			String s4 = listPerson.get(i).getAccNum();
			if(s4.equals(s))
			{	
				return i;
			}
		}
		return -1;
	}
	
	public ArrayList<Account> getAccounts() {
		return listPerson;
	}
	
	
	public void beforeLogIn()
	{
		Scanner cin = new Scanner (System.in);
		
		System.out.print("\nEnter account number: ");
				
		String s3=cin.nextLine();
			
		int i = search(s3);
		
		if(i!=-1) listPerson.get(i).afterLogIn();
		else System.out.println("\nACCOUNT NOT FOUND!\n");
	}
	
	public void look() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Iterator it= listPerson.iterator();
		Iterator iti= listBank.iterator();
		
		while(it.hasNext()) 
		{	
			System.out.println(it.next().toString()+ iti.next().toString());
		}
		
	}
	
}