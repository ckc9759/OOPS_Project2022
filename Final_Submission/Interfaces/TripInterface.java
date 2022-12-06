package Interfaces;

import Actor.User;

public interface TripInterface {
    void ShowDetails();

    boolean listofTravellersContains(User user);

    void getTripDetails();
}
