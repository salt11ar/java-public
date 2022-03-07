package com.example.postgres.springbootpostgresdocker;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgres.springbootpostgresdocker.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
