package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Employee;
import java.util.List;
import java.util.Optional;




public interface EmpRepo extends JpaRepository<Employee, Integer> {

	 @Query("SELECT e FROM Employee e WHERE e.emp_id = :emp_id")
	 Employee findByEmp_id(String emp_id);
	 List<Employee> findAllById(int id);
	Employee findById(int id);
	 

//	Employee existsById(int emp_id);
	
}
