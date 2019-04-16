package hackathon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Operator implements Serializable
{
	ServerSocket server = new ServerSocket(7820);
	Socket client = null;
	ObjectOutputStream ob = null;
	ObjectInputStream ib = null;

	ArrayList <Account> accounts = new ArrayList <Account> ();
	
	private static final long serialVersionUID = -1025998266932287368L;

	public Operator() throws IOException {
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
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void createAccount ()
	{
		
		String s = null,s1 = null,s2 = null;
		Double d;
		d = 0.0;

		String name = "\nEnter info:\nAccount name: ";

		try {
			ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(name);
			ob.flush();
			ib = new ObjectInputStream(client.getInputStream());
			s = (String)ib.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String num = "Account number: ";
		try {
			ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(num);
			ob.flush();
			ib = new ObjectInputStream(client.getInputStream());
			s1 = (String)ib.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String amm = "First deposit ammount: ";
		try {
			ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(amm);
			ob.flush();
			ib = new ObjectInputStream(client.getInputStream());
			d = (double)ib.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String nid = "NID: ";
		try {
			ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(nid);
			ob.flush();
			ib = new ObjectInputStream(client.getInputStream());
			s2 = (String)ib.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		


		accounts.add(new Account(s,s1,d,s2));
		
		String cre = "\nACCOUNT CREATED!\n";

		try {
			ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(cre);
			ob.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void beforeLogIn()
	{

		try
		{
			String s = "\nEnter account number: ";
			ob = new ObjectOutputStream(client.getOutputStream());
			ob.writeObject(s);
			ob.flush();
			ib = new ObjectInputStream(client.getInputStream());
			String s1 = null;
			s1 = (String)ib.readObject();

			int i = search(s1);

			if(i!=-1)
				accounts.get(i).afterLogIn(client);
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
	
	
	
	public void Menu()
	{

		TestFile f;
		f = new TestFile();

		while(true)
		{
			try {
				client = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}


			while(true)
			{
				String welcome = "WELCOME TO THE BANK!\n1.Create account\n2.Print account Info\n3.Exit\n";

				try {
					ob = new ObjectOutputStream(client.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					ob.writeObject(welcome);
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					ob.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

				int choice = 0;


				try {
					ib = new ObjectInputStream(client.getInputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					choice = (int)ib.readObject();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}



				if(choice==3) break;
				else if(choice==1) createAccount();
				else if(choice==2) beforeLogIn();

				//System.out.println();
			}

			try {
				ib.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ob.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(client!=null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
