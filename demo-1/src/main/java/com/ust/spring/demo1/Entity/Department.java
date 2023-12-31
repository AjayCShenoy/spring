package com.ust.spring.demo1.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Department {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String name;
@OneToMany(mappedBy = "department" ,fetch= FetchType.LAZY)
private List<Employee> employees;

public Department() {
	super();
}

public Department(Integer id, String name, List<Employee> employees) {
	super();
	this.id = id;
	this.name = name;
	this.employees = employees;
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
public List<Employee> getEmployees() {
	return employees;
}
public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}

@Override
public String toString() {
	return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
}






}
