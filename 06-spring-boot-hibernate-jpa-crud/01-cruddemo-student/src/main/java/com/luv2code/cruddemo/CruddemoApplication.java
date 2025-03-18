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
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);

			queryForStudents(studentDAO);
		};
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
