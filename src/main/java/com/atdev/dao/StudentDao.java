package com.atdev.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atdev.entity.Student;

@Repository
public class StudentDao {
	@Autowired
	SessionFactory sf;

	public List<Student> getStudentRecords() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		return criteria.list();
	}

	public String insertRecordStudent(List<Student> al) {
		System.out.println("In Dao = " + al);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for (Student student : al) {
			session.save(student);
		}
		tr.commit();
		return "Student Record Inserted Successfuly..!!!";
	}

	public String deleteById(int rollNo) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Student ss = session.load(Student.class, rollNo);
		session.delete(ss);
		tr.commit();
		return "Student Deleted Successfuly...!!!";
	}

	public String updateStudentRecord(List<Student> al) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Student ss = new Student();
		ss.setRollNo(5);
		ss.setName("Anisha");
		ss.setDep("Biology");
		ss.setGrade("O");
		ss.setPer(99);
		session.update(ss);
		tr.commit();
		return "Student Updated Successfuly...!!!";
	}
}
