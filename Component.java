package oodpver1.pkg1;
import java.util.ArrayList;

public class Component {

	private String Group = new String();
	private int noOfVacancy;
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Component() {
	}
	
	public void setGroup(String Grp) {
		Group = Grp;
	}
	
	public String getGroup() {
		return Group;
	}
	
	public void setVacancy(int vacancy) {
		noOfVacancy = vacancy;
	}
	
	public int getVacancy() {
		return noOfVacancy;
	}
	public void printGroup() {
	System.out.println("Group name: " + Group + " No of vacancies: "+ noOfVacancy);
	}
	
	public void assignSlot(Student std) {
		if(noOfVacancy == 0)
			System.out.println("Sorry, this lab group is full! Register for another one.");
		else {
				if(studentList.contains(std)) {
					System.out.println("This student is already registered for this class! Action unsuccessful.");
					return;
				}
			}
			
				studentList.add(std);
				noOfVacancy--;
				System.out.println("Successfully joined this class!");
			}
				
		
			
}
