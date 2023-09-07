package com.springboot.couchbase.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//lombok annotations

@NoArgsConstructor
@AllArgsConstructor

// identified the domain object to be persisted to couchbase
@Document
public class YogaC {

    //identifies a field which will not be stored in the couchbase document but rather
    //used an document id
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
     int id;
    //denotes a field which in the couchbase document
    @Field(value = "name")
    String name;
    @Field
    int age;
    @Field(value = "age")
    String email;                      
   
    
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "YogaC [id=" + id + ", name=" + name + ", age=" + age + ", email" + email + "]";
	}
}
