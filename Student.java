package oodpver1.pkg1;

import java.util.ArrayList;
import java.util.Iterator;


public class Student {
    
	ArrayList<Result> results = new ArrayList<Result>();
	private String matric, studentName;
	
	public Student(String matricNo, String stuName) {
		matric = matricNo;
		studentName = stuName;
	}
	public void addMod(String id, int examWeightage, int classPartWeightage, int labWeightage, int quizWeightage, int tutWeightage,boolean hasclasspart, boolean hasgradedlab, boolean hasgradedtut, boolean hasquiz) {
		Result result =new Result (id, examWeightage, classPartWeightage, labWeightage, quizWeightage, tutWeightage, hasclasspart, hasgradedlab, hasgradedtut, hasquiz);
		results.add(result);
	}
	
	public String getStudentMatric() {
		return matric;}

	public String getStudentName() {
		return studentName;
	}
	 
	/* Display transcript using Iterator*/
	public void printTranscript() {
                
                if(results.size()>0){
                    for(int i=0; i<results.size();i++) {
			results.get(i).printResult();
                    }
                }
		
    }

	public Result getResult(String code) {
		Result temp=null;
		boolean flag = false;
		Iterator<Result> it = results.iterator();
		while(it.hasNext()) {
			temp = it.next();
			if (temp.getID().equals(code)) {
				flag=true;
				return temp;
			}
		}
		if(flag==false) {
				System.out.println("Error! Course not found!");
				temp = null;
		}
		return temp;
	}
   
    
  
}
