import java.util.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import Exceptions.DriverUnavailable;
import Actors.*;

// Import the packages created 

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // CabService NewCab = new CabService.getCab();
        // Source start = new Source();
        // Destination end = new Destination();
        // Student student = null;
        
        // Implementing Switch case for different operations;
    
        System.out.println("Enter an option");
        char c = in.next().charAt(0);
        int id;
        String name;
        switch(c){

            case 'S': System.out.println("Enter your name, ID and phone no.");
            name = in.next();
            id=in.nextInt();
            long PhoneNumber=in.nextLong();
            User NewStudent = new User(name,id,PhoneNumber);
            NewStudent.ShowDetails();
            break;

            case 'T':System.out.println("Make a new trip (y/n)....");
            char trip=in.next().charAt(0);
            if(trip=='y'){
                System.out.println("Enter your ID");
                id=in.nextInt();
                System.out.println("Enter your date of travel in (dd-mm-yyyy) format");
                String date=in.next();
                System.out.println("Enter your source location");
                String source=in.next();
                System.out.println("Enter your destination location");
                String destination=in.next();
                System.out.println("Enter your departure time in (hh:mm) format");
                String time_string=in.next();
                Trip NewTrip = new Trip(id,date,source,destination,time_string);
                NewTrip.ShowDetails();
            }
            else{
                System.out.println("Good Bye !!");
            }
            break;
        }
        in.close();
        // try{
        //     student=CabService.RegisterStudent();
        // }
        // catch{
            
        // }
    }
}
