package com.myschool.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String addressLine1;
	
	@Column
	private String city;
	
	@Column
	private String streetNo;
	
	@Column
	private String pincode;
	
	@Column
	private String state;
	
	@Column
	private String country;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="student_courses",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns=@JoinColumn(name="course_id"))
	protected Set<Course> courses = new HashSet<Course>();

	public Set<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
		course.getStudents().add(this);
	}
	
	public void removeCourse(Course course) {
		courses.remove(course);
		course.getStudents().remove(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
