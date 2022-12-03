package Cab;

import Exceptions.*;
import Actors.*;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static BookService bookcab=null;

    private UserService userservice = UserService.getInstance();

    private BookService(){

    }

    public static BookService getInstance(){
        if(bookcab == null){
            bookcab = new BookService();
        }
        return bookcab;
    }

    // public Driver bookRide(int id, String date, String source, String destination, String time) throws DriverNotAvailableException{
    //     User user = userservice.userMap.get(id);
    //     List<Driver> driverList = getAllAvailableDrivers(fromLocation);
    //     if(driverList.isEmpty()){
    //         throw new DriverNotAvailableException("Not driver found");
    //     }
    //     driverList.get(0).setAvailable(false);
    //     Ride ride = new Ride(driverList.get(0), rider, fromLocation, toLocation);
    //     rider.getRideList().add(ride);
    //     return driverList.get(0);
    // }
}
