
public class Employee {

	// Create instance variables of employee class
	int IDNumber;
	String name;

	// Constructor method to take arguments and assign to IDNumber and name
	public Employee(int IDNumberArg, String nameArg) {
		IDNumber = IDNumberArg;
		name = nameArg;
	}

	// Getter method for IDNumber
	public int getEmployeeID() {
		return IDNumber;
	}

	// Getter method for name
	public String getEmployeeName() {
		return name;
	}

	// Setter method for name
	public void setEmployeeName(String nameInput) {
		name = nameInput;
	}

	// Setter method for IDNumber
	public void setEmployeeID(int IDInput) {
		IDNumber = IDInput;
	}
}
