package com.margosa.StudentCrud.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.margosa.StudentCrud.constant.AppConstant;

import lombok.Data;

@Entity
@Data
@Table(name = "student_tbl")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name = "student_id")
	private Integer studentId;


	
	
	@Column(name = "student_name")
	private String StudentName;

	@Column(name = "student_address")
	private String address;

	@Column(name = "student_email")
	private String StudentEmail;

	@Column(name = "createdDate")
	private LocalDateTime createdDate;

	@Column(name = "modifiedDate")
	private LocalDateTime modifiedDate;

	@PreUpdate
	void onUpdatePersist() {

		this.modifiedDate = LocalDateTime.now(AppConstant.INDIA_ZONE);
	}

	@PrePersist
	void onPrePersist() {
		this.modifiedDate = LocalDateTime.now(AppConstant.INDIA_ZONE);
		this.createdDate = LocalDateTime.now(AppConstant.INDIA_ZONE);

	}

}
