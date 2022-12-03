package Cab;

import Actors.*;
import Exceptions.CreateException;

import java.util.Map;
import java.util.HashMap;

public class RegisterUser extends User {
    private String id;
    private String name;
    private Long PhoneNumber;

    public RegisterUser(String id, String name, long PhoneNumber) {
        super(id, name, PhoneNumber);
    }

    public static Map<String, User> userMap = new HashMap<String, User>();

    public void register(User user) throws CreateException {
        if (user == null || userMap.containsKey(user.getId())) {
            System.out.println("User already registered with the same ID!!");
            throw new CreateException("User already registered !!");
        }
        // Put the ID and user object in the userMap
        userMap.put(user.getId(), user);

        // To print the user details
        user.ShowDetails();

        for (Map.Entry<String, User> entry : userMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
