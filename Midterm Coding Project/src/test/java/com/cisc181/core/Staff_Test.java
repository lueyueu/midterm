package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import exception.PersonException;

public class Staff_Test {
	
	static ArrayList<Staff> staff;
	static Staff firstStaff;
	static Staff secondStaff;
	static Staff thirdStaff;
	static Staff fourthstaff;
	static Staff fifthstaff;
	

	@BeforeClass
	public static void setup() {
			staff = new ArrayList<Staff>();
			firstStaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-257-9067", "12 Circle", "firststaff@email.com", 0, 68000.0, null, eTitle.MR);
			secondStaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-223-9045", "674 Brook Dr", "secondstaff@email.com", 0, 55700, null, null);
			thirdStaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-137-9067", "7 Tufts Ln", "thirdstaff@email.com", 0, 79000, null, null);
			fourthstaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-245-8934", "274 Swarthmore Dr", "fourthstaff@email.com", 0, 15900, null, null);
			fifthstaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-254-9078", "701 Canton Dr", "fifthstaff@email.com", 0, 67500, null, null);
			staff.add(firstStaff);
			staff.add(secondStaff);
			staff.add(thirdStaff);
			staff.add(fourthstaff);
			staff.add(fifthstaff);
	}
	
	@Test
	public void SalaryTest() {
		double AverageSalary = ((68000 + 55700 +79000 + 15900 + 67500)/5);
		double total = 0;
		for (Staff s: staff){
			total += s.getSalary();
		}
		double Average = total/staff.size();
		assertEquals(AverageSalary,Average, .1);
	}	
	
	@Test(expected = PersonException.class)
	public void tooOldTest() throws PersonException{
		Calendar newCal =  Calendar.getInstance();
		newCal.set(Calendar.YEAR, 1900);
		Date newdate = newCal.getTime();
		
		secondStaff.setDOB(newdate);
	}
	
	@Test
	public void Correctnumbertest() throws PersonException{
		thirdStaff.setPhone("(302)-312-5603");
	}
	
	@Test(expected = PersonException.class)
	public void Wrongnumbertest() throws PersonException{
		
		thirdStaff.setPhone("(27)-096-6856");
	}
}
