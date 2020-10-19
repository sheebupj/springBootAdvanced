package com.paremal.sheebu.springboot.entity.oracle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name="MYUSERS1")
public class User2 {


	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
     private long userId;
	 
	
	private String name;
	private String role;
	
	

	


	public User2(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}
	

	
	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", role=" + role + "]";
	}

}
