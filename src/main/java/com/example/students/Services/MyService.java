package com.example.students.Services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.example.students.entity.Students;

public interface MyService {
		
	public Students addStudents(Students student);

	public Iterator getStudentByName(String name);

	void favStudents(Integer id);

	Optional<Students> getStudentInfo(Integer id);

	//Students updateMarks(Integer id, Students students);
	
	public Students updateMarks(Integer id, int marks);
	
	public List<Students> getAllstud();
	
	public List<Students> getFavStud();
	
	

}
