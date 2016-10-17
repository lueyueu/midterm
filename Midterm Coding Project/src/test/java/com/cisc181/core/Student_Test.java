package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;


public class Student_Test {
	
	
	static ArrayList<Course> courseList;
	static Course firstCourse;
	static Course secondCourse;
	static Course thirdCourse;
	
	static ArrayList<Semester> semesterList;
	static Semester Fall;
	static Semester Spring;
	
	static ArrayList<Section> sectionList;
	static Section S1Fall;
	static Section S2Fall;
	static Section S3Fall;
	static Section S1Spring;
	static Section S2Spring;
	static Section S3Spring;
	
	static ArrayList<Student> studentList;
	static Student s1;
	static Student s2;
	static Student s3;
	static Student s4;
	static Student s5;
	static Student s6;
	static Student s7;
	static Student s8;
	static Student s9;
	static Student s10;
	

	static ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();
	

	@BeforeClass
	public static void setup() {
		studentList = new ArrayList<Student>();
		s1 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s2 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s3 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s4 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s5 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s6 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s7 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s8 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s9 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		s10 = new Student("First", "Middle", "Last", new Date(), eMajor.COMPSI, "address", "(301)-257-4571", "student@email");
		 
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
		studentList.add(s8);
		studentList.add(s9);
		studentList.add(s10);
		
		sectionList = new ArrayList<Section>();
		S1Fall = new Section(firstCourse.getCourseID(), Fall.getSemesterID(), 230);
		S2Fall = new Section(secondCourse.getCourseID(), Fall.getSemesterID(), 320);
		S3Fall = new Section(thirdCourse.getCourseID(), Fall.getSemesterID(), 510);
		S1Spring = new Section(firstCourse.getCourseID(), Spring.getSemesterID(), 216);
		S2Spring = new Section(secondCourse.getCourseID(), Spring.getSemesterID(), 342);
		S3Spring = new Section(thirdCourse.getCourseID(), Spring.getSemesterID(), 974);
		
		
		
		courseList = new ArrayList<Course>();
		firstCourse = new Course("Physics305", 12, eMajor.PHYSICS);
		secondCourse = new Course("Chem101",16, eMajor.CHEM);
		thirdCourse = new Course("Biology", 8, eMajor.NURSING);
		courseList.add(firstCourse);
		courseList.add(secondCourse);
		courseList.add(thirdCourse);
		
		
		sectionList.add(S1Fall);
		sectionList.add(S2Fall);
		sectionList.add(S3Fall);
		sectionList.add(S1Spring);
		sectionList.add(S2Spring);
		sectionList.add(S3Spring);
		
		
		semesterList = new ArrayList<Semester>();
		Spring = new Semester(new Date(),new Date());
		Fall = new Semester(new Date(),new Date());
		semesterList.add(Spring);
		semesterList.add(Fall);
		
		
		
		for(Student s: studentList)
			for(Section c: sectionList)
				enrollList.add(new Enrollment(s.getStudentID(),c.getSectionID()));
	}

	@Test
	public void EnrollTest(){
		
		assertTrue(enrollList.size() == 60);
					
	}

	@Test
	public void GPAtest() {
		enrollList.get(0).setGrade(3.0);
		enrollList.get(1).setGrade(4.0);
		enrollList.get(2).setGrade(2.0);
		enrollList.get(3).setGrade(3.0);
		enrollList.get(4).setGrade(2.0);
		enrollList.get(5).setGrade(4.0);
		
		enrollList.get(6).setGrade(2.0); 
		double trueGPA = (12.0*3+4*16+2*8+3*12+2*16+4*8)/(12+8+16+12+16+8);
		
		double student1CumPoints = 0;
		int PointsTotal = 0;
		for(Enrollment e: enrollList)
			if(e.getStudentID() == studentList.get(0).getStudentID()){  	
				for(Section s: sectionList)
					if(s.getSectionID() == e.getSectionID()){
						for(Course c: courseList)
							if(s.getCourseID() == c.getCourseID()){
								student1CumPoints += e.getGrade() * c.getGradePoints();
								PointsTotal+= c.getGradePoints();
							}
					}	
			}
		
		
		double student1GPA = student1CumPoints/PointsTotal;
		assertEquals(student1GPA, trueGPA, .001);
		
		
		for(int i = 6; i < enrollList.size(); i++)
			enrollList.get(i).setGrade(2.0);
			
		
		trueGPA = 2.0;

		assertEquals(StudentGPA(studentList.get(1).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(2).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(3).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(4).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(5).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(6).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(7).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(8).getStudentID()), trueGPA, .001);
		assertEquals(StudentGPA(studentList.get(9).getStudentID()), trueGPA, .001);
		
	}
	
	public double StudentGPA(UUID StudentID){
		double studentCumPoints = 0;
		int PointsTotal = 0;
		for(Enrollment e: enrollList)
			if(e.getStudentID() == StudentID){ 
				for(Section s: sectionList)
					if(s.getSectionID() == e.getSectionID()){
						for(Course c: courseList)
							if(s.getCourseID() == c.getCourseID()){
								studentCumPoints += e.getGrade() * c.getGradePoints();
								PointsTotal+= c.getGradePoints();
							}
					}	
			}
		double studentGPA = studentCumPoints/PointsTotal;
		return studentGPA;
	}
	
	@Test
	public void CourseAveragetest(){
											
					
		for(int i = 0; i < enrollList.size(); i++){
			enrollList.get(i).setGrade(i % 3 + 2); 
		}

		double firstCoursetotal = 0;
		double secondCoursetotal = 0;
		double thirdCoursetotal = 0;
		
		int numfirst = 0;
		int numsecond = 0;
		int numthird = 0;
		for(Course c: courseList)
			for(Section s: sectionList)
				for(Enrollment e: enrollList)
					if (c.getCourseID() == s.getCourseID()){
						if(s.getSectionID() == e.getSectionID()){
							if(c.getCourseID() == courseList.get(0).getCourseID()){
								firstCoursetotal+= e.getGrade(); 
								numfirst++;
							}
							else if(c == courseList.get(1)){
								secondCoursetotal+= e.getGrade(); 
								numsecond++;
							}
							else{
								thirdCoursetotal += e.getGrade(); 
								numthird++;
							}
						}
					}
					
		double firstCourseAverage = firstCoursetotal/numfirst;
		double secondCourseAverage = secondCoursetotal/numsecond;
		double thirdCourseAverage = thirdCoursetotal/numthird;
		
		assertEquals(firstCourseAverage, 2.0, 0);
		assertEquals(secondCourseAverage, 3.0, 0);
		assertEquals(thirdCourseAverage, 4.0, 0);
	}
	
	@Test
	public void changeMajorTest(){
		String oldMajor = studentList.get(5).getMajor().toString();
		studentList.get(5).setMajor(eMajor.BUSINESS);
		String newMajor = studentList.get(5).getMajor().toString();
		assertTrue(oldMajor != newMajor);
	}
}