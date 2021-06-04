
public class LiamForstProgrammingProjectTwo {
	public static void main(String[] args) {
		// Use a try catch block to avoid a NullPointerException when the program ends
		try {
			// Run the checkAction method of the EmployeeMap class
			EmployeeMap.checkAction();
		} catch (NullPointerException e) {
			return;
		}
	}
}
