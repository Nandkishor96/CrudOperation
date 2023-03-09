package com.atdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.entity.Student;
import com.atdev.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;

	@GetMapping("/getrecords")
	public List<Student> getStudentRecords(@RequestBody List<Student> al) {
		return service.getStudentRecords(al);
	}

	@PostMapping("/insert")
	public String insertRecordStudent(@RequestBody List<Student> al) {
		String msg = service.insertRecordStudent(al);
		return msg;
	}

	@DeleteMapping("/delete/{rollNo}")
	public String deleteById(@PathVariable int rollNo) {
		String msg = service.deleteById(rollNo);
		return msg;
	}

	@PostMapping("/update")
	public String updateStudentRecord(@RequestBody List<Student> al) {
		String msg = service.updateStudentRecord(al);
		return msg;
	}

}
