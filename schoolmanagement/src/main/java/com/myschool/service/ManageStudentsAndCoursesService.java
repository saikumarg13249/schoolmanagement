package com.myschool.service;

import java.text.ParseException;
import java.util.Set;
import com.myschool.model.CourseModel;
import com.myschool.model.StudentModel;

public interface ManageStudentsAndCoursesService {
	public void registerStudent(StudentModel student);
	public void saveCourse(CourseModel course) throws ParseException;
	public void updateStudent(StudentModel studentModel);
	public void updateCourse(CourseModel courseModel) throws ParseException;
	public StudentModel getStudent(String studentId);
	public CourseModel getCourse(String courseId);
	public void deleteStudent(String id);
	public void deleteCourse(String id);
	public void registerCourse(String studentId, String courseId );
	public Set<StudentModel> getCourseWithStudents(String courseId);
	public Set<CourseModel> getStudentsWithCourse(String studentId);
	public Set<StudentModel> getStudentsWithOutCourses();
	public Set<CourseModel> getCoursesWithOutStudents();
}
