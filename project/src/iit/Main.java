package iit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private Search search = new Search();

    ServerSocket serverSocket;
    Socket socket;
    
    DataInputStream din;
    DataOutputStream dout;



    public Main() throws IOException
    {
        System.out.println("Welcome to IIT home page.");

        serverSocket = new ServerSocket(4569);
        socket = new Socket();
        socket = serverSocket.accept();
        System.out.println("connected");

        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());

    }

    public void login() throws IOException
    {
        dout.writeUTF("Registration number : ");
        String reg = din.readUTF();
        System.out.println("client says : " + reg);
        String str1="", str2 = "";
        search.setFile("academic.txt");

        if(search.SearchInFile(reg)!=null)
        {
            dout.writeUTF("your information is valid");

            dout.writeUTF("enter your account number : ");
            String number = din.readUTF();
            System.out.println("client says : " + number);

            dout.writeUTF("enter your account password : ");
            String pin = din.readUTF();
            System.out.println("client says : " + pin);

            search.setFile("account.txt");
            String s1 = search.SearchInFile(number);
            String s2 = search.SearchInFile(pin);

            if(s1 != null && s2 != null)
            {
                String[] temp = s1.split(",");

                if(!s1.contains(temp[0]) || !s1.contains(temp[1]) || !reg.equals(temp[3]))
                {
                    dout.writeUTF("login failed");

                }

                else
                {
                    while(true)
                    {
                        dout.writeUTF("\n1. get certificate\n2. cash in\n3. cash out\n4. check balance\n0. back\n");
                        str1 = din.readUTF();
                        System.out.println("client says : " + str1);

                        if(str1.equals("1"))
                        {

                            double balance = Double.parseDouble(temp[2]);
                            dout.writeUTF("your current balance is " + balance);

                            if(balance < 100)
                            {
                                dout.writeUTF("insufficient balance");
                            }

                            else
                            {
                                balance -= 100;
                                dout.writeUTF("100 taka has been taken from your account");
                                String newTxt = temp[0] + "," +temp[1] + "," + Double.toString(balance) + ","+ temp[3];
                                Replace rp = new Replace("account.txt");
                                rp.replace(s1, newTxt);

                                Certificate c = new Certificate();
                                c.writeCertificate(temp[3]);

                                dout.writeUTF("now check this file " + "certificate-" + temp[3] + ".txt\n\n");

                            }

                        }

                        else if(str1.equals("6"))
                        {
                            Search searchit = new Search("academic.txt");
                            String temp2 = searchit.SearchInFile(temp[3]);

                            String[] words = temp2.split(",");

                            dout.writeUTF("found!!!\n\n");
                            dout.writeUTF("registration number: " + words[0] + "\n");
                            dout.writeUTF("session: " + words[1] + "\n");
                            dout.writeUTF("semester: " + words[2] + "\n");
                            dout.writeUTF("year: " + words[3] + "\n");
                            dout.writeUTF("cgpa: " + words[4] + "\n");
                            dout.writeUTF("class-roll: " + words[5] + "\n\n");
                            //dout.writeUTF("\n\n\n");
                        }

                        else if(str1.equals("2"))
                        {
                            dout.writeUTF("enter amount: ");
                            str2 = din.readUTF();
                            double amount = Double.parseDouble(str2);

                            if(amount < 0 )
                            {
                                dout.writeUTF("operation can't be done");

                            }

                            else
                            {
                                amount += Double.parseDouble(temp[2]);
                                String newTxt = temp[0] + "," +temp[1] + "," + Double.toString(amount) + ","+ temp[3];
                                Replace rp = new Replace("account.txt");
                                rp.replace(s1, newTxt);

                                dout.writeUTF("operation has successfully done");

                            }
                        }

                        else if(str1.equals("3"))
                        {
                            dout.writeUTF("enter amount: ");
                            str2 = din.readUTF();
                            double amount = Double.parseDouble(str2);
                            double balance = Double.parseDouble(temp[2]);

                            if(amount < 0 || amount > balance)
                            {
                                dout.writeUTF("operation can't be done");

                            }

                            else
                            {
                                balance -= amount;
                                String newTxt = temp[0] + "," +temp[1] + "," + Double.toString(balance) + ","+ temp[3];
                                Replace rp = new Replace("account.txt");
                                rp.replace(s1, newTxt);

                                dout.writeUTF("operation has successfully done");

                            }
                        }

                        else if(str1.equals("4"))
                        {
                            dout.writeUTF("your current balance is " + temp[2]);
                        }

                        else
                        {
                            break;
                            
                        }

                    }
                }
            }

            else
            {
                dout.writeUTF("failed");

            }
        }

        else
        {
            dout.writeUTF("invalid registration number");

        }


    }

    public void signup() throws IOException
    {
        dout.writeUTF("enter academic info in format -\n (reg, session, semester, year, cgpa, roll) without spaces:");
        String academic = din.readUTF();
        String [] s = academic.split(",");

        dout.writeUTF("enter personal info in format -\n (name, f-name, m-name, nid, address) without spaces:");
        String personal = din.readUTF();
        personal += "," + s[0];

        dout.writeUTF("enter account info in format -\n (pin, balance) without spaces:");
        String account =s[5] + "," + din.readUTF() + "," + s[0];

        ManualFileWriter file = new ManualFileWriter("academic.txt");
        file.writeToFile(academic, true);

        file.setFile("person.txt");
        file.writeToFile(personal, true);

        file.setFile("account.txt");
        file.writeToFile(account, true);

        dout.writeUTF("account has been successfully created\n");
        dout.writeUTF("your account number is: ac-" + s[5]);
    }



    public static void main(String[] args) throws Exception
    {
    	
        Main server = new Main();
        String str1="", str2="";

        while(true)
        {
            server.dout.writeUTF("\n1.Sing In\n2.Sign Up\n3. exit\n");
            str1 = server.din.readUTF(); 
            System.out.println("client says : " + str1);

            if(str1.equals("1"))
            {
                server.login();
            }

            else if(str1.equals("2"))
            {
                server.signup();
            }

            else if(str1.equals("3"))
            {
                System.out.println("\nok from server");
                break;
            }


        }

        server.din.close();
        server.dout.close();
        server.socket.close();

        System.out.println("ok from server");


    }
}





