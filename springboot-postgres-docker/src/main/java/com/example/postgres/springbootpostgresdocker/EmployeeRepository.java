package com.example.postgres.springbootpostgresdocker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

import com.example.postgres.springbootpostgresdocker.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
    @Query(value = "SELECT * from employee WHERE email = :mail", nativeQuery = true) 
    public List<Employee> findAllByEmail(@Param("mail") String email);

   /* @Query("SELECT u FROM employee u WHERE u.salary > 0")
    public Collection<Employee> findAllActiveEmployees();
    
    @Query(value = "SELECT * FROM EMPLOYEE u WHERE u.salary > 0", nativeQuery = true)
    public Collection<Employee> findAllActiveEmployeesNative();
    */
}
