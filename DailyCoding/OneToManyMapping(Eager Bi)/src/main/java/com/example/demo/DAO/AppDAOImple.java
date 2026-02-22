package com.example.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImple implements AppDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImple(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor instructor){
		 entityManager.persist(instructor);
	
	}
	
	@Override
	public Instructor findInstructorById(int id) {
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		if(tempInstructor != null) {
			entityManager.remove(tempInstructor);
		}
		
	}

	@Override
	public InstructorDetails findInstructorDetailById(int theId) {
		return entityManager.find(InstructorDetails.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class, theId);
		
		if(tempInstructorDetails != null) {
			entityManager.remove(tempInstructorDetails);
		}
		
	}
	
	
	
}
