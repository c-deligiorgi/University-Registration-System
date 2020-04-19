package University;

import java.util.*;
import java.util.Date;
import java.util.Calendar;
/**
 * @author Christina Deligiorgi
 *
 */

public class SmartCard {
	private Name name;
	private Date dob;
	private static SmartCardNumber o;
	private static Date doi = new Date();
	private Date expiryDate;
	private static final Map<String,SmartCard> cards = new HashMap<String,SmartCard>();
	
	SmartCard(Name name, Date dob) {
		this.name = name;
		this.dob = dob;
	}
	
	public static SmartCard getInstance(Name name, Date dob, StudentType type) {
		o = new SmartCardNumber(name);
		SmartCard cardObject;
		do {
			if ( cards.containsKey(o))
				o = new SmartCardNumber(name); 
			setExpireDate(doi,type);
			cardObject = new SmartCard(name, dob);
			cards.put(o.toString(),cardObject);
		
		}
		while (o == null);
		
		return cardObject;
		
	}
	
	// this private method sets an expire date for the card depending on the different types of students + the years
	//each student can be registered for
	private static void setExpireDate(Date doi, StudentType studentType) {
		
		Calendar expireDate = Calendar.getInstance();
		expireDate.setTime(doi);
		
		if (studentType == StudentType.UGStudent) {
				expireDate.set(Calendar.YEAR, expireDate.get(Calendar.YEAR)+4);
		} else if (studentType == StudentType.PGTStudent) {
			    expireDate.set(Calendar.YEAR, expireDate.get(Calendar.YEAR)+2);
			
		} else if (studentType == StudentType.PGRStudent) {
			    expireDate.set(Calendar.YEAR, expireDate.get(Calendar.YEAR)+5);
			
		}
		
		
	}
	
	// this is a public method to get the expire date
	public Date getExpiryDate() {
			return expiryDate;
		}

	// this is a method to get the SmartCardNumber and returns a new smartCard
	public SmartCardNumber getSmartCardNumber() {
		return o;
	}
	
	// return Name with defensive copying
	public Name getName() {
		return new Name(name.getFirstName(),name.getLastName());
	}

	// this is a method to get the Date of Birth
	public Date getDob() {
		return dob;
	}
	
}