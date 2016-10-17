package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	
	public Course(){
		
	}

	public Course(String courseName, int gradePoints, eMajor major) {
		this.CourseID = UUID.randomUUID();
		this.CourseName = courseName;
		this.GradePoints = gradePoints;
		this.Major = major;
	}
	
	public UUID getCourseID() {
		return CourseID;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	
	public int getGradePoints() {
		return GradePoints;
	}
	
	public eMajor getMajor() {
		return Major;
	}
	
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	
	public void setMajor(eMajor major) {
		Major = major;
	}

}
