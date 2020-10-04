package Jahid;

import java.io.*;
import java.util.Scanner;


public class MainClass {
	 
	    String sCurrentLine;
	    String[] arrOfStr =null;
	    static  BufferedReader br = null;
	    static BufferedReader braca = null;
	    String n=null;
	    
	    private static String name;
		private static String fatherName;
		private static String motherName;
		private static String address;
		private static String registrationNumber;
		private static String nidNumber;
		private static String DOB;
		private static String session;
		private static String semester;
		private static String year;
		private static String cgpa;

    public static void main(String[] args) throws IOException 
    {
    	
    	File file1=new File("Personall.txt");
	    File file2=new File("Academic.txt");
	    
    	 BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
         BufferedWriter bwaca=new BufferedWriter(new FileWriter(file2));
        

         bw.write("1030,jahid,saiful islam,anzana begum,19-06-1999,121088,tongi");
         bw.newLine();
         bwaca.write("1030,2017-18,3,2,3.92");
         bwaca.newLine();
         bw.write("1006,yasin,acb,sdf,12-11-1998,121034,jigatola");
         bw.newLine();
         bwaca.write("1006,2017-18,3,2,3.96");
         bwaca.newLine();
         bw.close();
         bwaca.close();
        
         Scanner cin = new Scanner(System.in);
         int k=0;
         String[] arrOfStr =null;

         String n=null,sCurrentLine=null;
         while(true)
         {
        	 System.out.println("What u want  to do \n1.Search \n2.Insert \n3.Exit");
        	 k=cin.nextInt();
        	 
        	 if(k==1)
        	 {
        		 br = new BufferedReader(new FileReader(file1));
     	        braca = new BufferedReader(new FileReader(file2));

        		 System.out.println("Give registration number:");
        		 n=cin.nextLine();
        		 n=cin.nextLine();

        	 
        		 
        	        System.out.println("Personal information:");
        	       try
        	       {
	        	        while ((sCurrentLine = br.readLine()) != null) 
	        	        {
	        	            arrOfStr = sCurrentLine.split(",", 10);
	        	          
	        	            if (arrOfStr[0].equals(n))
	        	            {
	        	            	for (String a : arrOfStr)
	        	                    System.out.println(a);
	        	    
	        	            }
	        	            arrOfStr=null;
	        	            
	        	        }
        	       }
        	        
        	        catch (IOException e) 
        	        {
        	            e.printStackTrace();
        	        }
        	        
        	        System.out.println("Acamedic information:");
        	        
        	        try
        	        {
	        	        while ((sCurrentLine = braca.readLine()) != null)
	        	        {
	        	            arrOfStr =sCurrentLine.split(",",10);
	        	           
	        	            if(arrOfStr[0].equals(n))
	        	            {
	        	                for (String a : arrOfStr)
	        	                    System.out.println(a);
	        	            }
	        	            arrOfStr=null;
	
	
	        	        }
        	        

        	        } 
        	        catch (IOException e) 
        	        {
        	            e.printStackTrace();
        	        }
        	 
        	br.close();
        	braca.close();
        	 
        	 
        	 }
        	 
        	 else if(k==2)
        	 {	
        		  bw=new BufferedWriter(new FileWriter(file1,true));
             	  bwaca=new BufferedWriter(new FileWriter(file2,true));
             
        		 
        		 System.out.println("Personal Information: ");
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
        	    	
        		    System.out.println("Academic Information: ");

        		    System.out.println("Enter session: ");    	
     	    	    session= cin.nextLine();
     	    	 
        		    System.out.println("CGPA: ");
        		    cgpa=cin.nextLine();
        		  
        		    System.out.print("Current semester: ");
        		    semester=cin.nextLine();
        		 
        		    System.out.print("Current year: ");
        		    year=cin.nextLine();
        		 
        		 br = new BufferedReader(new FileReader(file1));
        		 int r=0;
        		 
        		 while ((sCurrentLine = br.readLine()) != null) 
     	        {
     	            arrOfStr = sCurrentLine.split(",", 10);
     	            
     	            if (arrOfStr[0].equals(registrationNumber))
     	            {
     	            	System.out.println("registration number Matched...\n1.enter new registration number \t2.Go Home");
     	            	 r=cin.nextInt();
     	            	if(r==1)
     	            	{
     	            		registrationNumber=cin.nextLine();
     	            		registrationNumber=cin.nextLine();

         	            	br.close();
         	        		br = new BufferedReader(new FileReader(file1));         	
     	            	}
     	            	
     	            	else
     	            	{
     	            		br.close();
     	            		break;
     	            	}	            	
     	    
     	            }
     	            
     	            
     	        }
        		 
        		 
        		 if(r!=2)
        		 {
        			 String person=registrationNumber+','+name+','+fatherName+','+motherName+','+DOB+','+nidNumber+','+address;
	        		 System.out.println(person);
	        		 String academic=registrationNumber+","+session+","+semester+","+year+","+cgpa;
	        		 bw.append(person);
	        		 bwaca.append(academic);
	        		 bw.close();
	                 bwaca.close();
	                 System.out.println("Registration completed");

 
        		 } 		
        	 
        	 }
        	 
        	 else if(k==3)
        	 {
                 break;
        	 }
         }
    
         
	 
		
		
	
    
    
    }
}