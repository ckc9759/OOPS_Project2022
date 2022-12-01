public class Project {
	public static void main(String[] args)
	{
		char c;
		public bool Running;
		while(Running)
		{
		switch (c) 
		{
			case S : S();
				 break;
			case T : T();
				break;
			case C : C();
				break;
			case A : A();
				break;
			case R : R();
				break;
			case L1 : L1();
				break;
			case AC : AC();
				break;
			case AS : AS();
				break;
			case E :E();
				break;
			case L2 :L2();
				break;
			default : System.out.println("");
				break;
		}
	}
	
		S()
		{
		/*
		 * iterate over list of students to see if student exists
		 * create new student if required and add it to list
		 */
      Student 
		}
		T()
		{
			/*
			 *  will create an object of type recquirement 
			 *  Map it with list of Trips
			 *  create one more map of ID,trip			
			*/
			Requirement req = new Requirement(date,src,dest,time);
		}
		C()
		{
			/*
			 * iterate over map of ID,trip
			 * might have to create new equals method 
			 */
		}
		A()
		{
			/*
			 * add or remove from the map
			 */
		}
		}
		R()
		{
			
		}
		L1()
		{
			
		}
		AC()
		{
			
		}
		AS()
		{
			
		}
		E()
		{
			
		}
		L2()
		{
			
		}
		
}
class Student
{
	username
	id
	phone_number
	charge
	object of type requirements
	bool Login;
	//Create a constructor
	
}
class Admin{
	username
	password
	Bool Login;
}
abstract class List
{
 static List of students// map of <ID, student>
 static List of Admin // map of <username , password>
}
class Reqirement
{
	date
	source
	destination
	time of departure 
	Requirement(date,src,dest,time)
	{
		this.date = date;
		this.src=src;
		this.dest=dest;
		this.time=time;
	}
}
class Trip
{
	trip ID
	Cab ID
	List<Student> = new Arraylist();
	
}
