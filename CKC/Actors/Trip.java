package Actors;

import java.util.*;

public class Trip {
    private String date;
    private String source;
    private String dest;
    private String time;
    private String tripid;
    public ArrayList<User> listofTravellers;

    public static HashMap<String, Trip> allTrips;

    public Trip(String date, String source, String dest, String time) {
        this.tripid = time + source + dest + date;
        this.date = date;
        this.source = source;
        this.dest = dest;
        this.time = time;
        listofTravellers = new ArrayList<User>();
    }

    public void ShowDetails() {
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Request Registered for ID "+this.tripid);
        System.out.println(" ");
        System.out.println("Entered Details - ");
        // System.out.println("ID \t : \t"+this.id);
        System.out.println("Trip ID      \t : \t" + this.time+this.source+this.dest+this.date);
        System.out.println("Date         \t : \t" + this.date);
        System.out.println("Source       \t : \t" + this.source);
        System.out.println("Destination  \t : \t" + this.dest);
        System.out.println("Time         \t : \t" + this.time);
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /*
     * public String getId() {
     * return id;
     * }
     * 
     * public void setId(String id) {
     * this.id = id;
     * }
     */

    public void getTripDetails() {
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Ride Found !");
        System.out.println(" ");
        System.out.println("Trip Details - ");
        // System.out.println("ID \t : \t"+this.id);
        System.out.println("Trip ID      \t : \t" + this.time+this.source+this.dest+this.date);
        System.out.println("Date         \t : \t" + this.date);
        System.out.println("Source       \t : \t" + this.source);
        System.out.println("Destination  \t : \t" + this.dest);
        System.out.println("Time         \t : \t" + this.time);
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Co-Travellers");
        for (User user : listofTravellers) {
            System.out.println(user);
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public boolean listofTravellersContains(User user) {
        boolean check = false;
        for (User element : listofTravellers) {
            if (element.equals(user)) {
                check = true;
                break;
            }
        }
        return check;
    }
}