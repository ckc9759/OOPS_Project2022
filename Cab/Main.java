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

            // New User is being registered 
            // Add him in a list
            case 'S': System.out.println("Enter your name, ID and phone no.");
            name = in.next();
            id=in.nextInt();
            long PhoneNumber=in.nextLong();
            User NewStudent = new User(name,id,PhoneNumber);
            NewStudent.ShowDetails();
            break;


            // New trip is getting created 
            // Add it into a List
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

            case 'C':System.out.println("Enter the ID to view the details of your Trip");

            // If the ID has an active trip, show the details using showDetails()
            // How to call that method using the right parameters ??
            // How to get the parameters using the ID (Getters and Setters)
            // Appropriate message displayed if ID has no linked travels

            id=in.nextInt();
            break;

            case 'A':System.out.println("Enter your ID to accept a trip");

            // flag value set to 1 : Accepted trip
            // showDetails() function call
            // if user has an active trip, give him option to accept
            // otherwise proper message : Please create a trip first !!
            id=in.nextInt();
            break;

            case 'R':System.out.println("Enter your ID to reject a trip");
            // flag value set to 0 : Rejected trip
            // showDetails() function call
            // if user has an active trip, give him option to reject
            // otherwise proper message : Please create a trip first !!
            id=in.nextInt();
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
