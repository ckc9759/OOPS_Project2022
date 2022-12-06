package Actor;

import Interfaces.UserInterface;
import Parent.ParentUser;

public class User extends ParentUser implements UserInterface {
    private String id;
    private String PhoneNumber;

    public User(String name, String id, String PhoneNumber) {
        super(name);
        this.id = id;
        this.PhoneNumber = PhoneNumber;
    }

    public void ShowDetails() {
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Registration Successful");
        System.out.println(" ");
        System.out.println("Entered Details - ");
        System.out.println("Name     \t : \t" + super.getName());
        System.out.println("ID       \t : \t" + this.id);
        System.out.println("Phone no.\t : \t" + this.PhoneNumber);
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public String getPhone() {
        return PhoneNumber;
    }

    public void setPhone(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "Name: " + super.getName() + " ID: " + id + " Phone: " + PhoneNumber;
    }

    public boolean equals(User user) {
        return super.getName().equals(user.getName()) && this.id.equals(user.id)
                && this.PhoneNumber.equals(user.PhoneNumber);
    }
}