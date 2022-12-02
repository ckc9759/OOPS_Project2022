package Actors;

// import java.util.*;

// import Exceptions.*;

public class User {
    private String name;
    private String id;
    private long PhoneNumber;

    public User(String name, String id, long PhoneNumber) {
        this.name = name;
        this.id = id;
        this.PhoneNumber = PhoneNumber;
    }

    // public Map<String, User> userMap = new HashMap<String, User>();
    // // public Map<String, User> driverMap = new HashMap<String, User>();

    // public void register(User user) throws CreateException {
    //     if (user == null || userMap.containsKey(user.getId())) {
    //         throw new CreateException("User already registered !!");
    //     }
    //     userMap.put(user.getId(), user);
    // }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
