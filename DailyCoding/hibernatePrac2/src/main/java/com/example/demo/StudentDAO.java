package com.example.demo;

import java.util.List;

public interface StudentDAO {
	void save(Student student);

	Student findById(int id);

	void update(Student student,int id);

	void deleteById(int id);
	
	List<Student> findAll();

	List<Student> findByEmailFormat(String s);
}
