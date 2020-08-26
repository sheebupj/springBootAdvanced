package com.paremal.sheebu.springboot.entity.oracle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String housename;
	private String place;
	private String postoffice;

	public Address() {
	}

	public Address(String housename, String place, String postoffice) {
		super();
		this.housename = housename;
		this.place = place;
		this.postoffice = postoffice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", housename=" + housename + ", place=" + place + "]";
	}

}
