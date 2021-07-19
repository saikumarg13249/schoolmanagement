package com.myschool.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.entities.Student;
import com.myschool.model.CourseModel;
import com.myschool.model.StudentModel;
import com.myschool.service.ManageStudentsAndCoursesService;

@RestController
public class SchoolManagementController {
	
	@Autowired
	ManageStudentsAndCoursesService manageStudentsAndCoursesService;
	
	@RequestMapping(value="/registerStudent",method=RequestMethod.POST)
	public ResponseEntity registerStudent(@RequestBody StudentModel student) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.registerStudent(student);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/saveCourse",method=RequestMethod.POST)
	public ResponseEntity saveCourse(@RequestBody CourseModel course) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.saveCourse(course);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.POST)
	public ResponseEntity updateStudent(@RequestBody StudentModel studentModel) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.updateStudent(studentModel);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/updateCourse",method=RequestMethod.POST)
	public ResponseEntity updateCourse(@RequestBody CourseModel courseModel) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.updateCourse(courseModel);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/getStudent",method=RequestMethod.GET)
	public ResponseEntity<StudentModel> getStudent(@RequestParam String id ) {
		ResponseEntity<StudentModel> responseEntity;
		StudentModel studentModel= new StudentModel();
		try {
			 studentModel = manageStudentsAndCoursesService.getStudent(id);
			 responseEntity = new ResponseEntity<StudentModel>(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity<StudentModel>(studentModel,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/getCourse",method=RequestMethod.GET)
	public ResponseEntity<CourseModel> getCourse(@RequestParam String id) {
		ResponseEntity<CourseModel> responseEntity;
		CourseModel courseModel = new CourseModel();
		try {
			courseModel= 	manageStudentsAndCoursesService.getCourse(id);
			 responseEntity = new ResponseEntity<CourseModel>(courseModel,HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity<CourseModel>(courseModel,HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/deleteStudent",method=RequestMethod.GET)
	public ResponseEntity deleteStudent(@RequestParam String id ) {
		ResponseEntity responseEntity;
		try {
			   manageStudentsAndCoursesService.deleteStudent(id);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/deleteCourse",method=RequestMethod.GET)
	public ResponseEntity deleteCourse(@RequestParam String id) {
		ResponseEntity responseEntity;
		try {
				manageStudentsAndCoursesService.deleteCourse(id);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/registerStudentForCourse",method=RequestMethod.GET)
	public ResponseEntity registerStudentForCourse(@RequestParam String studentId, @RequestParam String courseId) {
		ResponseEntity responseEntity;
		try {
				manageStudentsAndCoursesService.registerCourse(studentId, courseId);
			 responseEntity = new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/courseWithStudents",method=RequestMethod.GET)
	public ResponseEntity getCourseOfStudents(@RequestParam String courseId) {
		ResponseEntity responseEntity;
		Set<StudentModel> students;
		try {
			students = manageStudentsAndCoursesService.getCourseWithStudents(courseId);
			 responseEntity = new ResponseEntity(students,HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(new HashSet<Student>(),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/studentWithCourses",method=RequestMethod.GET)
	public ResponseEntity getStudentsWithCourses(@RequestParam String studentId) {
		ResponseEntity responseEntity;
		Set<CourseModel> courseModels;
		try {
			courseModels = manageStudentsAndCoursesService.getStudentsWithCourse(studentId);
			 responseEntity = new ResponseEntity(courseModels,HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(new HashSet<Student>(),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@RequestMapping(value="/coursesWithOutStudents",method=RequestMethod.GET)
	public ResponseEntity getCoursesWithOutStudents(){
		ResponseEntity responseEntity;
		Set<CourseModel> courseModels;
		try {
			courseModels = manageStudentsAndCoursesService.getCoursesWithOutStudents();
			 responseEntity = new ResponseEntity(courseModels,HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(new HashSet<Student>(),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/studentsWithOutCourses",method=RequestMethod.GET)
	public ResponseEntity getStudentWithOutCourses(){
		ResponseEntity responseEntity;
		Set<StudentModel> studentModels;
		try {
			studentModels = manageStudentsAndCoursesService.getStudentsWithOutCourses();
			 responseEntity = new ResponseEntity(studentModels,HttpStatus.OK);
		}catch(Exception e) {
			//log exception log
			 responseEntity = new ResponseEntity(new HashSet<Student>(),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
