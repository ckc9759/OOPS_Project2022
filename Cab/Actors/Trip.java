package Actors;

import java.sql.Date;
import java.sql.Time;

public class Trip{
    private int id;
    private String date;
    private String source;
    private String destination;
    private String time;
    
    public Trip(int id,String date,String source,String destination,String time){
        this.id=id;
        this.date=date;
        this.source=source;
        this.destination=destination;
        this.time=time;
    }
    
    public void ShowDetails(){
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Request Registered");
        System.out.println(" ");
        System.out.println("Entered Details - ");
        System.out.println("ID           \t : \t"+this.id);
        System.out.println("Date         \t : \t"+this.date);
        System.out.println("Source       \t : \t"+this.source);
        System.out.println("Destination  \t : \t"+this.destination);
        System.out.println("Time         \t : \t"+this.time);
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
        return destination;
    }

    public void setDest(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
