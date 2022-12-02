import java.util.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import Exceptions.DriverUnavailable;
import Actors.*;

// Import the packages created 

public class Main {
    public static void main(String[] args) {

        // CabService NewCab = new CabService.getCab();
        // Source start = new Source();
        // Destination end = new Destination();
        // Student student = null;

        // Implementing Switch case for different operations;
        System.out.println(" ");
        System.out.println("Welcome to the Cab Booking System created by Group 3");
        System.out.println("-----------------------------------------------------");
        System.out.println("Available options\n");
        System.out.println("S  - Student registeration and Details");
        System.out.println("T  - Requesting a new Trip");
        System.out.println("C  - Check details of a proposed Trip");
        System.out.println("A  - Accept a Trip");
        System.out.println("R  - Reject a Trip");
        System.out.println("L1 - Admin Login");
        System.out.println("X  - Exit");
        System.out.println("-----------------------------------------------------\n");
        boolean cont = true;
        while (cont) {
            
            System.out.print("Enter an option ");
            Scanner in = new Scanner(System.in);
            char c = in.next().charAt(0);
            int id;
            String name;
            if (c == 'X') {
                System.out.println("Good Bye !!");
                cont = false;
            } else {
                switch (c) {

                    // New User is being registered
                    // Add him in a list
                    case 'S':
                        System.out.println("Enter your name, ID and phone no.");
                        name = in.next();
                        id = in.nextInt();
                        long PhoneNumber = in.nextLong();
                        User NewStudent = new User(name, id, PhoneNumber);
                        NewStudent.ShowDetails();
                        System.out.println("Continue (y/n)...");
                        char test = in.next().charAt(0);
                        if(test!='y'){
                            cont=false;
                        }
                        break;

                    // New trip is getting created
                    // Add it into a List
                    case 'T':
                        System.out.println("Make a new trip (y/n)....");
                        char trip = in.next().charAt(0);
                        if (trip == 'y') {
                            System.out.println("Enter your ID");
                            id = in.nextInt();
                            System.out.println("Enter your date of travel in (dd-mm-yyyy) format");
                            String date = in.next();
                            System.out.println("Enter your source location");
                            String source = in.next();
                            System.out.println("Enter your destination location");
                            String destination = in.next();
                            System.out.println("Enter your departure time in (hh:mm) format");
                            String time_string = in.next();
                            Trip NewTrip = new Trip(id, date, source, destination, time_string);
                            NewTrip.ShowDetails();
                        } else {
                            System.out.println("Good Bye !!");
                            cont = false;
                        }
                        break;

                    case 'C':
                        System.out.println("Enter the ID to view the details of your Trip");

                        // If the ID has an active trip, show the details using showDetails()
                        // How to call that method using the right parameters ??
                        // How to get the parameters using the ID (Getters and Setters)
                        // Appropriate message displayed if ID has no linked travels

                        id = in.nextInt();
                        break;

                    case 'A':
                        System.out.println("Enter your ID to accept a trip");

                        // flag value set to 1 : Accepted trip
                        // showDetails() function call
                        // if user has an active trip, give him option to accept
                        // otherwise proper message : Please create a trip first !!
                        id = in.nextInt();
                        break;

                    case 'R':
                        System.out.println("Enter your ID to reject a trip");
                        // flag value set to 0 : Rejected trip
                        // showDetails() function call
                        // if user has an active trip, give him option to reject
                        // otherwise proper message : Please create a trip first !!
                        id = in.nextInt();
                        break;
                }
                // try{
                // student=CabService.RegisterStudent();
                // }
                // catch{

                // }
            }
        }
    }

}
