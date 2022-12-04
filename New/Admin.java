public class Admin {
    private String name;
    private String password;

    public Admin(String name, String password){
        this.name=name; this.password=password;
    }
    public String getName(){return this.name;}
    public String getPass(){return password;}
    public void setName(String name){
        this.name=name;
    }
    public void setPass(String pass){
        this.password=pass;
    }
}
