package Actors;
import Cab.CabService;
// import java.util.*;

// import Exceptions.*;

public class Admin {
    private String username;
    private String Pwd;
    private static boolean isLogin=false;

    public Admin(String username, String Pwd)
    {
        this.username = username;
        this.Pwd =Pwd;      
    }

    public void AdminLogin(String name,String password)
    {
    	if(AdminMap.containsKey(name))
    	{
    		String CorrectPass;
    		CorrectPass=AdminMap.get(name).getPwd();
    		if (password.equals(CorrectPass))
    		{
    			Admin.isLogin=true;
    			System.out.println("Welcome");
    		}
    		else 
    		{
    			try 
    			{
     	            throw new MyException("Incorrect Pssword");
     	        }
     	        catch (MyException ex) 
     		    {
     	   
     	            System.out.println(ex.getMessage());
     	        }
    		}
    			
    	}
    	else
    	{
    		 try 
    		 {
    	       throw new MyException("You are not a registered user");
    	     }
    	        catch (MyException ex) 
    		 {
    	            System.out.println("Caught");
    	 
    	            // Print the message from MyException object
    	            System.out.println(ex.getMessage());
    	     }
    	}
    }

    public String getUserName() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPwd() {
        return this.Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }
    public boolean getLogin() {
        return this.isLogin;
    }

    public void setLogin(boolean b) {
        this.isLogin = b;
    }
    
}
