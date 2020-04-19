package University;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Christina Deligiorgi 
 *
 */

public class StudentID {
	private final String studentID;
	private static final Map<String, StudentID> ids = new HashMap<String, StudentID>();

	StudentID(String studentID) {
		this.studentID = studentID;
	}	
	
	public String getStudentID() {
		return studentID;
	}
	
	// if an id is null, this method will create a new studentID
	public static StudentID getInstance(String studentID){
		StudentID id = ids.get(studentID);
		if (id == null) {
			id = new StudentID(studentID); // unique instance
			ids.put(studentID , id);
		}
		return id;
	}
	
	
	// this method validates an ID which should have the form of a1234
	public static boolean validateID(String studentID)  {
		boolean bReturn = false;
		
		if (studentID.length() == 5) {
			if (Character.isLetter(studentID.charAt(0))) {
				boolean bDigit = true;
				
				for (int i = 1; i < studentID.length() && bDigit; i++) {
					if (!Character.isDigit(studentID.charAt(i))) {
						bDigit = false;
					}
				}
				
				if (bDigit)
					bReturn = true;
			}
		} 
		
		return bReturn;
	}
	
	public String toString() {
		return studentID;
	}
}