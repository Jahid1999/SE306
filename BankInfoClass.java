package hackathon;

import java.io.Serializable;

public class BankInfoClass implements Serializable
{
	private PersonalInfoClass person;
	private String accNum; 
	private double balance;
	
	public BankInfoClass (PersonalInfoClass person, String accNum, double balance) {

		this.person=person;
		this.accNum = accNum;
		this.balance = balance;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
