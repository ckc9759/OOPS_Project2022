import java.util.*;
import java.util.Scanner;

import Exceptions.DriverUnavailable;
import Actors.User;

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
        switch(c){
            case 'S': System.out.println("Enter your name, ID and phone no.\n");
            String name = in.next();
            int id=in.nextInt();
            int PhoneNumber=in.nextInt();
            User NewStudent = new User(name,id,PhoneNumber);
            NewStudent.ShowDetails();
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
