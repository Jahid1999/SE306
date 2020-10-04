package assignment;

import java.io.Serializable;

public class Bank implements Serializable{

	private String acctyp;
	public String accNum; 
	private double balance;
	
	public Bank (String accNum, String acctyp, double balance) {

		this.accNum = accNum;
		this.acctyp = acctyp;
		this.balance = balance;
	}

	public double getBalance() 
	{
		return balance;
	}
	
	@Override
	public String toString() 
	{
		return ("Account type: " + this.acctyp+'\n');
	}

}