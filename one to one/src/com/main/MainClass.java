package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Student;
import com.entities.Laptop;

public class MainClass {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		
		Laptop l = new Laptop();
		l.setL_id(15000);
		l.setL_name("Mac-Book");
		ss.persist(l);
		
		Student s = new Student();
		s.setS_id(13);
        s.setS_name("Annya");
        s.setLaptop(l);
        
        
        ss.persist(s);
        System.out.println("data is inseted....");
		tr.commit();
		ss.close();

	}
}