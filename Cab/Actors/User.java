package cab.actors

public abstract class User{
    private String name;
    private int id;
    private int PhoneNumber;
    
    public User(String name, int id, int PhoneNumber){
        this.name=name;
        this.id=id;
        this.PhoneNumber=PhoneNumber;
    }
    
    public ShowDetails(){
        System.out.println("Registration Successful\n")
        System.out.println("Entered Details : \n");
        System.out.println("Name : \n"+name);
        System.out.println("ID : \n"+id);
        System.out.println("Phone no. : \n"+PhoneNumber);
        
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
