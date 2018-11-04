package oodpver1.pkg1;

import java.util.*;


public class Course {
	private String course_name, course_code;
	ArrayList<Component> arrTut = new ArrayList<Component>();
	ArrayList<Component> arrLab = new ArrayList<Component>();
	ArrayList<Student> studentList = new ArrayList<Student>();
	ArrayList<Professor> profList = new ArrayList<Professor>();
	private int courseVacancy;
	private int examWeightage,classPartWeightage,labWeightage,quizWeightage,tutWeightage;
	private boolean hasclasspart, hasgradedlab, hasgradedtut, hasquiz;
	Scanner sc = new Scanner(System.in);
	
	public Course(String name, String code, int vacancy) {
		course_name=name;
		course_code = code;
		courseVacancy = vacancy;
		Lecture lect1 = new Lecture();
		lect1.setVacancy(vacancy);
	}
	
	public Course() {};
	
	public String getName() {
		return course_name;
	}
	
	public String getCode() {
		return course_code;
	}
	
	public int getVacancy() {
		return courseVacancy;
	}
	
	public void setVacancy(int vacancy) {
		courseVacancy = vacancy;
	}
	
	public void setCode(String code) {
		course_code = code;
	}
	
	public void setName(String name) {
		course_name = name;
	}
	
	public void addLab(String name, int vacancy) {
		Component lab1 = new Component();
			lab1.setVacancy(vacancy);
			lab1.setGroup(name);
			arrLab.add(lab1);
			System.out.println("New lab class created!");
			//Class name: "+ arrTut.lastElement().getName()+" with vacancy of "+tut.lastElement().getVacancy());
		}
	
	public void addTut(String name, int vacancy) {
		Component tut1 = new Component();
			tut1.setVacancy(vacancy);
			tut1.setGroup(name);
			arrTut.add(tut1);
			System.out.println("New tut class created!");
		}
		
	
	public void addProf(String profName, String profRole, int officeNo) {
		Professor prof1 = new Professor();
		prof1.setProfName(profName);
		prof1.setProfRole(profRole);
		prof1.setOfficeNo(officeNo);
		profList.add(prof1);
	}
		
	public void setClassPart(int classpart) {
		hasclasspart = true;
		classPartWeightage = classpart;
	}
	
	public void setExamWeightage(int examweight) {
		examWeightage = examweight;
	}
	
	public void setLabWeightage(int labweight) {
		hasgradedlab = true;
		labWeightage = labweight;
	}
	
	public void setTutWeightage(int tutweight) {
		hasgradedtut = true;
		tutWeightage = tutweight;
	}
	
	public void setQuizWeightage(int quizweight) {
		hasquiz = true;
		quizWeightage = quizweight;
	}
	
	public void setExamWeightage() {
		examWeightage = 100 - classPartWeightage - labWeightage - quizWeightage - tutWeightage;
	}
	
	public int getClassPartWeightage() {
		return classPartWeightage;
	}
	
	public int getExamWeightage() {
		return examWeightage;
	}
	
	public int getLabWeightage() {
		return labWeightage;
	}
	
	public int getTutWeightage() {
		return tutWeightage;
	}
	
	public int getQuizWeightage() {
		return quizWeightage;
	}
	public boolean hasClassPart() {
		return hasclasspart;
	}
	public boolean haslab() {
		return hasgradedlab;
	}
	public boolean hasquiz() {
		return hasquiz;
	}
	public boolean hastut() {
		return hasgradedtut;
	}
	
	
	
	public void registerStudent(Student std) {
		boolean found = false;
		// just to register student into the course
		
		//check matri number is not entered wrongly
		////......
		
		// cannot register the same course again
		if (studentList.contains(std)){
			System.out.println("student alr register for course");
			//throw error message
			return;
		}
		
		if (courseVacancy>0) {
			courseVacancy--;
			studentList.add(std);
			System.out.println("Student registered into course " + course_name);
			//assign student into tut/lab class
			this.displayClass();
			if (!arrTut.isEmpty()) {
			System.out.println("Pls enter the tutorial group that you want to enrol in:");
			String name=sc.next();
			found = assignTutClass(name, std);
			if(found == false)
				return;}
			if (!arrLab.isEmpty()) {
				System.out.println("Pls enter the lab group that you want to enrol in:");
				String name=sc.next();
				this.assignLabClass(name, std);
				
			}
			//i want to add course inside student's course list at the same time also
			//both not done yet
			
			}
			
	}
	
	public void displayClass() {
		//display all the dif tut/lab class, with their vacancies
		if (!arrTut.isEmpty()) {
		System.out.println("All the tutorial classes in course " + course_name);
		// The Iterator object is obtained using iterator() method
		Iterator<Component> it = arrTut.iterator();
		 // To iterate through the elements of the collection we can use hasNext() and next() methods of Iterator
		while(it.hasNext()) {
			//System.out.println("display class iterator! (tut)");
			it.next().printGroup();
			//it.next().printStudent();
		}
		}
		
		if (!arrLab.isEmpty()) {
			System.out.println("All the lab classes in course" + course_name);
			Iterator<Component> it = arrLab.iterator();
			while(it.hasNext()) {
				//System.out.println("display class iterator! (lab)");
				it.next().printGroup();
				//it.next().printStudent();
			}
			}
		
	}
	
	public boolean assignTutClass(String c, Student std) {
		// error message if c not in this course
		boolean found = false;

		//and if register method throws error ( no vacancy in the class), error message
		//maybe prompt to join the other tut/lab grp if have vacancy
		Iterator<Component> it2 = arrTut.iterator();
		Component temp;
			while(it2.hasNext()) {
				temp = it2.next();
				if (c.equals(temp.getGroup())) {
					temp.assignSlot(std);
					found = true;
					//if register method throw error? 
					//ie no vancancy in the tut class?
					//or student alr registered
				}if(found == false)
					System.out.println("Tutorial class not provided under this course!");
			}
			return found;
		}
	

	public boolean assignLabClass(String c, Student std) {
		// error message if c not in this course
		boolean found = false;
		Component temp;
		//and if register method throws error ( no vacancy in the class), error message
		//maybe prompt to join the other tut/lab grp if have vacancy
		Iterator<Component> it2 = arrLab.iterator();
			while(it2.hasNext()) {
				temp = it2.next();
				if (c.equals(temp.getGroup())) {
					temp.assignSlot(std);
					found = true;
					//if register method throw error? 
					//ie no vancancy in the tut class?
					//or student alr registered
				}
				if(found == false)
				System.out.println("Lab class not provided under this course!");
			}
			return found;
}
	public void printStatistic() {
		   	int compo;
		   	Student std=null;
		   	double noOfA=0, noOfB=0, noOfC=0, noOfD=0, noOfU=0;
		   	if (studentList.size()==0) {
		   		System.out.println("This course does not have any student yet.");}
		   	else {   		
		   	do{
				System.out.println("Which component do you want to view?\n");
				System.out.println("1. exam");
				if(hasclasspart) System.out.println("2. classPart");
				if(hasgradedlab) System.out.println("3. lab");
				if(hasgradedtut) System.out.println("4. tutorial");;
				if(hasquiz) System.out.println("5. quiz");
				System.out.println("6. Overall");
				System.out.println("7. Quit");
				compo = sc.nextInt();
				sc.nextLine();
					switch(compo) {
					case 1:	
						Iterator<Student> it = studentList.iterator();
						while(it.hasNext()) {
							std = it.next();
							if (std.getResult(course_code).getExamGrade()=='A') noOfA++;
							if (std.getResult(course_code).getExamGrade()=='B') noOfB++;
							if (std.getResult(course_code).getExamGrade()=='C') noOfC++;
							if (std.getResult(course_code).getExamGrade()=='D') noOfD++;
							if (std.getResult(course_code).getExamGrade()=='U') noOfU++;
							}
						System.out.println("Percantage of A for the Exam: " + (noOfA/studentList.size())*100 +"%");
						System.out.println("Percantage of B for the Exam: " + (noOfB/studentList.size())*100 +"%");
						System.out.println("Percantage of C for the Exam: " + (noOfC/studentList.size())*100 +"%");
						System.out.println("Percantage of D for the Exam: " + (noOfD/studentList.size())*100 +"%");
						System.out.println("Percantage of U for the Exam: " + (noOfU/studentList.size())*100 +"%");
						noOfA=0;
						noOfB=0;
						noOfC=0;
						noOfD=0;
						noOfU=0;
						break;
						
					case 2:	
						Iterator<Student> it1 = studentList.iterator();
						while(it1.hasNext()) {
							std = it1.next();
							if (std.getResult(course_code).getClassPartGrade()=='A') noOfA++;
							if (std.getResult(course_code).getClassPartGrade()=='B') noOfB++;
							if (std.getResult(course_code).getClassPartGrade()=='C') noOfC++;
							if (std.getResult(course_code).getClassPartGrade()=='D') noOfD++;
							if (std.getResult(course_code).getClassPartGrade()=='U') noOfU++;
							}
						System.out.println("Percantage of A for the Class Part: " + (noOfA/studentList.size())*100 +"%");
						System.out.println("Percantage of B for the Class Part: " + (noOfB/studentList.size())*100 +"%");
						System.out.println("Percantage of C for the Class Part: " + (noOfC/studentList.size())*100 +"%");
						System.out.println("Percantage of D for the Class Part: " + (noOfD/studentList.size())*100 +"%");
						System.out.println("Percantage of U for the Class Part: " + (noOfU/studentList.size())*100 +"%");
						noOfA=0;
						noOfB=0;
						noOfC=0;
						noOfD=0;
						noOfU=0;
						break;
					case 3:	
						Iterator<Student> it2 = studentList.iterator();
						while(it2.hasNext()) {
							std = it2.next();
							if (std.getResult(course_code).getLabGrade()=='A') noOfA++;
							if (std.getResult(course_code).getLabGrade()=='B') noOfB++;
							if (std.getResult(course_code).getLabGrade()=='C') noOfC++;
							if (std.getResult(course_code).getLabGrade()=='D') noOfD++;
							if (std.getResult(course_code).getLabGrade()=='U') noOfU++;
							}
						System.out.println("Percantage of A for the Lab: " + (noOfA/studentList.size())*100 +"%");
						System.out.println("Percantage of B for the Lab: " + (noOfB/studentList.size())*100 +"%");
						System.out.println("Percantage of C for the Lab: " + (noOfC/studentList.size())*100 +"%");
						System.out.println("Percantage of D for the Lab: " + (noOfD/studentList.size())*100 +"%");
						System.out.println("Percantage of U for the Lab: " + (noOfU/studentList.size())*100 +"%");
						noOfA=0;
						noOfB=0;
						noOfC=0;
						noOfD=0;
						noOfU=0;
						break;
					case 4:	
						Iterator<Student> it3 = studentList.iterator();
						while(it3.hasNext()) {
							std = it3.next();
							if (std.getResult(course_code).getTutGrade()=='A') noOfA++;
							if (std.getResult(course_code).getTutGrade()=='B') noOfB++;
							if (std.getResult(course_code).getTutGrade()=='C') noOfC++;
							if (std.getResult(course_code).getTutGrade()=='D') noOfD++;
							if (std.getResult(course_code).getTutGrade()=='U') noOfU++;
							}
						System.out.println("Percantage of A for the Tutorial: " + (noOfA/studentList.size())*100 +"%");
						System.out.println("Percantage of B for the Tutorial: " + (noOfB/studentList.size())*100 +"%");
						System.out.println("Percantage of C for the Tutorial: " + (noOfC/studentList.size())*100 +"%");
						System.out.println("Percantage of D for the Tutorial: " + (noOfD/studentList.size())*100 +"%");
						System.out.println("Percantage of U for the Tutorial: " + (noOfU/studentList.size())*100 +"%");
						noOfA=0;
						noOfB=0;
						noOfC=0;
						noOfD=0;
						noOfU=0;
						break;
					case 5:	
						Iterator<Student> it4 = studentList.iterator();
						while(it4.hasNext()) {
							std = it4.next();
							if (std.getResult(course_code).getQuizGrade()=='A') noOfA++;
							if (std.getResult(course_code).getQuizGrade()=='B') noOfB++;
							if (std.getResult(course_code).getQuizGrade()=='C') noOfC++;
							if (std.getResult(course_code).getQuizGrade()=='D') noOfD++;
							if (std.getResult(course_code).getQuizGrade()=='U') noOfU++;
							}
						System.out.println("Percantage of A for the Quiz: " + (noOfA/studentList.size())*100 +"%");
						System.out.println("Percantage of B for the Quiz: " + (noOfB/studentList.size())*100 +"%");
						System.out.println("Percantage of C for the Quiz: " + (noOfC/studentList.size())*100 +"%");
						System.out.println("Percantage of D for the Quiz: " + (noOfD/studentList.size())*100 +"%");
						System.out.println("Percantage of U for the Quiz: " + (noOfU/studentList.size())*100 +"%");
						noOfA=0;
						noOfB=0;
						noOfC=0;
						noOfD=0;
						noOfU=0;
						break;
					case 6:	
						Iterator<Student> it5 = studentList.iterator();
						while(it5.hasNext()) {
							std = it5.next();
							if (std.getResult(course_code).getOverallGrade()=='A') noOfA++;
							if (std.getResult(course_code).getOverallGrade()=='B') noOfB++;
							if (std.getResult(course_code).getOverallGrade()=='C') noOfC++;
							if (std.getResult(course_code).getOverallGrade()=='D') noOfD++;
							if (std.getResult(course_code).getOverallGrade()=='U') noOfU++;
							}
						System.out.println("Percantage of A for the Overall: " + (noOfA/studentList.size())*100 +"%");
						System.out.println("Percantage of B for the Overall: " + (noOfB/studentList.size())*100 +"%");
						System.out.println("Percantage of C for the Overall: " + (noOfC/studentList.size())*100 +"%");
						System.out.println("Percantage of D for the Overall: " + (noOfD/studentList.size())*100 +"%");
						System.out.println("Percantage of U for the Overall: " + (noOfU/studentList.size())*100 +"%");
						noOfA=0;
						noOfB=0;
						noOfC=0;
						noOfD=0;
						noOfU=0;
						break;
					case 7: break;}
					}while(compo!=6);
		   	}
		}
	}
