package com.example.demo.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.X509ExtendedTrustManager;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
//import com.example.demo.Entity.Employee;
//import com.example.demo.Entity.Employee;
import com.example.demo.Entity.User;
import com.example.demo.Entity.LoginDto;
import com.example.demo.Entity.Reset;
import com.example.demo.Repository.EmpRepo;
//import com.example.demo.Repository.EmpRepo;
//import com.example.demo.Repository.EmpRepo;
import com.example.demo.Repository.UserRepo;


@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	
	@Autowired
	EmpRepo empRepo;
//	
//	@Autowired 
//	Employee employee;
	


	public int saveOrUpdate(User user) {
		if(userRepo.findByEmail(user.getEmail()) != null) {
			return 0;
		}
		else {
		userRepo.save(user);
		return 1;
		}
	}
	
	public Employee saveOrUpdate(String empid) {
	  Employee e1 = empRepo.findByEmp_id(empid);
		if(e1 == null) {
			return null;
		}
		else {
		   return e1;
		}
	}
	
	public int saveOrUpdate(User user,int user_id) {
			User u1 = userRepo.findById(user_id);
			if(u1!=null) {
				
				User u2 = userRepo.findByEmail(user.getEmail());
				if(u2 == null) {
				u1.setUser_name(user.getUser_name());
				u1.setEmail(user.getEmail());
				u1.setMobile(user.getMobile());
				u1.setPassword(user.getPassword());
				u1.setConfirm_password(user.getConfirm_password());
			
				userRepo.save(u1);
				
				return 1;
				}
				else {
					u1.setUser_name(user.getUser_name());
					u1.setEmail(user.getEmail());
					u1.setMobile(user.getMobile());
					u1.setPassword(user.getPassword());
					u1.setConfirm_password(user.getConfirm_password());
				
					userRepo.save(u1);
					
					return 2;
				}
			
		}
			return 0;
	}
	
	
	public int saveOrUpdate(Employee emp,int mast) {
		
		Employee e1 = empRepo.findById(mast);
		System.out.println(mast+" "+e1);
		if(e1!=null) {
			
			e1.setEmp_id(emp.getEmp_id());
			e1.setEmp_name(emp.getEmp_name());
			e1.setDesignation(emp.getDesignation());
			e1.setDepartment(emp.getDepartment());
			e1.setJoined_date(emp.getJoined_date());
			e1.setSalary(emp.getSalary());
			e1.setId(emp.getId());
			e1.setAddressline1(emp.getAddressline1());
			e1.setAddressline2(emp.getAddressline2());
			e1.setCity(emp.getCity());
			e1.setState(emp.getState());
			e1.setCountry(emp.getCountry());
			
			empRepo.save(e1);
			return 1;
		}
		else {
			return 0;
		}
	
		
		}
	
	
	public int userLogin(LoginDto user) {
		
		int status =0;
		User u1 = userRepo.findByEmail(user.getEmail());
		
		try {
		if(u1.getEmail().equals(user.getEmail()) && u1.getPassword().equals(user.getPassword())) {
			status = 1;
		}else {
			status = -1;
		}
		}catch(NullPointerException e) {
			status = -2;
			e.printStackTrace();
		}
		return status;
	}
	
	public int addEmployee(Employee emp) {
		
		if(empRepo.findByEmp_id(emp.getEmp_id()) != null) {
			return 0;
		}else {
  	  
			 Employee employee1 = new Employee(
						emp.getMast_code(),
						emp.getId(),
						emp.getEmp_id(),
						emp.getEmp_name(),
						emp.getDesignation(),
						emp.getDepartment(),
						emp.getJoined_date(),
						emp.getSalary(),
						emp.getAddressline1(),
						emp.getAddressline2(),
						emp.getCity(),
						emp.getState(),
						emp.getCountry()
						);
				empRepo.save(employee1);
//		
		return 1;
	}
	}
	
	public int del(int id) {
		
		System.out.println(id);
	List<Employee> emp = empRepo.findAllById(id);
		System.out.println(emp);
		if(emp != null) {
			  for(Employee e : emp) {
				  empRepo.delete(e);
			  }

		return 1;
		}
		return 0;
	}
	
	public int del(int id,String emp_id) {
		
		System.out.println(id);
		int c =0;
	List<Employee> emp = empRepo.findAllById(id);
		System.out.println(emp);
		if(emp != null) {
			  for(Employee e : emp) {
				  if(e.getEmp_id().equals(emp_id)) {
					  System.out.println(emp_id);
					  empRepo.delete(e);
					  c++;
				  }
			  }
       if(c!=0)
		return 1;
       
       return 0;
		}
		return 0;
	}
	
	public List<Employee> findList(int id) {
		
		List<Employee> l2 = empRepo.findAllById(id);
		if(l2!=null)
			return l2;
		
		return null;
	}
	
	public int reset(int user_id,Reset reset) {
		
		User u1 = userRepo.findById(user_id);
		if(u1!=null) {
			
			u1.setPassword(reset.getPassword());
			u1.setConfirm_password(reset.getConfirm_password());
			
			userRepo.save(u1);
			
			return 1;
		}
		else {
			return 0;
		}
	}
}

