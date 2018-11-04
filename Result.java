package oodpver1.pkg1;
import java.util.Scanner;
public class Result {
	private String courseID;
	private int exam=0,classPart=0, lab=0, quiz=0,tut=0;//mark
	private double overallMark;
	private char overallGrade, examGrade, cpGrade, labGrade, quizGrade, tutGrade;//grade
	private int examWeight=0,classPartWeight=0,labWeight=0,quizWeight=0,tutWeight=0;
	
	
	public String getID() {
		return courseID;
	}
	public void setCourseWorkMark() {
		Scanner sc = new Scanner(System.in);
		int compo;
		int mark;
		do{
			System.out.println("Which component do you want to set?\n");
	  	if(classPartWeight!=0) System.out.println("1. classPart");
			if(labWeight!=0) System.out.println("2. lab");
			if(tutWeight!=0) System.out.println("3. tutorial");;
			if(quizWeight!=0) System.out.println("4. quiz");
			System.out.println("5. quit");
			compo = sc.nextInt();
			sc.nextLine();
			if(compo!=5) {
				System.out.println("Enter the mark:\n");
				mark = sc.nextInt();
				sc.nextLine();
				
				switch(compo) {
				case 1:
					classPart = mark;
					break;
				case 2:
					lab = mark;
					break;
				case 3:
					tut = mark;
					break;
				case 4:
					quiz = mark;
					break;}
			}}while(compo!= 5);
	}
	public void setExamMark() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the exam mark:\n");
		exam = sc.nextInt();
		sc.nextLine();	
	}
	
	public Result(String id, int examWeightage, int classPartWeightage, int labWeightage, int quizWeightage, int tutWeightage,boolean hasclasspart, boolean hasgradedlab, boolean hasgradedtut, boolean hasquiz) {//passed in from course, by student
		courseID = id;
		examWeight = examWeightage;
		if(hasclasspart) classPartWeight = classPartWeightage;
		if(hasgradedlab) labWeight = labWeightage;
		if(hasgradedtut) tutWeight = tutWeightage;
		if(hasquiz) quizWeight = quizWeightage;
	}
	
	
	public void calculateMark() {
		overallMark = (examWeight*exam + classPartWeight*classPart + labWeight*lab + tutWeight*tut + quizWeight*quiz)/100;
		
	}
	
	public void calculateGrade() {
		if(overallMark>=80) overallGrade = 'A';
		else if(overallMark>=70 & overallMark<80) overallGrade = 'B';
		else if(overallMark>=60 & overallMark<70) overallGrade = 'C';
		else if(overallMark>=50 & overallMark<60) overallGrade = 'D';
		else overallGrade = 'U';
		
		if(exam>=80) examGrade = 'A';
		else if(exam>=70 & exam<80) examGrade = 'B';
		else if(exam>=60 & exam<70) examGrade = 'C';
		else if(exam>=50 & exam<60) examGrade = 'D';
		else examGrade = 'U';
		
		if(classPartWeight!=0) {
			if(classPart>=80) cpGrade = 'A';
			else if(classPart>=70 & classPart<80) cpGrade = 'B';
			else if(classPart>=60 & classPart<70) cpGrade = 'C';
			else if(classPart>=50 & classPart<60) cpGrade = 'D';
			else cpGrade = 'U';
		}
		
		if(labWeight!=0) {
			if(lab>=80) labGrade = 'A';
			else if(lab>=70 & lab<80) labGrade = 'B';
			else if(lab>=60 & lab<70) labGrade = 'C';
			else if(lab>=50 & lab<60) labGrade = 'D';
			else labGrade = 'U';
		}
		
		if(tutWeight!=0) {
			if(tut>=80) tutGrade = 'A';
			else if(tut>=70 & tut<80) tutGrade = 'B';
			else if(tut>=60 & tut<70) tutGrade = 'C';
			else if(tut>=50 & tut<60) tutGrade = 'D';
			else tutGrade = 'U';
		}
		
		if(quizWeight!=0) {
			if(quiz>=80) quizGrade = 'A';
			else if(quiz>=70 & quiz<80) quizGrade = 'B';
			else if(quiz>=60 & quiz<70) quizGrade = 'C';
			else if(quiz>=50 & quiz<60) quizGrade = 'D';
			else quizGrade = 'U';
		}
		
	}
	
	public void printResult() {
		System.out.println("Course ID:"+courseID);
		calculateMark();
		calculateGrade();
		System.out.println("Overall Mark: "+overallMark +"Overall Grade: "+ overallGrade);
		System.out.println("Exam Mark:"+exam +"Exam Grade: "+ examGrade);
		if(classPartWeight!=0) System.out.println("ClassPart Mark :"+classPart+ "Class Part Grade: "+ cpGrade);
		if(labWeight!=0) System.out.print("Lab Mark :"+lab+ "Lab Grade: "+ labGrade);
		if(tutWeight!=0) System.out.print("Tutorial Mark: "+tut +"Tutorial Grade: "+ tutGrade);;
		if(quizWeight!=0) System.out.print("Quiz Mark: "+quiz +"Quiz Grade: "+ quizGrade);
		System.out.println("-------------------------------------");
	}
	
	public char getOverallGrade() {
		return overallGrade;
	}
	public char getExamGrade() {
		return examGrade;
	}
	public char getClassPartGrade() {
		return cpGrade;
	}
	public char getLabGrade() {
		return labGrade;
	}
	public char getTutGrade() {
		return tutGrade;
	}
	public char getQuizGrade() {
		return quizGrade;
	}
}
