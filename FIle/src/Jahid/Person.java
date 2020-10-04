package Jahid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Person 
{
	private String name;
	private String fatherName;
	private String motherName;
	private String address;
	private String registrationNumber;
	private String nidNumber;
	private String DOB;
	
	private String FILENAME = "personal.txt";
	
	 Scanner cin = new Scanner(System.in);
	
	public Person(){

    }

    public Person(String registrationNumber, String name, String fatherName, String motherName,String address,String nidNumber, String DOB)
    {
        this.registrationNumber=registrationNumber;
    	this.name = name;
        this.fatherName=fatherName;
        this.motherName=motherName;
        this.address=address;
        this.nidNumber=nidNumber;
        this.DOB=DOB;
    }
    
    public void setReg(String registrationNumber)
    {
    	this.registrationNumber=registrationNumber;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public void setFatherName(String fatherName) 
    {
        this.fatherName = fatherName;
    }
    
    public void setMotherName(String motherName) 
    {
        this.motherName= motherName;
    }
	
    public void setAddress(String address) 
    {
        this.address = address;
    }
    
    public void setBirthDate(String DOB) 
    {
        this.DOB = DOB;
    }
	
    public String getReg()
    {
		return registrationNumber;
    	
    }
    
    public void insert()
    {
    	System.out.println("Enter registration number: ");
    	registrationNumber = cin.nextLine();
    	
    	System.out.println("Enter  name: ");    	
    	name = cin.nextLine();
    	
    	System.out.println("Enter  father's name: ");    	
    	fatherName = cin.nextLine();
    	
    	System.out.println("Enter mother's name: ");    	
    	motherName = cin.nextLine();
    	
    	System.out.println("Enter address: ");    	
    	address = cin.nextLine();
    	
    	System.out.println("Enter nid number: ");    	
    	nidNumber = cin.nextLine();
    	
    	System.out.println("Enter Birth Date: ");    	
    	DOB = cin.nextLine();
    	
    	writeToFile_BufferWriter();
    	
    	
    }
    

	
	public void  writeToFile_BufferWriter() {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = registrationNumber+','+name+','+fatherName+','+motherName+','+DOB+','+nidNumber+','+address;

			//open filewriter as write mode
			fw = new FileWriter(FILENAME);
			
			//open filewriter as append mode
//			fw = new FileWriter(FILENAME, true);
			
			
			bw = new BufferedWriter(fw);
			bw.flush();
			
			bw.write(content);

			System.out.println("Write Done" + content);
			
			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void listOfDirectory() {
		File file = null;
	      String[] paths;
	  
	      try {      
	         // create new file object
	         file = new File("/home/abdullah-al-jahid/Desktop/OOP");

	         // array of files and directory
	         paths = file.list();

	         // for each name in the path array
	         for(String path:paths) {
	            // prints filename and directory name
	            System.out.println(path);
	         }
	      }catch(Exception e) {
	         // if any error occurs
	         e.printStackTrace();
	      }
	}
   
    
    
}
