package LabAssignment;

import java.util.ArrayList;

public class Tutorial {

	private String tutGroup = new String();
	private int noOfVacancy;
	ArrayList<String> studentList = new ArrayList<String>();
	
	public Tutorial() {
	}
	
	public void setTutGroup(String tutGrp) {
		tutGroup = tutGrp;
	}
	
	public void setVacancy(int vacancy) {
		noOfVacancy = vacancy;
	}
	
	public String getTutGroup() {
		return tutGroup;
	}
	public int getVacancy() {
		return noOfVacancy;
	}
	
	public void assignTutSlot(String matricNo) {
		if(noOfVacancy == 0)
			System.out.println("Sorry, this tutorial group is full! Register for another one.");
		else {
		for(int i=0; i<studentList.size();i++)
		{
			if(studentList.get(i) == matricNo) {
				System.out.println("This student is already registered for this tutorial group! Action unsuccessful.");
				return;
			}
		}
		
			studentList.add(matricNo);
			noOfVacancy--;
			System.out.println("Successfully joined this tutorial group!");
		}
			
	}
}
