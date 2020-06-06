package com.paremal.sheebu.springboot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public Person welcome() {
		return new Person("name", "Sheebu");
	}
	

}

class Person{
	String name;
	String valueString;
	public Person(String name, String value) {
		super();
		this.name = name;
		this.valueString = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValueString() {
		return valueString;
	}
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	
	
}