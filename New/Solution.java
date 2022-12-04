import java.util.*;
import java.io.*;

public class Solution{
    //This method checks student user from database
    public static int userAuthentication(String fname, String id, String phone){
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
            if(str[0].equals(fname)&&str[1].equals(id)&&str[2].equals(phone)){
                System.out.println("User already registered. Kindly proceed");
                flag=1;
                outStream.close();
                inStream.close();
                return 0;
            }
            else if(str[1].equals(id)){
                System.out.println("ID already registered with us, please try again! ");
                flag=1;
                outStream.close();
                inStream.close();
                return -1;
            }
        }    
        if(flag==0){
        //outStream.println();
        outStream.println(fname+" "+" "+id+" "+phone);
        System.out.println("New User Registered. Details:");}
        outStream.close();
        inStream.close();
        return 1;
    }
    //This method loads all trips into a hashmap when prgoram starts
    public static HashMap<String,Trip> loadTrips(){
        File[] f=new File("Trips").listFiles();
        HashMap<String, Trip> hm= new HashMap<String,Trip>();
        for(File filename: f){
        Scanner inStream=null;
        try{
            inStream=new Scanner(new FileInputStream(filename));
        }catch(FileNotFoundException e){
            System.out.println("Error Occured");
        }
        String id=inStream.nextLine();
        String date=inStream.nextLine();
        String src=inStream.nextLine();
        String dest=inStream.nextLine();
        String time=inStream.nextLine();
        System.out.println(date+src+dest+time);
        Trip trip=new Trip(date, src, dest, time);
        while(inStream.hasNextLine()){
            String userdata=inStream.nextLine();
            String[] str=userdata.split(" ",10);
            trip.listofTravellers.add(new User(str[0],str[1],str[2]));
        }
        hm.put(id,trip);
        inStream.close();
        }

        return hm;
    }
    //If user rejects a ride, this deletes his name from that ride in the database
    public static void deleteRider(String remove, String filename){
        Scanner inStream=null;
        PrintWriter outStream=null;
        try{
            outStream= new PrintWriter(new FileOutputStream("Trips\\temp.txt",true));
            inStream=new Scanner(new FileInputStream("Trips\\"+filename+".txt.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Error Occured");
        }
        while(inStream.hasNextLine()){
            String str=inStream.nextLine();
            if(!str.equals(remove)){
                outStream.println(str);
            }
        }
        inStream.close();
        outStream.close();
        File file=new File("Trips\\"+filename+".txt.txt");
        file.delete();
        File file1=new File("Trips\\temp.txt");
        file1.renameTo(file);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        Trip.allTrips=loadTrips();    //loading all trip into a hashmap

        System.out.println(" ");
        System.out.println("Welcome to the Cab Booking System created by Group 2");
        System.out.println("-----------------------------------------------------");
        System.out.println("Available options\n");
        System.out.println("S  - Student registeration and Details");
        System.out.println("T  - Requesting a new Trip");               //Needs to be changed so that only S/A mode accessed from here
        System.out.println("C  - Check details of a proposed Trip");
        System.out.println("A  - Accept a Trip");
        System.out.println("R  - Reject a Trip");
        System.out.println("L1 - Admin Login");
        System.out.println("X  - Exit");
        System.out.println("-----------------------------------------------------\n");
        boolean check=true; //Enter/Exit Service
        while(check){
        System.out.println("Enter S or A");
        String str=sc.next();
        //Student Mode
        if(str.equals("S")){
            System.out.println("Enter your name, ID and phone no.");
            String name = sc.next();
            String id = sc.next();
            String PhoneNumber = sc.next();
            System.out.println(name+id+PhoneNumber);
            User NewStudent = new User(name, id, PhoneNumber);
            int good=userAuthentication(name, id, PhoneNumber);

            if(good==-1){
                //System.out.println("ID already registered with us, please try again! ");
                continue;
            }
            else if(good==1){
                //System.out.println("New User Registered. Details:");
                NewStudent.ShowDetails();
            }
            else{
                //System.out.println("User already registered. Kindly proceed");
            }
            boolean cont= true;
            while(cont){
            System.out.println("Enter T/C/A/R"); //new println lines to be added to show what option does what
            //String buffer=sc.nextLine();
            String option=sc.next();
            switch(option){

                    case "T":
                            System.out.println("To book a new ride, enter the details in the following format");
                            System.out.println("<Date(dd-mm-yy)> <Source> <Destination> <Time of Departure>");
                            String p=sc.nextLine();
                            String t=sc.nextLine();
                            String[] arr=t.split(" ",10);
                            String date=arr[0]; String src=arr[1]; String dest=arr[2]; String time=arr[3];
                            Trip newTrip;
                            if(Trip.allTrips.containsKey(time+src+dest+date)){
                                newTrip=Trip.allTrips.get(time+src+dest+date);
                                newTrip.listofTravellers.add(NewStudent);
                                PrintWriter outStream=null;
                                try{
                                outStream=new PrintWriter(new FileOutputStream("Trips\\"+time+src+dest+date+".txt.txt",true));
                                }catch(FileNotFoundException e){
                                    System.out.println("Error Occured");
                                }
                                
                                outStream.println(name+" "+id+" "+PhoneNumber);
                                 outStream.close(); 
                                System.out.println("Trip Already Exists. Assigned as a co-traveller");                         
                            }
                            else{
                                newTrip=new Trip(date,src,dest,time);
                                newTrip.listofTravellers.add(NewStudent);
                                Trip.allTrips.put(time+src+dest+date,newTrip);
                                PrintWriter outStream=null;
                                try{
                                outStream=new PrintWriter(new FileOutputStream("Trips\\"+time+src+dest+date+".txt.txt",true));
                                }catch(FileNotFoundException e){
                                    System.out.println("Error Occured");
                                }
                                outStream.println(time+src+dest+date); outStream.println(date); outStream.println(src); outStream.println(dest); outStream.println(time);
                                
                                outStream.print(name+" "+id+" "+PhoneNumber);
                                outStream.close(); 
                                System.out.println("New Ride Created");
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test1 = sc.next().charAt(0);
                            if(test1=='N'){
                                 cont=false;
                            }
                            break;
                    case "C": 
                            String ctripid=sc.next();
                            if(Trip.allTrips.containsKey(ctripid)){
                                Trip checkTrip=Trip.allTrips.get(ctripid);
                                checkTrip.getTripDetails();
                            }
                            else{
                                System.out.println("Ride ID incorrect!");
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test2 = sc.next().charAt(0);
                            if(test2=='N'){
                                 cont=false;
                            }
                            break;
                    case "A":
                            String atripid=sc.next();
                            if(!Trip.allTrips.containsKey(atripid)){
                                System.out.println("Ride ID incorrect!");
                            }
                            else{
                                Trip acceptTrip=Trip.allTrips.get(atripid);
                                System.out.println(acceptTrip.listofTravellers);

                                if(acceptTrip.listofTravellersContains(NewStudent))
                                {
                                    acceptTrip.getTripDetails();
                                    System.out.println("Ride Accepted");
                                }
                                else{
                                    System.out.println("You are not currently assigned as a co-traveller in this ride");
                                }
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test3 = sc.next().charAt(0);
                            if(test3=='N'){
                                 cont=false;
                            }
                            break;
                    case "R":
                            String rtripid=sc.next();
                            if(!Trip.allTrips.containsKey(rtripid)){
                                System.out.println("Ride ID incorrect!");
                            }
                            else{
                                Trip rejectTrip=Trip.allTrips.get(rtripid);
                                System.out.println(rejectTrip.listofTravellers);
                                if(rejectTrip.listofTravellersContains(NewStudent))
                                {
                                    rejectTrip.listofTravellers.removeIf(n->n.equals(NewStudent));
                                    System.out.println("Ride Rejected");
                                    deleteRider(name+" "+id+" "+PhoneNumber,rtripid);
                                }
                                else{
                                    System.out.println("You are not currently assigned as a co-traveller in this ride");
                                }
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test4 = sc.next().charAt(0);
                            if(test4=='N'){
                                 cont=false;
                            }
                            break;
                    default: 
                            System.out.println("Choose a valid option");
                            System.out.println("Continue? (Y/N)...");
                            char test5 = sc.next().charAt(0);
                            if(test5=='N'){
                                 cont=false;
                            }
                            break;

                   }//End of T/C/A/R switch
            }  
        
        }//End of Student Mode


        //Admin mode code from here
        else{

        }
        System.out.println("Continue(choose another mode)? (Y/N)...");
                            char test6 = sc.next().charAt(0);
                            if(test6=='N'){
                                check=false;
                            }
    }
    //End of While Check Loop
    //End of solution/main

    sc.close();
}
}
