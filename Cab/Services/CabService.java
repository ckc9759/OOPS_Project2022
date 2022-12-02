package Cab;

import Actors.*;
import Exceptions.*;


public class CabService {
    private static CabService cabBookingService = null;

    private CabService(){

    }

    public static CabService getInstance(){
        if(cabBookingService == null){
            cabBookingService = new CabService();
        }
        return cabBookingService;
    }

    // private UserService userService = UserService.getInstance();

    // public User registerUser(String name, int id,long PhoneNumber) throws CreateException {
    //     return userService.registerUser(name, id, PhoneNumber);
    // }

    // public Driver bookRide(int id,String Date,String source,String Destination,String time) throws DriverNotAvailableException {
    //     return rideService.bookRide(riderId, fromLocation, toLocation);
    // }
}
