package com.myschool.controller;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.entities.Student;
import com.myschool.model.CourseModel;
import com.myschool.model.StudentModel;
import com.myschool.service.ManageStudentsAndCoursesService;

@RequestMapping("/school-management")
@RestController
public class SchoolManagementController {

	@Autowired
	ManageStudentsAndCoursesService manageStudentsAndCoursesService;

	private static final Logger logger = LoggerFactory.getLogger(SchoolManagementController.class);

	@PostMapping("/save-student")
	public ResponseEntity saveStudent(@RequestBody StudentModel student) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.registerStudent(student);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@PostMapping("/save-course")
	public ResponseEntity saveCourse(@RequestBody CourseModel course) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.saveCourse(course);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@PutMapping("/update-student")
	public ResponseEntity updateStudent(@RequestBody StudentModel studentModel) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.updateStudent(studentModel);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@PutMapping("/update-course")
	public ResponseEntity updateCourse(@RequestBody CourseModel courseModel) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.updateCourse(courseModel);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping("/student-details/{studentId}")
	public ResponseEntity<StudentModel> getStudent(@PathVariable("studentId") String id) {
		ResponseEntity<StudentModel> responseEntity;
		StudentModel studentModel = new StudentModel();
		try {
			studentModel = manageStudentsAndCoursesService.getStudent(id);
			responseEntity = new ResponseEntity<StudentModel>(studentModel,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity<StudentModel>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping("/course-details/{courseId}")
	public ResponseEntity<CourseModel> getCourse(@PathVariable("courseId") String id) {
		ResponseEntity<CourseModel> responseEntity;
		CourseModel courseModel = new CourseModel();
		try {
			courseModel = manageStudentsAndCoursesService.getCourse(id);
			responseEntity = new ResponseEntity<CourseModel>(courseModel, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity<CourseModel>(courseModel, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@DeleteMapping("/delete-student/{studentId}")
	public ResponseEntity deleteStudent(@PathVariable("studentId") String id) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.deleteStudent(id);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@DeleteMapping("/delete-course/{courseId}")
	public ResponseEntity deleteCourse(@PathVariable("courseId") String id) {
		ResponseEntity responseEntity;
		try {
			manageStudentsAndCoursesService.deleteCourse(id);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@PutMapping("/register-student-with-course/{studentId}/{courseId}")
	public ResponseEntity registerStudentForCourse(@PathVariable("studentId") String studentId,
			@PathVariable("courseId") String courseId) {
		try {
			manageStudentsAndCoursesService.registerCourse(studentId, courseId);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/students-by-course/{courseId}")
	public ResponseEntity getCourseOfStudents(@PathVariable("courseId") String courseId) {
		ResponseEntity responseEntity;
		Set<StudentModel> students;
		try {
			students = manageStudentsAndCoursesService.getCourseWithStudents(courseId);
			responseEntity = new ResponseEntity(students, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(new HashSet<Student>(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping("/courses-by-student/{studentId}")
	public ResponseEntity getStudentsWithCourses(@PathVariable("studentId") String studentId) {
		ResponseEntity responseEntity;
		Set<CourseModel> courseModels;
		try {
			courseModels = manageStudentsAndCoursesService.getStudentsWithCourse(studentId);
			responseEntity = new ResponseEntity(courseModels, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(new HashSet<Student>(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping("/courses-without-students")
	public ResponseEntity getCoursesWithOutStudents() {
		ResponseEntity responseEntity;
		Set<CourseModel> courseModels;
		try {
			courseModels = manageStudentsAndCoursesService.getCoursesWithOutStudents();
			responseEntity = new ResponseEntity(courseModels, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(new HashSet<Student>(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping("/students-without-courses")
	public ResponseEntity getStudentWithOutCourses() {
		ResponseEntity responseEntity;
		Set<StudentModel> studentModels;
		try {
			studentModels = manageStudentsAndCoursesService.getStudentsWithOutCourses();
			responseEntity = new ResponseEntity(studentModels, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured", e);
			responseEntity = new ResponseEntity(new HashSet<Student>(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
