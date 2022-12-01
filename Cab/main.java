import java.util.*
import java.util.Scanner;

import cab.exceptions;
import cab.actors;

// Import the packages created 

public class main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CabService NewCab = new CabService.getCab();
        Source start = new Source();
        Destination end = new Destination();
        Student student = null;
        
        // Implementing Switch case for different operations;
        
        System.out.println("Enter an option");
        char c = in.next().charAt(0);
        
        Switch(c){
            
        }
        
        try{
            student=CabService.RegisterStudent();
        }
        catch{
            
        }
    }
}
