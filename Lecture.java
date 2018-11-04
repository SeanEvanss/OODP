package LabAssignment;

import java.util.ArrayList;

public class Lecture {

	private int noOfVacancy;
	ArrayList<String> studentList = new ArrayList<String>();
	
	public Lecture() {
	}
	
//	public void addAllStudents(ArrayList<String> students) {
//		studentList = students;
//	}
	
	public void setVacancy(int vacancy) {
		noOfVacancy = vacancy;
	}
	
	public int getVacancy() {
		return noOfVacancy;
	}
	
	public void addStudent(String matricNo) {
		if(noOfVacancy == 0)
			System.out.println("Error! This course is already full.");
		else {
			for(int i=0; i<studentList.size();i++)
			{
				if(studentList.get(i) == matricNo) {
					System.out.println("This student is already registered for this lecture group! Action unsuccessful.");
					return;
				}
			}
			
			studentList.add(matricNo);
			noOfVacancy--;
			}
	}
		
}
