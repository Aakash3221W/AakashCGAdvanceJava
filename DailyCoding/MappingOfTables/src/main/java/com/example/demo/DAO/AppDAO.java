package com.example.demo.DAO;

import com.example.demo.Entity.Instructor;

public interface AppDAO {

	void save(Instructor instructor);

	Instructor findInstructorById(int id);

}
