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

    public Map<String, User> userMap = new HashMap<String, User>();

    public void register(User user) throws CreateException {
        if (user == null || userMap.containsKey(user.getId())) {
            throw new CreateException("User already registered !!");
        }
        userMap.put(user.getId(), user);
    }
}
