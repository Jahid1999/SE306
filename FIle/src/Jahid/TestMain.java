package Jahid;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in);
        int choice;

        while (true){
            System.out.println("-------choice List-----" + "\n");
            System.out.println("1.Insert " + "\n" + "2.Update " + "\n" + "3.Search " + "\n" + "4.Print " + "\n" + "5.Exit " );
            choice = cin.nextInt();
            if(choice==1)
            {
            	Person p = new Person();
                p.insert();
            }
            else if(choice==2)
            {
                

            }
            else if(choice==3){
                String RegNo;
                //RegNo R1 = new RegNo();
                System.out.println("Enter the RegNo: ");
                RegNo = cin.nextLine();
                //R1.search(RegNo);
            }
            else if(choice==4){
               // RegNo R1 = new RegNo();
               // R1.ObjRead();
            }
            else if(choice==5){
                exit(0);
            }
            else System.out.println("Wrong choice!!!!Enter ur choice again---");
        }


	}

	

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

}
