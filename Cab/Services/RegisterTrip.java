package Cab;

import Actors.*;
import Exceptions.*;

import java.util.Map;
import java.util.HashMap;

public class RegisterTrip extends Trip {
    private String id;
    private String date;
    private String source;
    private String destination;
    private String time;

    public RegisterTrip(String id, String date, String source, String destination, String time) {
        super(id, date, source, destination, time);
    }

    public static Map<String, Trip> userTrip = new HashMap<String, Trip>();

    public void register(Trip trip) throws CreateException {
        if (trip == null || userTrip.containsKey(trip.getId())) {
           System.out.println("User already registered with the same ID!!");
           trip.getTripDetails(trip.getId());
           throw new CreateException("User already registered !!");
        }
        // Put the ID and trip object in the userMap
        userTrip.put(trip.getId(), trip);

        // To print the trip details
        trip.ShowDetails();

        for (Map.Entry<String, Trip> entry : userTrip.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
