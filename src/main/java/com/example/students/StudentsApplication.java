package com.example.students;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		StudentTest.updateStudents();
		StudentTest.deleteStudent();
		StudentTest.readStudent();
		StudentTest.selectStudent();
		
	
	}

}
