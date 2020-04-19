package University;
/**
 * @author Christina Deligiorgi
 *
 */

public class Name {

	private String firstName;
	private String lastName;
	private String flName;
	/*
	 * Used to detect unique names
	 * private static final Map<String, Name> names = new HashMap<String, Name>();*/
	
	public Name(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.flName = firstName + " " + lastName;
	}
	
	public String getFirstName() { return firstName; }
	
	public String getLastName() { return lastName; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String toString() { return flName; }
	
}
