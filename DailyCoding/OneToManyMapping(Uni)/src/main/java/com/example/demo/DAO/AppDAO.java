package com.example.demo.DAO;

import java.util.List;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.InstructorDetails;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetails findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
    
    List<Course> findCoursesByInstructorId(int theId);

	Instructor findInstructorWithCourses(int theId);

	Course findCourseById(int theId);
	
	void updateCourse(Course tempCourse);
	
	void updateInstructer(Instructor tempInstructor);

	void deleteCourseById(int theId);
	
	void save(Course tempCourse);

	Course findCourseAndReviewByCourseId(int theId);

}
