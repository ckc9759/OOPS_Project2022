package Service;

import java.util.*;
import java.io.*;

import Actor.*;
import Fare.Fares;
import Exceptions.*;

public class Main {
    // This method checks student user from database
    public static int userAuthentication(String fname, String id, String phone) {
        Scanner inStream = null;
        PrintWriter outStream = null;
        try {
            outStream = new PrintWriter(new FileOutputStream("UsersFile.txt", true));
            inStream = new Scanner(new FileInputStream("UsersFile.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
        }
        int flag = 0;
        while (inStream.hasNextLine()) {
            String[] str = inStream.nextLine().split(" ", 5);
            // System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]);
            if (str[0].equals(fname) && str[1].equals(id) && str[2].equals(phone)) {
                System.out.println("User already registered. Kindly proceed");
                flag = 1;
                outStream.close();
                inStream.close();
                return 0;
            } else if (str[1].equals(id)) {
                System.out.println("ID already registered with us, please try again! ");
                flag = 1;
                outStream.close();
                inStream.close();
                return -1;
            }
        }
        if (flag == 0) {
            // outStream.println();
            outStream.println(fname + " " + id + " " + phone);
            System.out.println("New User Registered. Details:");
        }
        outStream.close();
        inStream.close();
        return 1;
    }

    // This method loads all trips into a hashmap when prgoram starts
    public static HashMap<String, Trip> loadTrips() {
        File[] f = new File("Trips").listFiles();
        HashMap<String, Trip> hm = new HashMap<String, Trip>();
        for (File filename : f) {
            Scanner inStream = null;
            try {
                inStream = new Scanner(new FileInputStream(filename));
            } catch (FileNotFoundException e) {
                System.out.println("Error Occured");
            }
            String id = inStream.nextLine();
            String date = inStream.nextLine();
            String src = inStream.nextLine();
            String dest = inStream.nextLine();
            String time = inStream.nextLine();
            Trip trip = new Trip(date, src, dest, time);
            while (inStream.hasNextLine()) {
                String userdata = inStream.nextLine();
                String[] str = userdata.split(" ", 10);
                trip.listofTravellers.add(new User(str[0], str[1], str[2]));
            }
            hm.put(id, trip);
            inStream.close();
        }

        return hm;
    }

    // If user rejects a ride, this deletes his name from that ride in the database
    public static void deleteRider(String remove, String filename) {
        Scanner inStream = null;
        PrintWriter outStream = null;
        try {
            outStream = new PrintWriter(new FileOutputStream("Trips\\temp.txt", true));
            inStream = new Scanner(new FileInputStream("Trips\\" + filename + ".txt.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
        }
        while (inStream.hasNextLine()) {
            String str = inStream.nextLine();
            if (!str.equals(remove)) {
                outStream.println(str);
            }
        }
        inStream.close();
        outStream.close();
        File file = new File("Trips\\" + filename + ".txt.txt");
        file.delete();
        File file1 = new File("Trips\\temp.txt");
        file1.renameTo(file);
    }

    // Admin Authentication
    public static boolean adminAuthentication(String name, String password) {
        Scanner inStream = null;
        try {
            inStream = new Scanner(new FileInputStream("AdminFile.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured");
        }
        int flag = 0;
        while (inStream.hasNextLine()) {
            String[] str = inStream.nextLine().split(" ", 5);
            // System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]);
            if (str[0].equals(name) && str[1].equals(password)) {
                System.out.println("Welcome admin " + name);
                flag = 1;
                inStream.close();
                return true;
            }
        }
        if (flag == 0) {
            System.out.println("Wrong Username/Password!");
            System.out.println("Please try again");
        }
        inStream.close();
        return false;
    }

    public static void validateDateFormat(String date) throws DateFormatException {
        if (date.length() != 8 || ((date.charAt(2) != '-') && (date.charAt(5) != '-'))) {
            throw new DateFormatException("Invalid Date format!! Try again");
        }
    }

    public static void validateCity(String city) throws ValidCityException {
        if (!((city.equals("Pilani")) || (!city.equals("Delhi")) || (!city.equals("Jaipur")))) {
            throw new ValidCityException(city + " is not currently serviced by us");
        }
    }

    public static void validateTime(String time) throws ValidTimeException {
        if (!time.contains("PM")) {
            throw new ValidTimeException("Wrong time format, enter time with PM/AM in Upper Case");
        } else if(!((time.equals("2PM"))||(time.equals("3PM"))||(time.equals("4PM"))||(time.equals("5PM")))){
            throw new ValidTimeException("We only provide cabs at 2PM/3PM/4PM/5PM");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Trip.allTrips = loadTrips(); // loading all trip into a hashmap

        System.out.println(" ");
        System.out.println("Welcome to the Cab Booking System created by Group 2");
        System.out.println("-----------------------------------------------------");
        System.out.println("Available options\n");
        System.out.println("S  - Student Registration and Details");
        System.out.println("L1 - Admin Login");
        System.out.println("X  - Exit");
        System.out.println("-----------------------------------------------------\n");
        boolean check = true; // Enter/Exit Service
        while (check) {
            System.out.println("Enter S, L1 or X");
            String str = sc.next();
            // Student Mode
            if (str.equals("S")) {
                System.out.println("Enter your name, ID and phone no.");
                String name = sc.next();
                String id = sc.next();
                String PhoneNumber = sc.next();
                User NewStudent = new User(name, id, PhoneNumber);
                int good = userAuthentication(name, id, PhoneNumber);

                if (good == -1) {
                    // System.out.println("ID already registered with us, please try again! ");
                    continue;
                } else if (good == 1) {
                    // System.out.println("New User Registered. Details:");
                    NewStudent.ShowDetails();
                } else {
                    // System.out.println("User already registered. Kindly proceed");
                }
                boolean cont = true;
                while (cont) {
                    System.out.println("Enter one of the following options");
                    System.out.println("T  - Requesting a new Trip");
                    System.out.println("C  - Check details of a proposed Trip");
                    System.out.println("A  - Accept a Trip");
                    System.out.println("R  - Reject a Trip");
                    // String buffer=sc.nextLine();
                    String option = sc.next();
                    switch (option) {

                        case "T":
                            System.out.println("To book a new ride, enter the details in the following format");
                            System.out.println("<Date(dd-mm-yy)> <Source> <Destination> <Time of Departure>");
                            String p = sc.nextLine();
                            String t = sc.nextLine();
                            String[] arr = t.split(" ", 10);
                            String date = arr[0];
                            String src = arr[1];
                            String dest = arr[2];
                            String time = arr[3];
                            try {
                                validateDateFormat(date);
                                validateCity(src);
                                validateCity(dest);
                                validateTime(time);

                            } catch (DateFormatException e) {
                                System.out.println(e.getMessage());
                                System.out.println();
                                break;
                            } catch (ValidCityException e) {
                                System.out.println(e.getMessage());
                                System.out.println();
                                break;
                            } catch (ValidTimeException e) {
                                System.out.println(e.getMessage());
                                System.out.println();
                                break;
                            }
                            Trip newTrip;
                            if (Trip.allTrips.containsKey(time + src + dest + date)) {
                                newTrip = Trip.allTrips.get(time + src + dest + date);
                                newTrip.listofTravellers.add(NewStudent);
                                PrintWriter outStream = null;
                                try {
                                    outStream = new PrintWriter(new FileOutputStream(
                                            "Trips\\" + time + src + dest + date + ".txt.txt", true));
                                } catch (FileNotFoundException e) {
                                    System.out.println("Error Occured");
                                }

                                outStream.println(name + " " + id + " " + PhoneNumber);
                                outStream.close();
                                System.out.println("Trip Already Exists. Assigned as a co-traveller");
                            } else {
                                newTrip = new Trip(date, src, dest, time);
                                newTrip.listofTravellers.add(NewStudent);
                                Trip.allTrips.put(time + src + dest + date, newTrip);
                                PrintWriter outStream = null;
                                try {
                                    outStream = new PrintWriter(new FileOutputStream(
                                            "Trips\\" + time + src + dest + date + ".txt.txt", true));
                                } catch (FileNotFoundException e) {
                                    System.out.println("Error Occured");
                                }
                                outStream.println(time + src + dest + date);
                                outStream.println(date);
                                outStream.println(src);
                                outStream.println(dest);
                                outStream.println(time);

                                outStream.print(name + " " + id + " " + PhoneNumber);
                                outStream.close();
                                System.out.println("New Ride Created");
                            }
                            System.out.println("Trip ID is: " + arr[3] + arr[1] + arr[2] + arr[0]);
                            System.out.println("Continue? (Y/N)...");
                            char test1 = sc.next().charAt(0);
                            if (test1 == 'N') {
                                cont = false;
                            }
                            break;
                        case "C":
                            System.out.println("Enter the Trip ID to view Trip details");
                            String ctripid = sc.next();
                            if (Trip.allTrips.containsKey(ctripid)) {
                                Trip checkTrip = Trip.allTrips.get(ctripid);
                                checkTrip.getTripDetails();
                            } else {
                                System.out.println("Ride ID incorrect!");
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test2 = sc.next().charAt(0);
                            if (test2 == 'N') {
                                cont = false;
                            }
                            break;
                        case "A":
                            System.out.println("Enter the Trip ID to accept ride");
                            String atripid = sc.next();
                            if (!Trip.allTrips.containsKey(atripid)) {
                                System.out.println("Ride ID incorrect!");
                            } else {
                                Trip acceptTrip = Trip.allTrips.get(atripid);
                                System.out.println("Ride Passengers");
                                System.out.println(acceptTrip.listofTravellers);

                                if (acceptTrip.listofTravellersContains(NewStudent)) {
                                    acceptTrip.getTripDetails();
                                    System.out.println("Ride Accepted!");
                                } else {
                                    System.out.println("You are not currently assigned as a co-traveller in this ride");
                                }
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test3 = sc.next().charAt(0);
                            if (test3 == 'N') {
                                cont = false;
                            }
                            break;
                        case "R":
                            System.out.println("Enter the Trip ID to reject ride");
                            String rtripid = sc.next();
                            if (!Trip.allTrips.containsKey(rtripid)) {
                                System.out.println("Ride ID incorrect!");
                            } else {
                                Trip rejectTrip = Trip.allTrips.get(rtripid);
                                System.err.println("Ride Passengers");
                                System.out.println(rejectTrip.listofTravellers);
                                if (rejectTrip.listofTravellersContains(NewStudent)) {
                                    rejectTrip.listofTravellers.removeIf(n -> n.equals(NewStudent));
                                    System.out.println("Ride Rejected!");
                                    deleteRider(name + " " + id + " " + PhoneNumber, rtripid);
                                } else {
                                    System.out.println("You are not currently assigned as a co-traveller in this ride");
                                }
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test4 = sc.next().charAt(0);
                            if (test4 == 'N') {
                                cont = false;
                            }
                            break;
                        default:
                            System.out.println("Choose a valid option");
                            System.out.println("Continue? (Y/N)...");
                            char test5 = sc.next().charAt(0);
                            if (test5 == 'N') {
                                cont = false;
                            }
                            break;

                    }// End of T/C/A/R switch
                }

            } // End of Student Mode

            // Admin mode code from here
            else if (str.equals("L1")) {
                Admin currentadmin = null;
                boolean cont1 = true;
                while (cont1) {
                    System.out.println("Enter admin username and password in the following format:");
                    System.out.println("<Username> <Password>");
                    String admin = sc.next();
                    String pass = sc.next();
                    currentadmin = new Admin(admin, pass);
                    boolean admincheck = adminAuthentication(admin, pass);
                    if (admincheck == false) {
                        cont1 = true;
                        continue;
                    } else {
                        cont1 = false;
                        break;
                    }
                }
                System.out.println("-----------------------------------------------------");
                System.out.println("Following modes of operation");
                System.out.println("AC  - View details of all registered students");
                System.out.println("E   - Charge all students");
                System.out.println("L2  - Log out as admin");
                System.out.println("-----------------------------------------------------");
                int flag = 0;
                boolean cont2 = true;
                while (cont2) {
                    System.out.println("Enter mode of operation");
                    String adminchoice = sc.next();
                    switch (adminchoice) {
                        case "AC":
                            System.out.format("%-10s %-5s %-11s", "Name", "ID", "Phone No:");
                            System.out.println();
                            Scanner inStream = null;
                            try {
                                inStream = new Scanner(new FileInputStream("UsersFile.txt"));
                            } catch (FileNotFoundException e) {
                                System.out.println("Error Occured");
                            }
                            while (inStream.hasNextLine()) {
                                String[] s = inStream.nextLine().split(" ", 10);
                                System.out.format("%-10s %-5s %-11s", s[0], s[1], s[2]);
                                System.out.println();
                            }
                            inStream.close();
                            System.out.println("Continue? (Y/N)...");
                            char test5 = sc.next().charAt(0);
                            if (test5 == 'N') {
                                cont2 = false;
                            }
                            break;
                        case "E":
                            Fares.farelist = new TreeMap<String, String>();
                            File[] f = new File("Trips").listFiles();
                            for (File filename : f) {
                                Scanner fareStream = null;
                                try {
                                    fareStream = new Scanner(new FileInputStream(filename));
                                } catch (FileNotFoundException e) {
                                    System.out.println("Error Occured");
                                }
                                String id = fareStream.nextLine();
                                String date = fareStream.nextLine();
                                String src = fareStream.nextLine();
                                String dest = fareStream.nextLine();
                                String time = fareStream.nextLine();
                                while (fareStream.hasNextLine()) {
                                    String[] userdata = fareStream.nextLine().split(" ", 10);

                                    if (!Fares.farelist.containsKey(userdata[1])) {
                                        Fares.farelist.put(userdata[1], Fares.getCost(src + dest));
                                    } else {
                                        String previouscost = Fares.farelist.get(userdata[1]);
                                        Fares.farelist.put(userdata[1], Integer.toString(Integer.parseInt(previouscost)
                                                + Integer.parseInt(Fares.getCost(src + dest))));
                                    }
                                }
                                fareStream.close();
                            }
                            System.out.format("%-5s %-6s", "ID", "Charges");
                            System.out.println();
                            for (Map.Entry<String, String> m : Fares.farelist.entrySet()) {
                                System.out.format("%-5s %-6s", m.getKey(), m.getValue());
                                System.out.println();
                            }
                            System.out.println("Continue? (Y/N)...");
                            char test6 = sc.next().charAt(0);
                            if (test6 == 'N') {
                                cont2 = false;
                            }
                            break;
                        case "L2":
                            System.out.println(currentadmin.getName() + " logged out");
                            flag = 1;
                            break;
                        default:
                            System.out.println("Choose a valid option");
                            System.out.println("Continue? (Y/N)...");
                            char test7 = sc.next().charAt(0);
                            if (test7 == 'N') {
                                cont2 = false;
                            }
                            break;

                    }
                    if (flag == 1) {
                        break;
                    }
                }

            } else if (str.equals("X")) {
                System.out.println("Exiting....");
                break;
            } else {
                System.out.println("Please enter valid option");
            }
            System.out.println("Continue(choose another mode)? (Y/N)...");
            char test6 = sc.next().charAt(0);
            if (test6 == 'N') {
                check = false;
            }
        }
        // End of While Check Loop
        // End of solution/main

        sc.close();
    }
}
