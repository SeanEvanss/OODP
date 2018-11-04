package oodpver1.pkg1;
import java.util.*;
import java.util.Iterator;
import java.util.*;
import java.util.Iterator;

public class SCRAME {

	public static void main(String[] args) {
            
            
		ArrayList<Student> Students = new ArrayList<Student>();
		ArrayList<Course> Courses = new ArrayList<Course>();
		int choice=0;
		Course course1;
		while(choice != 11)
		{
			System.out.println();
			System.out.println("------------ Welcome to SCRAME! ------------");
			System.out.println("1. Add a student");
			System.out.println("2. Add a course");
			System.out.println("3. Register student for course");
			System.out.println("4. Check available slot in a class");
			System.out.println("5. Print student by lecture, tutorial, or lab");
			System.out.println("6. Enter course assessment components weightage");
			System.out.println("7. Enter coursework mark (including subcomponents)");
			System.out.println("8. Enter exam mark");
			System.out.println("9. Print course statistics");
			System.out.println("10. Print student transcript");
			System.out.println("11. Exit");
			System.out.println("Enter the number of your choice: ");
			
                        Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			String dummy=null;
			
                        switch(choice) {
			case 1: String matric, name;
					int isvalid = 1;
					System.out.println("Enter Matric. Number of the student:");
					matric = sc.next();
					sc.nextLine();
					//for(int i=0.....), loop thru csv file to check if matric alr exists. If exist, throw back error and stop.
					for(int i=0;i<Students.size();i++) {
						String temp=Students.get(i).getStudentMatric();
						if(temp.equals(matric)) {
							System.out.println("Error! That student already exists in database!");
							isvalid = 0;
							
							break;
						}
					}
					if(isvalid == 1) {
					System.out.println("Enter the name of the student:");
					name = sc.nextLine();
					Student student1 = new Student(matric,name);
					Students.add(student1);
					System.out.println("Success! Student has been added.");
					}
			break;
			
			case 2: String coursecode, coursename, tutname, labname, profrole, profname;
					int vacancy, labcapacity, tutcapacity, nooflabs, nooftut, noofprofs, officenum;
					System.out.println("Enter code of course to add:");
					coursecode = sc.next();
					sc.nextLine();
					System.out.println("Enter name of course to add:");
					coursename = sc.nextLine();
					System.out.println("Enter number of vacancies for the course:");
					vacancy = sc.nextInt();
					System.out.println("Enter number of lab groups for the course:");
					nooflabs = sc.nextInt();
					System.out.println("Enter number of tutorial groups for the course:");
					nooftut = sc.nextInt();
					course1 = new Course(coursename, coursecode, vacancy);
					Courses.add(course1);
					for(int i=1;i<=nooflabs;i++) {
						System.out.println("Enter name of lab group " + i + ":");
						labname = sc.next();
						System.out.println("Enter capacity for lab " + labname + ":" );
						labcapacity = sc.nextInt();
						course1.addLab(labname, labcapacity);
					}
					for(int i=1;i<=nooftut;i++) {
						System.out.println("Enter name of tutorial group " + i + ":");
						tutname = sc.next();
						System.out.println("Enter capacity for tutorial " + tutname + ":" );
						tutcapacity = sc.nextInt();
						course1.addTut(tutname, tutcapacity);
					}
//					System.out.println("Enter how many professors are to be assigned to this course:");
//					noofprofs = sc.nextInt();
//					sc.nextLine();
//					for(int i=0;i<noofprofs;i++) {
//					System.out.println("Enter name of professor" + (i+1) + ":");
//					profname = sc.nextLine();
//					System.out.println("Enter role of professor:");
//					profrole = sc.nextLine();
//					System.out.println("Enter office number of professor:");
//					officenum = sc.nextInt();
//					sc.nextLine();
//					course1.addProf(profname, profrole, officenum);
//					}
					System.out.println("Success, course has been added! Don't forget to go enter course assessment components weightage!" );
			break;
			
			case 3: 
				sc.nextLine();
				System.out.println("Enter the matri of student:");
				//dummy=sc.next();	
				String matri = sc.nextLine();
				Iterator<Student> it =Students.iterator();
				
                                
                                Student std=null;
				Boolean found=false;
				while(it.hasNext()) {
					System.out.println("SEARCHING!");
					std= it.next();
					String temp=std.getStudentMatric();
					if (temp.equals(matri)) {
						found=true;
						System.out.println("Student found!");
						break;
					}
				}
				if (found==false) {
					System.out.println("Error! Student not found!");
					break;
				}else found=false;
				
				System.out.println("Enter the course code to register student in:");
				String code = sc.nextLine();
				Iterator<Course> it2 = Courses.iterator();
				while(it2.hasNext()) {
					Course temp=it2.next();
					if (temp.getCode().equals(code)) {
						temp.registerStudent(std);
						std.addMod(code, temp.getExamWeightage(), temp.getClassPartWeightage(),temp.getLabWeightage(), temp.getQuizWeightage(), temp.getTutWeightage(), temp.hasClassPart(), temp.haslab(), temp.hastut(), temp.hasquiz());
						System.out.println("Success! Student "+ std.getStudentName()+" registered to course "+temp.getCode());
						found=true;
					}
				}
				if (found==false) {
					System.out.println("Error! Course not found!");
				}
				break;
				
			case 4: 
					sc.nextLine();
					String codeofcourse, classtype;
					int coursevacancy = 0;
					Course temp = new Course();
					boolean flag = false;
					System.out.println("Enter course code:");
					codeofcourse = sc.nextLine();
					Iterator<Course> it3 = Courses.iterator();
					while(it3.hasNext()) {
						temp = it3.next();
						if (temp.getCode().equals(codeofcourse)) {
							flag=true;
							coursevacancy = temp.getVacancy();
							break;
						}
					}
					if(flag==false) {
							System.out.println("Error! Course not found!");
							break;
					}
					flag = false;
					System.out.println("Enter tutorial, lab or lecture:");
					classtype = sc.next();
					sc.nextLine();
					if(classtype.equals("lecture")) {
						System.out.println("The vacancy of the lecture class for " + codeofcourse + " is " + coursevacancy);
					}
					else if(classtype.equals("tutorial")) {
						System.out.println("Enter the tutorial name:");
						String nameoftut = sc.nextLine();
						Iterator<Component> tut_it = temp.arrTut.iterator();
						while(tut_it.hasNext()) {
							Component placeholder =tut_it.next();
							if (placeholder.getGroup().equals(nameoftut)) {
								flag=true;
								System.out.println("The vacancy of the tutorial class for " + nameoftut + " is " + placeholder.getVacancy());
							break;
							}
						}
							if(flag == false)
								System.out.println("Error! No such tutorial class found!");
							flag = false;
					}
					else if(classtype.equals("lab")) {
						System.out.println("Enter the lab name:");
						String nameoflab = sc.nextLine();
						Iterator<Component> lab_it = temp.arrLab.iterator();
						while(lab_it.hasNext()) {
							Component placeholder2 =lab_it.next();
							if (placeholder2.getGroup().equals(nameoflab)) {
								flag=true;
								System.out.println("The vacancy of the lab class " + nameoflab + " is " + placeholder2.getVacancy());
							break;
							}
						}
							if(flag == false)
								System.out.println("Error! No such lab class found!");
							flag = false;
					}
					else
						System.out.println("Error! Invalid entry!");
			break;
			
			case 5: 
					sc.nextLine();
					boolean flag2 = false;
					Course temp2 = new Course();
					Student tempstd;
					System.out.println("Enter course code:");
					codeofcourse = sc.nextLine();
					Iterator<Course> it4 = Courses.iterator();
					while(it4.hasNext()) {
						temp2 = it4.next();
						if (temp2.getCode().equals(codeofcourse)) {
							flag2=true;
							break;
						}
					}
					if(flag2==false) {
							System.out.println("Error! Course not found!");
							break;
					}
					flag2 = false;
					System.out.println("Do you want to print for lecture, tutorial, or lab?");
					classtype = sc.next();
					if(classtype.equals("lecture")) {
						Iterator<Student> it5 = temp2.studentList.iterator();
						System.out.println("The list of students in the lecture for " + temp2.getCode() + " are:");
						while(it5.hasNext()) {
							tempstd = it5.next();
							System.out.println(tempstd.getStudentMatric() + "         " + tempstd.getStudentName());
						}
					}
					else if(classtype.equals("tutorial")) {
					sc.nextLine();
					System.out.println("Enter the tutorial class name:");	
					String nameoftut = sc.nextLine();
					Iterator<Component> tut_it2 = temp2.arrTut.iterator();
					while(tut_it2.hasNext()) {
						Component placeholder2 =tut_it2.next();
						if (placeholder2.getGroup().equals(nameoftut)) {
							flag2=true;
							System.out.println("The list of students in the tutorial class " + nameoftut + " are:");
							Iterator<Student> tut_it3 = placeholder2.studentList.iterator();
							while(tut_it3.hasNext()) {
								tempstd = tut_it3.next();
								System.out.println(tempstd.getStudentMatric() + "         " + tempstd.getStudentName());
							}
						break;
						}
					}
						if(flag2 == false)
							System.out.println("Error! No such tutorial class found!");
						flag2 = false;
					}
					else if(classtype.equals("lab")) {
						sc.nextLine();
						System.out.println("Enter the lab class name:");	
						String nameoflab = sc.nextLine();
						Iterator<Component> lab_it = temp2.arrLab.iterator();
						while(lab_it.hasNext()) {
							Component placeholder3 =lab_it.next();
							if (placeholder3.getGroup().equals(nameoflab)) {
								flag2=true;
								System.out.println("The list of students in the tutorial class " + nameoflab + " are:");
								Iterator<Student> tut_it3 = placeholder3.studentList.iterator();
								while(tut_it3.hasNext()) {
									tempstd = tut_it3.next();
									System.out.println(tempstd.getStudentMatric() + "         " + tempstd.getStudentName());
								}
							break;
							}
						}
							if(flag2 == false)
								System.out.println("Error! No such tutorial class found!");
							flag2 = false;
					}
					else
						System.out.println("Error! Invalid entry!");
					break;
					
			case 6:
				Course temp3;
				int index = 0;
				boolean flag3 = false;
				sc.nextLine();
				System.out.println("Enter course code of course you want to assign assessment components weightage to:" );
				
				codeofcourse = sc.nextLine();
				Iterator<Course> it6 = Courses.iterator();
				while(it6.hasNext()) {
					temp3 = it6.next();
					if (temp3.getCode().equals(codeofcourse)) {
						flag3=true;
						index = Courses.indexOf(temp3);
						break;
					}
				}
				if(flag3==false) {
						System.out.println("Error! Course not found!");
						break;
				}
				
				System.out.println("Does this course have class participation marks (1 = Yes, 2 = No):");
				if(sc.nextInt()==1) {
					System.out.println("Enter weightage of class participation component (1-100):");
					Courses.get(index).setClassPart(sc.nextInt());
					sc.nextLine();
				}
				System.out.println("Does this course have graded lab (1 = Yes, 2 = No):");
				if(sc.nextInt()==1) {
					System.out.println("Enter weightage of graded lab component (1-100):");
					Courses.get(index).setLabWeightage(sc.nextInt());
					sc.nextLine();
				}
				System.out.println("Does this course have mid-term quiz (1 = Yes, 2 = No):");
				if(sc.nextInt()==1) {
					System.out.println("Enter weightage of mid-term quiz component (1-100):");
					Courses.get(index).setQuizWeightage(sc.nextInt());
					sc.nextLine();
				}
				System.out.println("Does this course have graded tutorials (1 = Yes, 2 = No):");
				if(sc.nextInt()==1) {
					System.out.println("Enter weightage of graded tutorials component (1-100):");
					Courses.get(index).setTutWeightage(sc.nextInt());
					sc.nextLine();
				}
				Courses.get(index).setExamWeightage();
				System.out.println("Success! Assessment component weightages have been assigned to course " + Courses.get(index).getCode());
			break;
				case 7:
					Iterator<Student> it5=Students.iterator();
                                        std = null;
					found =null;
					String m;
					Result result = null;
					sc.nextLine();
					System.out.println("Enter the matri of student:");
					//dummy=sc.next();	
					matri = sc.nextLine();
					while(it5.hasNext()) {
						System.out.println("SEARCHING!");
						std= it5.next();
						m=std.getStudentMatric();
						if (m.equals(matri)) {
							found=true;
							System.out.println("Student found!");
							break;
						}
					}
					if (found==false) {
						System.out.println("Error! Student not found!");
						break;
					}else found=false;
					
					sc.nextLine();
					System.out.println("Enter the course code to enter course work mark:");
					code = sc.nextLine();
					
					result = std.getResult(code);
					result.setCourseWorkMark();
					break;
				case 8:
					Iterator<Student> it7=Students.iterator();
                                        std = null;
					found =null;
					result = null;
					sc.nextLine();
					System.out.println("Enter the matri of student:");
					//dummy=sc.next();	
					matri = sc.nextLine();
					while(it7.hasNext()) {
						std= it7.next();
						m=std.getStudentMatric();
						if (m.equals(matri)) {
							found=true;
							System.out.println("Student found!");
							break;
						}
					}
					if (found==false) {
						System.out.println("Error! Student not found!");
						break;
					}else found=false;
					
					sc.nextLine();
					System.out.println("Enter the course code to enter course work mark:");
					code = sc.nextLine();
					result = std.getResult(code);
					result.setExamMark();
					break;
				case 9:
				    flag = false;
				    Course course=null;
				    int n;
				    sc.nextLine();
					System.out.println("Enter course code:");
					m = sc.nextLine();//m is the course code
					Iterator<Course> it9 = Courses.iterator();
					while(it9.hasNext()) {
						temp = it9.next();
						if (temp.getCode().equals(m)) {
							flag=true;
							course = temp;
							break;
						}
					}
					if(flag==false) {
							System.out.println("Error! Course not found!");
							break;
					}
					flag = false;
					
					course.printStatistic();
					break;
				case 10:
					Iterator<Student> it8=Students.iterator();
			        std = null;
					found =null;
					result = null;
					sc.nextLine();
					System.out.println("Enter the matri of student:");
					//dummy=sc.next();	
					matri = sc.nextLine();
					while(it8.hasNext()) {
						std= it8.next();
						m=std.getStudentMatric();
						if (m.equals(matri)) {
							found=true;
							System.out.println("Student found!");
							break;
						}
					}
				
					std.printTranscript();
					break;
				case 11: System.out.println("Exiting...");
				break;
				default: break;
				}
			}
		}

	}
	
			
