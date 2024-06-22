package com.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.AccountDto;
import com.student.dto.StudentDto;
import com.student.entity.Account;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository repo;

	public List<StudentDto> createUser(List<StudentDto> sdtos) {
		
		List<StudentDto> dto=new ArrayList<>();

		for(StudentDto sdto:sdtos) {
		
		Student s=new Student();
		s.setName(sdto.getName());
		s.setEmail(sdto.getEmail());
		s.setPassword(sdto.getPassword());
		
		Account ac=new Account();
		ac.setAname(sdto.getAccount().getAname());
		ac.setType(sdto.getAccount().getType());
		
		s.setAccount(ac);
		ac.setStudent(s);
		
		Student us=repo.save(s);
		
		AccountDto dt=new AccountDto();
		dt.setAid(us.getAccount().getAid());
		dt.setAname(us.getAccount().getAname());
		dt.setType(us.getAccount().getType());
		
		StudentDto d=new StudentDto();
		d.setId(us.getId());
		d.setName(us.getName());
		d.setEmail(us.getEmail());
		d.setPassword(us.getPassword());
		d.setAccount(dt);
		
		dto.add(d);
		}
		return dto;
	}

	public StudentDto getUserId(Integer id) {
		Optional<Student> ops=repo.findById(id);
		
		Student s=ops.get();
		
		AccountDto d=new AccountDto();
		d.setAid(s.getAccount().getAid());
		d.setAname(s.getAccount().getAname());
		d.setType(s.getAccount().getType());
		
		StudentDto dt=new StudentDto();
		dt.setId(s.getId());
		dt.setName(s.getName());
		dt.setEmail(s.getEmail());
		dt.setPassword(s.getPassword());
	
	    dt.setAccount(d);
	    
	    return dt;
	}

	public StudentDto getUserByName(String name) {
		
		Student s=repo.findByName(name);
		AccountDto d=new AccountDto();
		d.setAid(s.getAccount().getAid());
		d.setAname(s.getAccount().getAname());
		d.setType(s.getAccount().getType());
		
		StudentDto dt=new StudentDto();
		dt.setId(s.getId());
		dt.setName(s.getName());
		dt.setEmail(s.getEmail());
		dt.setPassword(s.getPassword());
	
	    dt.setAccount(d);
	    
	    return dt;
	
	}

	public List<StudentDto> getAll() {
		
		List<Student> ss=repo.findAll();
		List<StudentDto> dto=new ArrayList<>();
		for(Student s:ss) {
			
		AccountDto d=new AccountDto();

		d.setAid(s.getAccount().getAid());
		d.setAname(s.getAccount().getAname());
		d.setType(s.getAccount().getType());
		
		
		StudentDto dt=new StudentDto();
		dt.setId(s.getId());
		dt.setName(s.getName());
		dt.setEmail(s.getEmail());
		dt.setPassword(s.getPassword());
		
		dt.setAccount(d);
		
	    dto.add(dt);
		}
	    return dto;
	}

	public StudentDto updateById(StudentDto dto, Integer id) {
		
		Optional<Student> ss=repo.findById(id);
		
		Student s=ss.get();
		s.setName(dto.getName());
		s.setEmail(dto.getEmail());
		s.setPassword(dto.getPassword());
		
		 Account ac = s.getAccount();
		ac.setAname(dto.getAccount().getAname());
		ac.setType(dto.getAccount().getType());
		
		s.setAccount(ac);
		ac.setStudent(s);
		
		Student us=repo.save(s);
		
		AccountDto dt=new AccountDto();
		dt.setAid(us.getAccount().getAid());
		dt.setAname(us.getAccount().getAname());
		dt.setType(us.getAccount().getType());
		
		StudentDto d=new StudentDto();
		d.setId(us.getId());
		d.setName(us.getName());
		d.setEmail(us.getEmail());
		d.setPassword(us.getPassword());
		d.setAccount(dt);
		return d;
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

}
