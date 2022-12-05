package Actors;

public class Admin extends ParentUser {
    private String name;
    private String password;

    public Admin(String name, String password) {
        super(name);
        this.password = password;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    // public String getName() {
    // return this.name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

}