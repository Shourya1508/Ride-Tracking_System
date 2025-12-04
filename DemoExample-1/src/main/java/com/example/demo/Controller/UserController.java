package com.example.demo.Controller;

import java.net.http.HttpResponse;
import java.security.DrbgParameters.Reseed;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.example.demo.Entity.Employee;
//import com.example.demo.Entity.Employee;
//import com.example.demo.Entity.Employee;
import com.example.demo.Entity.User;
import com.example.demo.Entity.LoginDto;
import com.example.demo.Entity.Reset;
import com.example.demo.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	

	@PostMapping("/signUp")
	private ResponseEntity<String> signUp(@RequestBody User user) {
		int res = userService.saveOrUpdate(user);
		if(res == 0)
			return new ResponseEntity<>("Email already exists",HttpStatus.ALREADY_REPORTED);
		else {
			return new ResponseEntity<>("User added",HttpStatus.OK);
		}
	}
	
	@PostMapping("/login")
	private ResponseEntity<String> login(@RequestBody LoginDto user) {
		
		int res = userService.userLogin(user);
		if(res == 1) {
			return new ResponseEntity<>("Status",HttpStatus.OK);
		}
		else if(res==-2){
			return new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>("Bad Gateway",HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	@PostMapping("/addEmployee")
	private ResponseEntity<String> addEmpl(@RequestBody Employee emp) {
		
	    int res = userService.addEmployee(emp);
	    if(res ==0)
	    	return new ResponseEntity<>("Employee id already exists",HttpStatus.ALREADY_REPORTED);
	    else {
	    	return new ResponseEntity<>("Employee added",HttpStatus.OK);
	    }
	}
	
	@PostMapping("/delete/{id}")
	private String delEmp(@PathVariable("id") int id) {
		int res = userService.del(id);
		if(res == 1){
			return " All Employees deleted";
		}else {
			return "Invalid User_id";
		}
	}
	
	
	@PostMapping("/delete/{id}/{emp_id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id, @PathVariable("emp_id") String emp_id) {
		int res = userService.del(id,emp_id);
		if(res == 1){
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error in deleting",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/allEmp/{user_id}")
	private List<Employee> List(@PathVariable("user_id") int id) {
		List<Employee> l1 = userService.findList(id);
		if(l1!=null) {
		for(Employee e : l1) {
			System.out.println(e.getEmp_id());
		}
		
		return l1;
		}
		return l1;
	}
	
	@PostMapping("/updateEmp/{mast}")
	private ResponseEntity<String> UpEmp(@PathVariable("mast") int mast_code ,@RequestBody Employee emp) {
		
		int res = userService.saveOrUpdate(emp,mast_code);
		if(res == 1) {
			return new ResponseEntity<>("Updated",HttpStatus.OK); 
		}
		return new ResponseEntity<>("Error in updating employee",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("editEmployee/{empid}")
	private Employee edit(@PathVariable("empid")String id) {
		
		Employee emp = userService.saveOrUpdate(id);
		if(emp!=null)
			return emp;
		
		return null;
	}
	
	@PostMapping("/updateUser/{user_id}")
	private ResponseEntity<String> UpEmp(@PathVariable("user_id") int id ,@RequestBody User user) {
		
		int res = userService.saveOrUpdate(user,id);
		if(res == 1) {
			return new ResponseEntity<>("Email not present",HttpStatus.ACCEPTED); 
		}
		else if(res == 2)
			return  new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
		else
		  return new ResponseEntity<>("Error in updating",HttpStatus.BAD_GATEWAY);
	}
	
	@PostMapping("/reset/{id}")
	private ResponseEntity<String> ResetPass(@PathVariable("id") int user_id, @RequestBody Reset reset){
		
		int res = userService.reset(user_id,reset);
		if(res == 1)
		return new ResponseEntity<>("Password Reset",HttpStatus.OK);
		else {
			return new ResponseEntity<>("Password Reset",HttpStatus.BAD_REQUEST);
		}
	}


}
