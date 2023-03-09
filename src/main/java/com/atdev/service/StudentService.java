package com.atdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atdev.dao.StudentDao;
import com.atdev.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public List<Student> getStudentRecords(List<Student> al) {
		return dao.getStudentRecords();
	}

	public String insertRecordStudent(List<Student> al) {
		String msg = dao.insertRecordStudent(al);
		return msg;
	}

	public String deleteById(int rollNo) {
		String msg = dao.deleteById(rollNo);
		return msg;
	}

	public String updateStudentRecord(List<Student> al) {
		String msg = dao.updateStudentRecord(al);
		return msg;
	}

}
