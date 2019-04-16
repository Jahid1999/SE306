package hackathon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class FunctionsClass{
	
	private String name;
	private String Faname;
	private String Maname;
	private String DOB;
	private String adr;
	private String phn;
	private String regNo;
	private String accNum;
	private String password;
	private double cg;
	private String semester;
	private String year;
	double balance;
	String adminpass="admin12345";
	
	private ArrayList<PersonalInfoClass> listPerson= new ArrayList<>();
	private ArrayList<AcademicInfoClass> listAcademy= new ArrayList<>();
	private ArrayList<BankInfoClass> listBank= new ArrayList<>();
	
	Scanner cin= new Scanner(System.in);
	
	public void initialize() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File newFile= new File("personal.txt");
		
		if(newFile.length()==0) return; 
		
		ObjectInputStream PersObj= new ObjectInputStream(new FileInputStream("personal.txt"));
		ObjectInputStream BankObj= new ObjectInputStream(new FileInputStream("bankInfo.txt"));
		ObjectInputStream AcaObj= new ObjectInputStream(new FileInputStream("acaInfo.txt"));
		
		listPerson= (ArrayList<PersonalInfoClass>) PersObj.readObject();
		listBank=(ArrayList<BankInfoClass>) BankObj.readObject();
		listAcademy=(ArrayList<AcademicInfoClass>) AcaObj.readObject();
		
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
		
		System.out.println("Enter Father's name: ");
		Faname=cin.nextLine();
		
		System.out.println("Enter Mother's name: ");
		Maname=cin.nextLine();
		
		System.out.println("Enter current year: ");
		year=cin.nextLine();
		
		System.out.println("Enter current semester: ");
		semester=cin.nextLine();
		
		System.out.println("Enter Account Number: ");
		accNum=cin.nextLine();
		
		System.out.println("Enter registration number: ");
		regNo=cin.nextLine();
		
		System.out.println("Enter password: ");
		password=cin.nextLine();
		
		System.out.println("Enter CGPA: ");
		cg=cin.nextDouble();
		
		System.out.println("Enter Account Balance: ");
		balance=cin.nextDouble();
		
		PersonalInfoClass persona= new PersonalInfoClass(name,Faname,Maname,adr,DOB,regNo);
		AcademicInfoClass aca= new AcademicInfoClass(regNo,semester,year,cg,password);
		BankInfoClass ban=new BankInfoClass(accNum,persona,balance);
		
		if(checkPassword(password))
		{
			listPerson.add(persona);
			listAcademy.add(aca);
			listBank.add(ban);
			writer(listPerson,listAcademy,listBank);
		}
		
		else
			System.out.println("Invalid password\n");
			
	}
	
	
	public boolean checkPassword(String pass)
	{
		String pat=".{8,15}$";
		
		Pattern r = Pattern.compile(pat);
		Matcher m = r.matcher(pass);
		
		if(m.find()) return true ;
		else return false;
		
		
	}
	
	public void writer(ArrayList<PersonalInfoClass> listPerson,ArrayList<AcademicInfoClass> listAcademy,ArrayList<BankInfoClass> listBank) {
		
		FileOutputStream fout = null;
	    ObjectOutputStream object_out_for_serializable = null;
	        
	    try {
	            fout = new FileOutputStream("persnal.txt");
	            object_out_for_serializable = new ObjectOutputStream(fout);
	            
	            object_out_for_serializable.writeObject(listPerson);
	            object_out_for_serializable.flush();
	            
	            fout = null;
	    	    object_out_for_serializable = null;
	    	    
	    	    fout = new FileOutputStream("acaInfo.txt");
	            object_out_for_serializable = new ObjectOutputStream(fout);
	            
	            object_out_for_serializable.writeObject(listBank);
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
	
	
	
	
	public int searchByReg (String s)
	{	
		for(int i=0;i<listAcademy.size();i++)
		{	
			String s4 = listAcademy.get(i).getRegNo();
			if(s4.equals(s))
			{	
				return i;
			}
		}
		return -1;
	}
	
	
	public int searchByPass (String s)
	{	
		for(int i=0;i<listAcademy.size();i++)
		{	
			String s4 = listAcademy.get(i).getRegNo();
			if(s4.equals(s))
			{	
				return i;
			}
		}
		return -1;
	}
	
	public ArrayList<PersonalInfoClass> getAccounts() {
		return listPerson;
	}
	
	
	public void beforeLogIn()
	{
		Scanner cin = new Scanner (System.in);
		
		System.out.print("\n1.Admin\t2.Student ");
		 int c=cin.nextInt();
		 
		 if(c==1)
		 {
			 System.out.print("\nEnter password");
			 String s3=cin.nextLine();
			 if(s3.equals(adminpass))
			 {
				 afterLogInAdmin();
			 }
				 
			 
		 }
		 
		 else if(c==2)
		 {
			 System.out.println("Enter registration number:");
			 
			 String s3=cin.nextLine();
			 System.out.print("\nEnter password:");
			 String s4=cin.nextLine();
			 
			 int i = searchByReg(s3);
			 int j = searchByPass(s3);
			 
			 if(i!=-1 && j!=-1) 
				 
			{
				 listPerson.get(i).afterLogIn();
				 writeToFile();
			}
			 

			 else System.out.println("\nInvalid Password or RegNum\n");
		 }
		
		
	}
	
	public void afterLogInAdmin()
	{
		createAccount();
		
	}
	
private String filename = "bankInfo.txt";
	
	public void  writeToFile() 
	{
		FileOutputStream fout = null;
        ObjectOutputStream object_out_for_serializable = null;
        try 
        {
            fout = new FileOutputStream(filename);
            object_out_for_serializable = new ObjectOutputStream(fout);
            
            object_out_for_serializable.writeObject("\t\tSTUDENTSHIP CERTIFICATE\n\t\t\tIIT_DU\nThis is to certify that"+listPerson.get(i).getName + "son of "+listPerson.get(i).getFN+"and "+listPerson.get(i).getMN +"currently studying in"+listPerson.get(i).getsemster+" semester"+listPerson.get(i).getyear+" year at IIT_DU. His/Her CGPA is "+listPerson.get(i).getCgpa);
            object_out_for_serializable.flush();
                    
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
	
	
	
}
