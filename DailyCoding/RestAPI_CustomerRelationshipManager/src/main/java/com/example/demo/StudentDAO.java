package com.example.demo;

import java.util.List;

public interface StudentDAO {

	List<Student> getAllStudents();

	Student getStudentByIFirstName(String id);

}
