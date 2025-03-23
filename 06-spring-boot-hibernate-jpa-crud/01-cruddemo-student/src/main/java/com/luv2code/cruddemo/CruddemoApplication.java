package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);

//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//		updateStudent(studentDAO);
//		deleteStudent(studentDAO);
//		deleteAllStudent(studentDAO);

		};

	}
	private  void deleteAllStudent(StudentDAO studentDAO){
		int numStudentsDeleted=studentDAO.deleteAll();
		System.out.println("No of students deleted:"+numStudentsDeleted);
	}
	private void deleteStudent(StudentDAO studentDAO){
		int studentId=2;
		System.out.println("Deleting student id:"+studentId);
		studentDAO.deleteStudent(studentId);

	}
	private void updateStudent(StudentDAO studentDAO){
		//retrieve student based on primary key
		int studentId=1;
		Student myStudent=studentDAO.findById(studentId);
		System.out.println(myStudent);
		System.out.println("Updating Student....");

		//change first name to scooby
		myStudent.setFirstName("Supriya");
		//update the student
		studentDAO.updateStudent(myStudent);

		//display the updated student
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findByLastName("Singh");
		//display the students
		System.out.println(theStudents);

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();
		//display a list of students
		for(Student s:theStudents){
			System.out.println(s);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		Student n=new Student("Daisy","Duck","dd@gm.com");
		//save the student
		studentDAO.save(n);

		//display id of the saved student
		System.out.println(n.getId());;
		//retrive studnet based on the id
		Student s=studentDAO.findById(n.getId());
		System.out.println(studentDAO.findById(n.getId()));
		//display student
		System.out.println("Found the student:"+s);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating multiple students");
		Student tempStudent1=new Student("John","Doe","jd@gmil.com");
		Student tempStudent2=new Student("Mary","Pubin","mp@gmil.com");
		Student tempStudent3=new Student("Kerry","Hills","kerryHills@gmil.com");


		//save the student objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object

		System.out.println("Creating the student object");
		Student tempStudent=new Student("Supriya","Singh","singhsupriya711@gmail.com");

		//save the student object
		System.out.println("saving the object");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student id:generated id:"+tempStudent.getId());


	}
}
