package com.example.students.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.students.Services.MyService;
import com.example.students.entity.Students;

@RestController
public class Mycontroller {
	@Autowired
	
	private MyService myservice;
	
	@GetMapping("/studentworld")
	public String studentWorld() {
		return "Welcome to student repository";
	}
	
	@PostMapping("/addstudents")
	public Students addStudents(@RequestBody Students student) {
		return this.myservice.addStudents(student);
	}
	@GetMapping("/getstudents/{id}")
	public Optional<Students> getStudentInfos(@PathVariable Integer id) {
		return this.myservice.getStudentInfo(id);
	}
//	//@PutMapping("/updatestudents/{id}")
//	public Students updateMarks(@RequestBody Students students, @PathVariable Integer id) {
//		System.out.println("This is markss");
//		return this.myservice.updateMarks(id, students);
//	}
	@PutMapping("/updatestudents/{id}")
	public Students updateMarks(@RequestBody int marks, @PathVariable Integer id) {
		System.out.println("This is markss");
		return this.myservice.updateMarks(id, marks);
	}
	
	@GetMapping("/studentbyname/{name}")
	public Iterator getStudentByName(@PathVariable String name) {
		return this.myservice.getStudentByName(name);
	}
	@PostMapping("/favstudents/{id}")
	void favStudents(@PathVariable Integer id) {
	    this.myservice.favStudents(id);
	}
	@GetMapping("/allstudents")
	public List<Students> getAllstud(){
		return this.myservice.getAllstud();
				
	}
	@GetMapping("/allfavstud")
	public List<Students> getFavStud(){
		return this.myservice.getFavStud();
		
	}

}
