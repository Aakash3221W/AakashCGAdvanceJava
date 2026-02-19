package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class StudentDAOImple implements StudentDAO {
	
	private EntityManager entityManger;
	
	@Autowired
	StudentDAOImple(EntityManager  entityManger){
		this.entityManger = entityManger;
	}
	
	
	@Override
	public List<Student> getAllStudents() {
		
		TypedQuery<Student> theQuery = entityManger.createQuery("Select s from Student s",Student.class);
		
		return theQuery.getResultList();
	}
	
	@Override
	public Student getStudentByIFirstName(String id){
		Student temp  = entityManger.find(Student.class, id);
		if(temp == null) {
			throw new StudentNotFoundException("Student with id: " + id + " not found");
		}
		return temp;
	}

}
