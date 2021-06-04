import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EmployeeMap {

	// Store the new employee HashMap as EmployeeMappings
	static Map<Integer, Employee> EmployeeMappings = new HashMap<>();

	// Method displays input dialog and responds to user input
	public static void checkAction() {
		// Ask the user what they want to do
		String userOption = JOptionPane
				.showInputDialog("Type add to add employee, search to look up employee, or done to quit");
		// Start loop to repeat message until the user types "done"
		while (!userOption.equals("done")) {
			// Run the function to add employees to the map
			if (userOption.equals("add")) {
				addEmployeeToMap();
				userOption = JOptionPane
						.showInputDialog("Type add to add employee, search to look up employee, or done to quit");
				// Run the function to search the employee names using their ID number
			} else if (userOption.equals("search")) {
				getEmployeeByID();
				userOption = JOptionPane
						.showInputDialog("Type add to add employee, search to look up employee, or done to quit");
			} else {
				userOption = JOptionPane.showInputDialog("Invalid Command. Try again");
			}
		}
	}

	// Method asks user for employee ID number then displays the name
	public static void getEmployeeByID() {
		int employeeID = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID Number"));
		if (EmployeeMappings.containsKey(employeeID)) {
			String employeeName = EmployeeMappings.get(employeeID).getEmployeeName();
			JOptionPane.showMessageDialog(null, "The Employee name is " + employeeName);
		} else {
			JOptionPane.showMessageDialog(null, "Employee ID does not exist.");
		}
	}

	// Method reads employee names and ID numbers from a document and adds them to
	// the map
	public static void addEmployeeToMap() {
		boolean foundFile = false;
		// Create a loop to continue displaying message until file is found
		while (!foundFile) {
			try {
				// Search for the file name from the user input
				String fileName = "src/" + JOptionPane.showInputDialog("Enter File Name:");
				File employeeFile = new File(fileName);
				Scanner fileScanner = new Scanner(employeeFile);
				int positionTracker = 0;
				int newNumber = 0;
				// Read the document and alternate between assigning to IDNumber and name
				while (fileScanner.hasNext()) {
					if (positionTracker == 0) {
						// Save the employee ID numbers into the newNumber variable
						newNumber = Integer.parseInt(fileScanner.next());
						positionTracker = 1;
					} else {
						// Save the names into the newEmployee variable
						String newName = fileScanner.next();
						// Create a new instance of employee using constructor with newName and
						// newNumber from previous iteration
						Employee newEmployee = new Employee(newNumber, newName);
						// Use getter method to add employee name and ID number to the map
						EmployeeMappings.put(newEmployee.getEmployeeID(), newEmployee);
						positionTracker = 0;
					}
				}
				// Indicate to the user that the employees were successfully added
				JOptionPane.showMessageDialog(null, "Employees added to map.");
				// Close scanner and exit loop
				fileScanner.close();
				foundFile = true;
			} catch (FileNotFoundException e) {
				// Indicate that the file name was invalid
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}

}
