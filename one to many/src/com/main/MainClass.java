package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.testing.orm.domain.gambit.EntityWithManyToOneWithoutJoinTable;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class); 

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		

		Employee e1 = new Employee();
		e1.setEmp_id(4);
		e1.setE_name("Rohit");
		
		ss.persist(e1);

		Employee e2 = new Employee();
		e2.setEmp_id(5);
		e2.setE_name("Akshay");
		
		ss.persist(e2);

		Employee e3 = new Employee();
		e3.setEmp_id(6);
		e3.setE_name("Pankaj");
	
		ss.persist(e3);

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Department d = new Department();
		d.setD_id(105);
		d.setD_name("game developer");
		
		e1.setDept(d);
		e2.setDept(d);
		e3.setDept(d);
		
		d.setEmp(list);
		ss.persist(d);
		

	

		tr.commit();
		ss.close();
	}
}
