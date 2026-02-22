package com.example.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the courses
        List<Course> courses = tempInstructor.getCourses();

        // break association of all courses for the instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(tempInstructor);
		
	}

	@Override
	public InstructorDetails findInstructorDetailById(int theId) {
		return entityManager.find(InstructorDetails.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
        // retrieve instructor detail
        InstructorDetails tempInstructorDetail = entityManager.find(InstructorDetails.class, theId);

        // remove the associated object reference
        // break bi-directional link
        //
        tempInstructorDetail.getInstructor().setInstructorDetails(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);
		
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
		
		query.setParameter("data", theId);
		
		return query.getResultList();
		
		
	}
	
	@Override
	public Instructor findInstructorWithCourses(int theId) {
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+" Join fetch i.courses "+" where i.id=:data",Instructor.class);
		query.setParameter("data",theId);
		
		return query.getSingleResult();
	}

	@Override
	public Course findCourseById(int theId) {
		 return entityManager.find(Course.class, theId);
	}
	
	@Override
	@Transactional
	public void updateCourse(Course tempCourse) {
		entityManager.merge(tempCourse);
	}
	
	@Override
	@Transactional
	public void updateInstructer(Instructor tempInstructor) {
		entityManager.merge(tempInstructor);
	}
	
	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// retrieve the course
		Course tempCourse = entityManager.find(Course.class, theId);

		// break association of the course with instructor
		tempCourse.setInstructor(null);

		// delete the course
		entityManager.remove(tempCourse);
		
	}
	
	
	
}
