package University;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Christina Deligiorgi
 *
 */
public class UniversitySystem {
	
	
	private static final  List<Student> students = new ArrayList<Student>();
	private static final List<Module> modules = new ArrayList<Module>();
	
	//This method returns the number of students of the specified type that are currently
	//enrolled.
	public int noOfStudents(StudentType studentType) {
		int total = 0;
		
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentType() == studentType && students.get(i).correctRegistration())
				total++;
		}
		
		return total;
	}
	
	//This method registers a new student onto the system and allocates a student ID 
	public static void registerStudent(Student student) throws IllegalArgumentException{
		int age = student.getAge();
		StudentType studentType = student.getStudentType();
		
		if (studentType == StudentType.UGStudent && age >= 17)  {
			students.add(student);
		} else if (studentType == StudentType.PGTStudent && age >= 20) {
			students.add(student);
		}
		else if (studentType == StudentType.PGRStudent && age >= 20) {
			students.add(student);
		}
		else { throw new IllegalArgumentException("Non valid registration");}
	}
	
	//This method changes a student record.
	public static void amendStudentData(StudentID studentID, Student studentData) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentID() == studentID) {
				students.set(i, studentData);
				break;
			}
		}
	}
	
	//This method removes the student record associated with the given student number. 
	public static void terminateStudent(StudentID studentID) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentID().toString().equals(studentID.toString())) {
				students.remove(i);
				break;
			}
		}		
	}

	public static List<Module> getModules() {
		return modules;
	}
	
	public static List<Student> getStudens() {
		return students;
	}
	
}