package LabAssignment;

public class Professor {

	private String profName = new String();
	private String profRole = new String();
	private int officeNo;
	
	public Professor() {
		//this.profName = profName;
		//this.profRole = profRole;
		//this.officeNo = officeNo;
	}
	
	public void setProfName(String profName) {
		this.profName = profName;
	}
	
	public void setOfficeNo(int officeNum) {
		officeNo = officeNum;
	}
	
	public void setProfRole(String newprofRole) {
		profRole = newprofRole;
	}
	
	public String getProfName() {
		return profName;
	}
	
	public String getProfRole() {
		return profRole;
	}
	
	public int getOfficeNo() {
		return officeNo;
	}
}
