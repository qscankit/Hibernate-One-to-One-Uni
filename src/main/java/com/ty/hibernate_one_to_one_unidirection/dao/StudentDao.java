package com.ty.hibernate_one_to_one_unidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernate_one_to_one_unidirection.dto.Student;
import com.ty.hibernate_one_to_one_unidirection.dto.Subject;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ankit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
//	this is save method
	public void saveStudent(Student student, Subject subject) {
		 entityTransaction.begin();
		 entityManager.persist(subject);
		 entityManager.persist(student);
		 entityTransaction.commit();
		 
		 System.out.println("Data Saved...");
	}
	
//	update method
	
	public void updateStudent(Student student,int id) {
		
	Student student2 =	entityManager.find(Student.class,student.getId());
	
		if(student2!=null) {
			student2.setName(student.getName());
			
			entityTransaction.begin();
			entityManager.merge(student2);
			entityTransaction.commit();
			System.out.println("Data Updated...");
		}
	}
	
	//display method
	
	public List<Student> displayStudents(){
		String select = "SELECT s FROM Student s";
		
		return entityManager.createQuery(select, Student.class).getResultList();
		
		
	}
	
	// delete student
	
	public void deleteStudent(int id) {
		String delete = "DELETE e FROM STUDENT e WHERE e.id=?1";
		
		javax.persistence.Query	query = entityManager.createQuery(delete);
		
		entityTransaction.begin();
		entityManager.remove(query);
		
		query.setParameter(1, id).executeUpdate();
		entityTransaction.commit();
		
		System.out.println("Data Deleted...");
	}

}
