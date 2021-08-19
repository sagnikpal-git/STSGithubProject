package com.app.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "emp")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Full_Name", nullable = false)
    private String name;

    @Column(name = "Email_Id", nullable = false)
    private String emailId;
    
    @Column(name = "Technology", nullable = false)
	private String tech;
    
    @Column(name = "Title", nullable = false)
	private String designation;
    
    @Column(name = "Age", nullable = false)
	private int age;
    
    @Column(name = "Location", nullable = false)
	private String address;
    
    @Column(name = "Mobile_Number", nullable = false)
	private String mobileNumber;	
	
//	private String name;	
//	private String emailId;	
//	private String tech;
//	private String designation;
//	private int age;
//	private String address;
//	private String mobileNumber;
//	
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", emailId=" + emailId + ", tech=" + tech + ", designation="
//				+ designation + ", age=" + age + ", address=" + address + ", mobileNumber=" + mobileNumber + "]";
//	}

}
