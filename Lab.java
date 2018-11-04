package LabAssignment;

import java.util.ArrayList;

public class Lab {

	private String labGroup = new String();
	private int noOfVacancy;
	ArrayList<String> studentList = new ArrayList<String>();
	
	public Lab() {
	}
	
	public void setLabGroup(String labGrp) {
		labGroup = labGrp;
	}
	
	public String getLabGroup() {
		return labGroup;
	}
	
	public void setVacancy(int vacancy) {
		noOfVacancy = vacancy;
	}
	
	public int getVacancy() {
		return noOfVacancy;
	}
	
	public void assignLabSlot(String matricNo) {
		if(noOfVacancy == 0)
			System.out.println("Sorry, this lab group is full! Register for another one.");
		else {
			for(int i=0; i<studentList.size();i++)
			{
				if(studentList.get(i) == matricNo) {
					System.out.println("This student is already registered for this lab group! Action unsuccessful.");
					return;
				}
			}
			
				studentList.add(matricNo);
				noOfVacancy--;
				System.out.println("Successfully joined this lab group!");
			}
				
		}
			
}
