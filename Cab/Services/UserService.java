package Cab;

import Actors.*;
import Exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService username = null;

    private UserService() {

    }

    public Map<Integer, User> userMap = new HashMap<Integer, User>();
    public Map<Integer, User> driverMap = new HashMap<Integer, User>();

    public static UserService getInstance() {
        if (username == null) {
            username = new UserService();
        }
        return username;
    }

    // public User registerUser(String name, int id, long PhoneNumber){
    // User user = new User(name, id, PhoneNumber);
    // if(user==null||userMap.containsKey(user.getId())){
    // throw new CreateException("User already registered !!");
    // }
    // userMap.put(user.getId(), user);
    // return user;
    // }

    public Map<Integer, User> getRiderMap() {
        return userMap;
    }
}
