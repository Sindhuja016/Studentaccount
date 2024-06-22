package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto;
import com.student.service.StudentService;



@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	public StudentService studentservice;
	
	@PostMapping("/create")
	public List<StudentDto> createUser(@RequestBody List<StudentDto> sdtos) {
		return studentservice.createUser(sdtos);
	}
	@GetMapping("/getbyid/{id}")
	public StudentDto getUserById(@PathVariable Integer id) {
		return studentservice.getUserId(id);
	}
	@GetMapping("/getbyname")
	public StudentDto getUserByName(@RequestParam String name) {
		return studentservice.getUserByName(name);
	}
	@GetMapping("/getall")
	public List<StudentDto> getAll(){
		return studentservice.getAll();
		
	}
	@PutMapping("/update/{id}")
	public StudentDto updateById(@RequestBody StudentDto dto,@PathVariable Integer id) {
		return studentservice.updateById(dto,id);
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
			studentservice.deleteById(id);
	}
	
	
}
