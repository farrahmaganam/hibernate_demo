package com.hibernate.hibernate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.hibernate.hibernate_demo.dao.StudentDao;
import com.hibernate.hibernate_demo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
			//readStudent(studentDao);
			//queryStudent(studentDao);
			//queryStudentByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);	
			//deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao){
		System.out.println("Deleting all student information...");
		int rowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + rowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int id = 22;
		System.out.println("Deleting ID: " + id);
		studentDao.delete(id);
	}

	private void updateStudent(StudentDao studentDao) {
		int id = 1;
		System.out.println("Student ID:" + id);
		Student student = studentDao.findbyId(id);

		System.out.println("Updating student name...");	
		student.setFirstName("Dark");

		studentDao.update(student);

		System.out.println("Updated student information: " + student);	
	}

	private void queryStudentByLastName(StudentDao studentDao) {
		System.out.println("Retrieving students with last name 'Yagami'...");
		List<Student> students = studentDao.findByLastName("Yagami");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryStudent(StudentDao studentDao) {
		System.out.println("Retrieving all students...");
		List<Student> students = studentDao.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {

		System.out.println("Retrieving student id 2...");
		Student student = studentDao.findbyId(1);

		System.out.println("Found the student" + student);
	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating student information...");
		Student student = new Student("Light",
																	"Yagami", 
																	"light.yagami@example.com");
		
		System.out.println("Saving student information...");
		studentDao.save(student);

		System.out.println("Saved! Generated id: " + student.getId());
	}
}
