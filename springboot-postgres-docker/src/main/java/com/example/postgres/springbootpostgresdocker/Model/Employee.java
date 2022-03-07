package com.example.postgres.springbootpostgresdocker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name2) {
		name=name2; 
	}
	
}
