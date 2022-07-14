package com.example.students.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.example.students.entity.Students;
import com.example.students.repository.Repository;

@Service
public class ServiceImpl implements MyService {
	
	@Autowired
	SessionFactory session;

	@Autowired
	Repository repository;

	@Autowired
	Students s;

	List<Students> list = new ArrayList<>();

	public List<Students> getAllstud() {
		return repository.findAll();
	}

	public Students addStudents(Students student) {
		s.setId(5);
		s.setName(student.getName());
		s.setMarks(student.getMarks());
		repository.save(s);
		return s;
	}

	@Override
	public Optional<Students> getStudentInfo(Integer id) {
		return repository.findById(id);

	}

	//@Override
	//public Students updateMarks(Integer id, Students students) {
		//Students s1 = repository.findById(id).get();
		//s1.setMarks(marks);
		//return repository.save(students);

	//}
	
	@Override
		public Students updateMarks(Integer id, int marks) {
			Students s1 = repository.findById(id).get();
			s1.setMarks(marks);
			return repository.save(s1);
		}
		

	@Override
	public Iterator getStudentByName(String name) {

//		List<Students> slist = repository.findAll();

		//		List<Students> foundByName = new ArrayList<Students>();
//		for (Students s : slist) {
//			if (s.getName() == (name)) {
//				
//				foundByName.add(s);
//			}
//		}
//		List<Students> foundByName = new ArrayList<Students>();
//		slist.forEach(s -> {
//			if (s.getName().equals(name)) {
//				foundByName.add(s);
//			}
//		});
		Criteria crit = session.openSession().createCriteria(Students.class);
		crit.add(Restrictions.eq("name", name));
		return crit.list().iterator();
		
	}

	@Override
	public void favStudents(Integer id) {
		System.out.println("got id in impl " + id);
		Students s = repository.findById(id).get();
		s.setFavorite(!s.isFavorite());
		repository.save(s);
	}

	public List<Students> getFavStud() {
		List<Students> list = repository.findAll();
		
		List<Students> favStud = new ArrayList<Students>();

		for (Students m : list) {
			if (m.isFavorite()== true )
			{
				favStud.add(m);
			}
		}
		return favStud;
	}

}