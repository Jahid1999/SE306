package iit;


import java.io.*;

public class Certificate {

    private String file = "person.txt";
    
    private String certificate = "";

    public Certificate()
    {

    }

    public void writeCertificate(String st) throws IOException {

        String cfile = "certificate-" + st + ".txt";
        Search search_a = new Search("academic.txt");
        Search search_p = new Search("person.txt");
        String str_a = search_a.SearchInFile(st);
        String str_p = search_p.SearchInFile(st);
        System.out.println(str_a);
        System.out.println(str_p);
        printAcademicInfo(cfile, str_a, str_p);

    }

    public void printAcademicInfo(String cfile, String academic, String person) throws IOException {

    	ManualFileWriter file = new ManualFileWriter(cfile);
        
        String [] words_a = academic.split(",");
        String[] words_p = person.split(",");

        certificate += "\t\t\t\t\t\t\t\t\t\t\t\t\tInstitute of Information Technology\n";
        certificate += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUniversity of Dhaka\n\n";
        certificate += "This is to certify that ";
        certificate += words_p[0]+", son of "+words_p[1]+" and "+words_p[2]+" ";
        certificate += "registration number: "+ words_a[0]+" ";
        certificate += "session: "+ words_a[1]+" ";
        certificate += "semester: "+ words_a[2]+" ";
        certificate += "year: "+ words_a[3]+" ";
        //bw1.write("cgpa: "+ words_a[4]+"\n");
        certificate += "class-roll: "+ words_a[5]+" ";
        certificate += "is a regular student of  IIT, University of Dhaka. He/she obtained CGPA  ";
        certificate +=  words_a[4]+" till now.\n";
        certificate += "I wish him/her every success in life.\n\n";
        certificate += "Dr. Md. Shariful Islam\n";
        certificate += "       (Director)\n";
      
        file.writeToFile(certificate, false);
        
    }

    public void printPersonalInfo(String cfile, String content)  throws IOException
    {
        /*fw = new FileWriter(cfile,true);
        bw = new BufferedWriter(fw);
        bw.flush();
        bw.write("_________________Personal Information_________________"+"\n\n");
        String [] words = content.split(",");
        bw.write("name: "+ words[0]);
        bw.write("father's name: "+ words[1]);
        bw.write("mother's name: "+ words[2]);
        bw.write("nid: "+ words[3]);
        bw.write("address: "+ words[4]);
        bw.write("\n");*/


    }
}