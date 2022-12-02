package Actors;

import java.util.*;

import Exceptions.*;

public class User {
    private String name;
    private int id;
    private long PhoneNumber;

    public User(String name, int id, long PhoneNumber) {
        this.name = name;
        this.id = id;
        this.PhoneNumber = PhoneNumber;
    }

    private User(){

    }

    private static User username = null;
    public static User getInstance() {
        if (username == null) {
            username = new User();
        }
        return username;
    }

    public Map<Integer, User> userMap = new HashMap<Integer, User>();
    public Map<Integer, User> driverMap = new HashMap<Integer, User>();

    public void ShowDetails() {
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Registration Successful");
        System.out.println(" ");
        System.out.println("Entered Details - ");
        System.out.println("Name     \t : \t" + this.name);
        System.out.println("ID       \t : \t" + this.id);
        System.out.println("Phone no.\t : \t" + this.PhoneNumber);
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public User registerUser(String name, int id, long PhoneNumber)throws CreateException{
        User user = new User(name, id, PhoneNumber);
        if(user==null||userMap.containsKey(user.getId())){
            throw new CreateException("User already registered !!");
        }
        userMap.put(user.getId(), user);
        return user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return PhoneNumber;
    }

    public void setPhone(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
