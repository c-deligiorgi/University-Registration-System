package University;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Christina Deligiorgi
 *
 */

public class Student implements IStudent {

	private final Name name;
	private final Date dob;
	private  int age;
	private final StudentID studentID;
	private final StudentType studentType;
	private List<Module> modules = new ArrayList<Module>();
	private Supervisor supervisorName;
	private SmartCard smartCard;
	
	public Student (Name name, Date dob, StudentID studentID, StudentType studentType, SmartCard sc) {
		
		this.studentID = studentID;
		this.name = name;
		this.dob = dob;
		this.studentType = studentType;
		this.smartCard = sc;
		setAge();
	}
	
	//passing the supervisorName for the PGRStudent and throwing an exception
	public Student (Name name, Date dob, StudentID studentID, String SupervisorName, SmartCard sc) throws Exception {
		this.smartCard = sc;
		this.studentID = studentID;
		this.name = name;
		this.dob = dob;
		this.studentType = StudentType.PGRStudent;
		this.supervisorName = new Supervisor(SupervisorName);
		setAge();
	}	
	
	//This method gets the age based on the year on the calendar now and returns the difference
	//from the date of birth of the student
	public void setAge() {		
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		int nowYear = now.get(Calendar.YEAR); 
		
		Calendar studentDob = Calendar.getInstance();
		studentDob.setTime(dob);
		int studentYear = studentDob.get(Calendar.YEAR); 
		
		age =  nowYear - studentYear;
	}
	
	// a method that returns a new first name and a new last name
	public Name getName() {
		
		return new Name(name.getFirstName(),name.getLastName()); //unique instance
	}
	
	// a method to get the smartCard
	public SmartCard getSmartCard() {
	     return smartCard;
	}
	
	@Override
	public StudentID getStudentID() {
		return studentID;
	}
	
	// a method to get a list of modules
	public List<Module> getModulesList() {
		return modules;
		}
	
	// a method to get the studentType of the student
	public StudentType getStudentType() {
		return studentType;
	}

	//this method checks the correct registration of a student and returns the total credits
	//of UG PGT PGR students
	public boolean correctRegistration() {
		boolean f = false;
		
		int total = 0;
		
		for (int i = 0; i < modules.size(); i++) {
			total += modules.get(i).getModuleCredits();
		}
		
		System.out.println(total);
		
		if (this.studentType == StudentType.UGStudent) {
			if (total == 120)
				f = true;
		} else if (this.studentType == StudentType.PGTStudent) {
			if (total == 180)
				f = true;
		} else if (this.studentType == StudentType.PGRStudent) {
			if (total == 0)
				f = true;
		}
		
		return f;
	}
	
	//a method to add module to the list of modules
	public void addModule(Module module) {
		modules.add(module);
		
	}

	@Override
	public Date getStudentsDob() {
		return dob;
	}

	public int getAge() {
		return age;
	}

	public Supervisor getSupervisorName() {
		return supervisorName;
	}
	
}