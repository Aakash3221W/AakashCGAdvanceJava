package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	StudentDAOImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}
	
	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}
	
	@Override
	@Transactional
	public void update(Student student,int id){
		
		Student tempStudent  =  findById(id);
		if(tempStudent == null) {
			throw new RuntimeException("Student with id: " + id + " not found");
		}
		 
		student.setId(id);
		entityManager.merge(student);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		Student tempStudent  =  findById(id);
		if(tempStudent == null) {
			throw new RuntimeException("Student with id: " + id + " not found");
		}
		 
		entityManager.remove(tempStudent);
	}
	
	@Override
	public List<Student> findAll(){
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student",Student.class);
		return theQuery.getResultList();
	}
	
	@Override
	public List<Student> findByEmailFormat(String s){
		TypedQuery<Student> theQuery = entityManager.createQuery("Select s from Student as s where s.email like :theData",Student.class);
		theQuery.setParameter("theData","%"+ s);
		return theQuery.getResultList();
	}
	
	
	

}
