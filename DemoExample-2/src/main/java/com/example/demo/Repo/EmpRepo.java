package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import com.example.demo.dto.Employee;



public interface EmpRepo extends JpaRepository<Employee, Integer> {

	 @Query("SELECT e FROM Employee e WHERE e.emp_id = :emp_id")
	 Employee findByEmp_id(String emp_id);
	 List<Employee> findAllById(int id);
	 Employee findById(int id);
	 

//	Employee existsById(int emp_id);
	
}
