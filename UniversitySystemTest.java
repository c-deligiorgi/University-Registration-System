package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import University.*;

import org.junit.Before;

import org.junit.Test;

public class UniversitySystemTest {

	private Student s1;
	
	@Before
	public void setUp() {
		
		String fn1 = "Chris"; 
		String ln1 = "Deli";
		
		Name name1 = new Name (fn1,ln1);
		
		StudentID id1 = StudentID.getInstance("a0001");
		
		StudentType typeUG = StudentType.UGStudent;
		
		Calendar cal = Calendar.getInstance();
		cal.set(1996, 11, 16);
		Date dob1 = cal.getTime();
		
		SmartCard sc1 = SmartCard.getInstance(name1, dob1, typeUG);
		
		s1 = new Student(name1, dob1, id1, typeUG, sc1);
		
	}
	

	@Test
	public void testRegisterStudent() {
		UniversitySystem.registerStudent(s1);
		Student actual = UniversitySystem.getStudens().get(0);  
		Student expect = s1;
		assertEquals(actual,expect);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgsExceptionOfStudent() throws IllegalArgumentException {
		String fn1 = "Chris"; 
		String ln1 = "Deli";
		
		Name name1 = new Name (fn1,ln1);
		
		StudentID id1 = StudentID.getInstance("a0001");
		
		StudentType typeUG = StudentType.UGStudent;
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 16);
		Date dob1 = cal.getTime();
		
		SmartCard sc1 = SmartCard.getInstance(name1, dob1, typeUG);
		
		s1 = new Student(name1, dob1, id1, typeUG, sc1);
		UniversitySystem.registerStudent(s1);
	}

	@Test 
	public void testamendStudentData() {
			
		
		String fn1 = "Chris"; 
		String ln1 = "Deligorgi"; // amend changes the last name 
		
		Name name2 = new Name (fn1,ln1);
		
		StudentID id2 = StudentID.getInstance("a0001");
		
		StudentType typeUG = StudentType.UGStudent;
		
		Calendar cal = Calendar.getInstance();
		cal.set(1996, 11, 16);
		Date dob2 = cal.getTime();
		
		SmartCard sc2 = SmartCard.getInstance(name2, dob2, typeUG);
		
		Student s2 = new Student(name2, dob2, id2, typeUG, sc2);
		
		Student expect = s2;
		UniversitySystem.registerStudent(s2);
		Student actual = UniversitySystem.getStudens().get(0);
		
		assertNotEquals("Fail test not equal",s1,actual);
		
		UniversitySystem.amendStudentData(s1.getStudentID(), s2);
		
		assertEquals("Fail test equal", expect,actual);
	}
	
	@Test
	
	public void testTerminateStudent() {
		StudentID id1 = StudentID.getInstance("a0001");
		UniversitySystem.terminateStudent(id1);
		assertEquals(0, UniversitySystem.getStudens().size());
	}

}
