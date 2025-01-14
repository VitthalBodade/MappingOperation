package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;
import com.entity.Courses;

public class MainClass {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml"); 
		cfg.addAnnotatedClass(Courses.class);
		cfg.addAnnotatedClass(Student.class); 

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Courses course1 = new Courses();
        course1.setC_id(103);
        course1.setC_name("Mathematics");

        Courses course2 = new Courses();
        course2.setC_id(104);
        course2.setC_name("Science");

      
        ss.persist(course1);
        ss.persist(course2);

        
        Student student = new Student();
        student.setS_id(2);
        student.setS_name("Mahesh Lande");

        
        List<Courses> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        student.setStudent(courses);

       
        ss.persist(student);

        tr.commit();
        ss.close();
        sf.close();

        System.out.println("Many-to-Many mapping using List completed.");
    }
	}


