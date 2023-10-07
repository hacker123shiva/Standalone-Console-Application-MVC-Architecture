package in.ineuron.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		IStudentController studentController=null;
		String status=null,name=null, city=null, email=null, country=null;
		Integer id=null;
		Student studentRecord=null;
		while(true) {
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.println("Your Option :: [1,2,3,4,5]:: ");
			Integer option =Integer.parseInt(br.readLine());
			
			switch(option) {
			case 1->{
				 System.out.println("Enter the name:: ");
				 name=br.readLine();
				 System.out.println("Enter the city:: ");
				 city=br.readLine();
				 System.out.println("Enter the email:: ");
				 email=br.readLine();
				 System.out.println("Enter the country:: ");
				 country=br.readLine();
				 
				 studentController=StudentControllerFactory.getStudentController();
		         Student student =new Student();
		         student.setName(name);
		         student.setCity(city);
		         student.setEmail(email);
		         student.setCountry(country);
				 status= studentController.save(student);
				 if(status.equalsIgnoreCase("success")) {
					 System.out.println("Record inserted succesfullty");
				 }
				 else if(status.equalsIgnoreCase("failure")) {
					 System.out.println("Record Insertion failed");
				 }
				 else {
					 System.out.println("Some problem occured...");
				 }
			}
			case 2->{
				System.out.println("Enter the id:: ");
				id=Integer.parseInt(br.readLine());
				studentController=StudentControllerFactory.getStudentController();
				studentRecord=studentController.findById(id);
				if(studentRecord!=null)
				System.out.println(studentRecord);
				else
			    System.out.println("Record Not found");
			}
			case 3->{
				System.out.println("Enter the id:: ");
				id=Integer.parseInt(br.readLine());
				studentController=StudentControllerFactory.getStudentController();
				studentRecord=studentController.findById(id);
				if(studentRecord!=null)
				{
					Student newStudent=new Student();
					newStudent.setId(id);
					System.out.println("StudentName ::[Old Name is:: " +studentRecord.getName()+"]: ");
					String newName=br.readLine();
					if(newName.equals("")) {
						newStudent.setName(studentRecord.getName());
					}else {
						newStudent.setName(newName);
					}
					System.out.println("StudentEmail ::[Old Email is:: " +studentRecord.getEmail()+"]: ");
					String newEmail=br.readLine();
					if(newEmail.equals("")) {
						newStudent.setEmail(studentRecord.getEmail());
					}else {
						newStudent.setEmail(newEmail);
					}
					
					System.out.println("StudentCity ::[Old City is:: " +studentRecord.getCity()+"]: ");
					String newCity=br.readLine();
					if(newCity.equals("")) {
						newStudent.setCity(studentRecord.getCity());
					}else {
						newStudent.setCity(newCity);
					}
					
					System.out.println("StudentCountry ::[Old Country is:: " +studentRecord.getCountry()+"]: ");
					String newCountry=br.readLine();
					if(newCountry.equals("")) {
						newStudent.setCity(studentRecord.getCountry());
					}else {
						newStudent.setCountry(newCountry);
					}
					
				  status=studentController.updateByStudent(newStudent);
				  if(status.equalsIgnoreCase("success")) {
						 System.out.println("Record Updated succesfullty");
					 }
					 else if(status.equalsIgnoreCase("failure")) {
						 System.out.println("Record Updateion failed");
					 }
				}
				else
			    System.out.println("Record Not found");
			}
			case 4->{	System.out.println("Enter the id:: ");
			id=Integer.parseInt(br.readLine());
			 studentController=StudentControllerFactory.getStudentController();
			status=studentController.deleteById(id);
			if(status.equalsIgnoreCase("success")) {
				 System.out.println("Record deleted succesfullty");
			 }
			 else if(status.equalsIgnoreCase("failure")) {
				 System.out.println("Record deletion failed");
			 }
			 else {
				 System.out.println("Record not available for id to delete ");
			 }
			}
			case 5->{
				System.out.println("Thanks for using the application");
				System.exit(0);
			}
			}
		}
		
		  
	}

}
