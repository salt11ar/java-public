package com.example.postgres.springbootpostgresdocker.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"created_at,updated_at"}, allowGetters = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAudit {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "created_at", nullable= false, updatable = false )
	@CreatedDate
	private java.util.Date createdAt;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "updated_at", nullable= false)
	@LastModifiedDate
	private java.util.Date updatedAt;
	
	@Column(name= "created_by", nullable= false)
	@CreatedBy
	private String createdBy;
	
	@Column(name= "updated_by", nullable= false)
	@LastModifiedBy
	private String updatedBy;
	

}
