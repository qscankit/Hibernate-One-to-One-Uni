package com.ty.hibernate_one_to_one_unidirection.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernate_one_to_one_unidirection.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Subject  subject = new Subject();
		Student student = new Student();
		
		StudentService service = new StudentService();
		while(true) {
			
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.Display\n5.Exit");
			System.out.println("Choose Option...");
			
			int ch = scanner.nextInt();
			
			switch(ch) {
			
			case 1:{
				System.out.println("Enter the Subject Name");
				subject.setName(scanner.next());
				System.out.println("Enter the Subject Author");
				subject.setAuthor(scanner.next());
				
				
				
				System.out.println("Enter Name:");
				student.setName(scanner.next());
				
				System.out.println("Enter Email:");
				student.setEmail(scanner.next());
				
				
				student.setSubject(subject);
				
				service.saveStudent(student, subject);
				
			}break;
			
			case 2:{
				System.out.println("Enter  Student Id:");
				int id=scanner.nextInt();
				
				System.out.println("Enter new Student Name:");
				student.setName(scanner.next());
				service.updateStudent(student, id);
			}break;
			
			case 3:{
				System.out.println("Enter  Student Id:");
				int id=scanner.nextInt();
				service.deleteStudent(id);
				
			}break;
			
			case 4:{
				for(Student student2 : service.displayStudents()) {
					System.out.println(student2);
					System.out.println("............................");
				}
				
			}break;
			
			case 5:{
				
			}break;
			
			default :
			
			
			
			}
		}
	}
}

