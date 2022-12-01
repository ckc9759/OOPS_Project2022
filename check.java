import java.io.*;
import java.util.*;

public class check{
    public static void main(String[] args) {
        boolean run =true;
        while(run)
        Scanner sc=new Scanner(System.in);
        String fname=sc.next();
        String lname=sc.next();
        String id=sc.next();
        String phone=sc.next();
        //System.out.println(fname+" "+lname+" "+id+" "+phone+" ");
        Scanner inStream=null;
        PrintWriter outStream=null;
        try{
            outStream= new PrintWriter(new FileOutputStream("UsersFile.txt",true));
            inStream=new Scanner(new FileInputStream("UsersFile.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Error Occured");
        }
        int flag=0;
        while(inStream.hasNextLine()){
            String[] str=inStream.nextLine().split(" ",5);
            //System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]);
            if(str[0].equals(fname)&&str[1].equals(lname)&&str[2].equals(id)&&str[3].equals(phone)){
                System.out.println(fname+" "+lname+" Logged In");
                flag=1;
                run=false;
                break;
            }
            else if(str[2].equals(id)){
                System.out.println("ID already present, Match other credentials");
                flag=1;
                break;
            }
        }    

        if(flag==0){
            outStream.println(fname+" "+lname+" "+id+" "+phone);
            System.out.println("\nNew User Registered. Details:");
            System.out.println("Name: "+fname+" "+lname+" ID: "+id+" Phone NO. "+phone);
        }
        outStream.close();
        inStream.close();

        

    }
}
