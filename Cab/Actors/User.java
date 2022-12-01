package Actors;

public class User{
    private String name;
    private int id;
    private int PhoneNumber;
    
    public User(String name, int id, int PhoneNumber){
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
    
    public int getPhone() {
        return PhoneNumber;
    }

    public void setPhone(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
