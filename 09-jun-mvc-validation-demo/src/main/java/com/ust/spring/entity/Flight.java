package com.ust.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer capacity;
	public Flight() {
	}
	
	public Flight(Integer id, String name, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}
	
	
}
