package University;
import java.util.Date;
import java.util.List;

/**
 * @author Christina Deligiorgi
 *
 */

//this interface is a collection of the abstract methods of the student
public interface IStudent {

	
	//a method to get student's ID 
	StudentID getStudentID();
	
	//a method to get student's date of birth
	Date getStudentsDob();
	
	//a method to get student's type(UG, PGT, PGR)
	StudentType getStudentType();
	
	//a method to list the modules that the student is registered for
	List<Module> getModulesList();
	
	//a method which returns true if the student is currently registered for enough credits and false otherwise
	boolean correctRegistration();
}