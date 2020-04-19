package University;
import java.util.Calendar;
import java.util.Date;
/**
 * @author Christina Deligiorgi
 *
 */

public class SmartCardNumber {
	
	
	private Date d = new Date();
	private int yoi;
	private char fName;
	private char lName;
	private static int serialN = 9;

	
	public SmartCardNumber(Name name) {
		
		this.fName = name.getFirstName().toUpperCase().charAt(0);
		this.lName = name.getLastName().toUpperCase().charAt(0);
		
		Calendar issue = Calendar.getInstance();
		issue.setTime(d);
		this.yoi = issue.get(Calendar.YEAR);
		if (serialN>99) {
			serialN=10;
		}
		serialN++;
	}
	
	//JS-2018-10
	public String toString() {
		return fName + lName + "-"+yoi+"-"+serialN;
	}
	
	
	
}