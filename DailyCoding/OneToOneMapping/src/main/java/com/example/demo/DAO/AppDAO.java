package com.example.demo.DAO;

import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.InstructorDetails;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetails findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

}
