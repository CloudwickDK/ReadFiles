package readXml;

public class Employee {
	
	private long ID;
	private String FirstName, LastName;
	private int age, salary;
	
	public Employee(long ID, String FirstName, String LastName, int age, int salary){
		this.ID = ID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.age = age;
		this.salary = salary;
	}
	
	public String toString(){
		return "ID: " + ID + " FirstName: " + FirstName + " LastName: " + LastName + " age: " + age + " salary: " + salary;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		return ID;
	}
	
	public void setFirstname(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}
