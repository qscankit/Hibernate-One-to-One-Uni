package com.ty.hibernate_one_to_one_unidirection.service;


import java.util.List;

import com.ty.hibernate_one_to_one_unidirection.dao.StudentDao;
import com.ty.hibernate_one_to_one_unidirection.dto.Student;
import com.ty.hibernate_one_to_one_unidirection.dto.Subject;

public class StudentService {
	
	StudentDao dao = new StudentDao();
	
	//	save Method
	public void saveStudent(Student student, Subject subject) {
		
		dao.saveStudent(student, subject);
	}
	
	//	update method
	
	public void updateStudent(Student student, int id) {
		dao.updateStudent(student, id);
	}
	
	//display method
	
		public List<Student> displayStudents(){
			return dao.displayStudents();
			
		}
		
		
	// delete student
		
		public void deleteStudent(int id) {
			dao.deleteStudent(id);
		}
}
