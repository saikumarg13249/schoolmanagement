package com.myschool.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String courseName;
	@Column
	private String courseId;
	@Column
	private String courseDuration;
	@Column
	private String credits;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	
	@ManyToMany(mappedBy= "courses")
	 public Set<Student> students = new HashSet<Student>(); 

	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getCourseName() {
		return courseName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
}
