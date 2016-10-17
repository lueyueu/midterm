package com.cisc181.core;

import java.util.UUID;

public class  Enrollment {
	private UUID StudentID;
	private UUID SectionID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment(){
		this.EnrollmentID = UUID.randomUUID();
	}
	public Enrollment(UUID StudentID, UUID SectionID){
		this();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
	}
	
	public void setGrade(double Grade){
		this.Grade = Grade;
	}
	public double getGrade() {
		return Grade;
	}
	public UUID getStudentID() {
		return StudentID;
	}
	public UUID getSectionID() {
		return SectionID;
	}
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

		
		
	
}