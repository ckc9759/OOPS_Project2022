import java.util.*;
public class User{
    private String name;
    private String id;
    private String PhoneNumber;
    
    public User(String name, String id, String PhoneNumber){
        this.name=name;
        this.id=id;
        this.PhoneNumber=PhoneNumber;
    }
    
    public void ShowDetails(){
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Registration Successful");
        System.out.println(" ");
        System.out.println("Entered Details - ");
        System.out.println("Name     \t : \t"+this.name);
        System.out.println("ID       \t : \t"+this.id);
        System.out.println("Phone no.\t : \t"+this.PhoneNumber);
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------------------------------");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString(){
        return "Name: " + name + " ID: " + id + " Phone: " + PhoneNumber;
    }

    public boolean equals(User user){
        return this.name.equals(user.name)&&this.id.equals(user.id)&&this.PhoneNumber.equals(user.PhoneNumber);
    }
}