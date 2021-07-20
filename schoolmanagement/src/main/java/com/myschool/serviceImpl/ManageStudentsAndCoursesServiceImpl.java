package com.myschool.serviceImpl;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.entities.Course;
import com.myschool.entities.Student;
import com.myschool.model.CourseModel;
import com.myschool.model.StudentModel;
import com.myschool.repository.CourseRepository;
import com.myschool.repository.StudentRepository;
import com.myschool.service.ManageStudentsAndCoursesService;
import com.myschool.util.Constants;

@Service
public class ManageStudentsAndCoursesServiceImpl implements ManageStudentsAndCoursesService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public void registerStudent(StudentModel studentModel) {
		Student student = new Student();
		if(studentModel.getAddressLine1()!=null) {
			student.setAddressLine1(studentModel.getAddressLine1());
		}
		if(studentModel.getAge()!=0) {
			student.setAge(studentModel.getAge());
		}
		if(studentModel.getCity()!=null) {
			student.setCity(studentModel.getCity());
		}
		if(studentModel.getCountry()!=null) {
			student.setCountry(studentModel.getCountry());
		}
		if(studentModel.getName()!=null) {
			student.setName(studentModel.getName());
		}
		if(studentModel.getPincode()!=null) {
			student.setPincode(studentModel.getPincode());
		}
		if(studentModel.getState()!=null) {
			student.setState(studentModel.getState());
		}
		if(studentModel.getStreetNo()!=null) {
			student.setStreetNo(studentModel.getStreetNo());
		}
		studentRepository.save(student);
	}
	
	@Override
	@Transactional
	public void saveCourse(CourseModel courseModel) throws ParseException {
		Course course = new Course();
		if(courseModel.getCourseDuration()!=null) {
			course.setCourseDuration(courseModel.getCourseDuration());
		}
		if(courseModel.getCourseName()!=null) {
			course.setCourseName(courseModel.getCourseName());
		}
		if(courseModel.getCredits()!=null) {
			course.setCredits(courseModel.getCredits());
		}
		if(courseModel.getStartDate()!=null) {
			course.setStartDate(Constants.convertStringToDate(courseModel.getStartDate()));
		}
		if(courseModel.getEndDate()!=null) {
			course.setEndDate(Constants.convertStringToDate(courseModel.getEndDate()));
		}
		if(courseModel.getCourseId()!=null) {
			course.setCourseId(courseModel.getCourseId());
		}
		courseRepository.save(course);
	}
	
	@Override
	@Transactional
	public void updateStudent(StudentModel studentModel) {
		Student student = studentRepository.findById(Long.parseLong(studentModel.getId())).get();
		if(studentModel.getAddressLine1()!=null) {
			student.setAddressLine1(studentModel.getAddressLine1());
		}
		if(studentModel.getAge()!=0) {
			student.setAge(studentModel.getAge());
		}
		if(studentModel.getCity()!=null) {
			student.setCity(studentModel.getCity());
		}
		if(studentModel.getCountry()!=null) {
			student.setCountry(studentModel.getCountry());
		}
		if(studentModel.getName()!=null) {
			student.setName(studentModel.getName());
		}
		if(studentModel.getPincode()!=null) {
			student.setPincode(studentModel.getPincode());
		}
		if(studentModel.getState()!=null) {
			student.setState(studentModel.getState());
		}
		if(studentModel.getStreetNo()!=null) {
			student.setStreetNo(studentModel.getStreetNo());
		}
		studentRepository.save(student);
	}
	
	@Override
	@Transactional
	public void updateCourse(CourseModel courseModel) throws ParseException {
		Course course = courseRepository.findById(Long.parseLong(courseModel.getId())).get();
		if(courseModel.getCourseDuration()!=null) {
			course.setCourseDuration(courseModel.getCourseDuration());
		}
		if(courseModel.getCourseName()!=null) {
			course.setCourseName(courseModel.getCourseName());
		}
		if(courseModel.getCredits()!=null) {
			course.setCredits(courseModel.getCredits());
		}
		if(courseModel.getStartDate()!=null) {
			course.setStartDate(Constants.convertStringToDate(courseModel.getStartDate()));
		}
		if(courseModel.getEndDate()!=null) {
			course.setEndDate(Constants.convertStringToDate(courseModel.getEndDate()));
		}
		if(courseModel.getCourseId()!=null) {
			course.setCourseId(courseModel.getCourseId());
		}
		courseRepository.save(course);
	}
	
	@Override
	@Transactional
	public StudentModel getStudent(String studentId) {
		Student student = studentRepository.findById(Long.parseLong(studentId)).get();
		StudentModel studentModel = new StudentModel();
		if(student!=null) {
			if(student.getAddressLine1()!=null) {
				studentModel.setAddressLine1(student.getAddressLine1());
			}
			if(student.getAge()!=0) {
				studentModel.setAge(student.getAge());
			}
			if(student.getCity()!=null) {
				studentModel.setCity(student.getCity());
			}
			if(student.getCountry()!=null) {
				studentModel.setCountry(student.getCountry());
			}
			if(student.getName()!=null) {
				studentModel.setName(student.getName());
			}
			if(student.getPincode()!=null) {
				studentModel.setPincode(student.getPincode());
			}
			if(student.getState()!=null) {
				studentModel.setState(student.getState());
			}
			if(student.getStreetNo()!=null) {
				studentModel.setStreetNo(student.getStreetNo());
			}
			if(Long.toString(student.getId())!=null) {
				studentModel.setId(Long.toString(student.getId()));
			}	
		}
		return studentModel;
	}
	@Override
	@Transactional
	public CourseModel getCourse(String courseId) {
		Course course = courseRepository.findById(Long.parseLong(courseId)).get();
		CourseModel courseModel = new CourseModel();
		if(course!=null) {
			if(course.getCourseDuration()!=null) {
				courseModel.setCourseDuration(course.getCourseDuration());
			}
			if(course.getCourseId()!=null) {
				courseModel.setCourseId(course.getCourseId());
			}
			if(Long.toString(course.getId())!=null) {
				courseModel.setId(Long.toString(course.getId()));
			}
			if(course.getCourseName()!=null) {
				courseModel.setCourseName(course.getCourseName());
			}
			if(course.getCredits()!=null) {
				courseModel.setCredits(course.getCredits());
			}
			if(course.getStartDate()!=null) {
				courseModel.setStartDate(Constants.covertDateToString(course.getStartDate()));
			}
			if(course.getEndDate()!=null) {
				courseModel.setEndDate(Constants.covertDateToString(course.getEndDate()));
			}
		}
		return courseModel;
	}
	
	@Override
	@Transactional
	public void deleteStudent(String id) {
		studentRepository.deleteById(Long.parseLong(id));
	}
	
	@Override
	@Transactional
	public void deleteCourse(String id) {
		courseRepository.deleteById(Long.parseLong(id));
	}
	
	@Override
	@Transactional
	public void registerCourse(String studentId, String courseId ) {
		Student student = studentRepository.findById(Long.parseLong(studentId)).get();
		Course course = courseRepository.findById(Long.parseLong(courseId)).get();
		boolean courseAllowed = false;
		if(student.getCourses()!=null && !student.getCourses().isEmpty()) {
			int maxCourseforStudent = student.getCourses().size();
			if(maxCourseforStudent < Constants.MAX_COURSES_FOR_STUDENT) {
				courseAllowed =true;
			}else {
				courseAllowed = false;
			}
		}else if(student.getCourses()==null || student.getCourses().isEmpty()) {
			courseAllowed = true;
		}
		int maxStudentsAllowed  =0;
		if(course.getStudents()!=null && !course.getStudents().isEmpty()) {
			 maxStudentsAllowed =  course.getStudents().size();
		}
		if(course.getStudents()==null || course.getStudents().isEmpty()) {
			courseAllowed = true;
		}
		if(maxStudentsAllowed < Constants.MAX_STUDENTS_FOR_COURSE) {
			courseAllowed = true;
		}else {
			courseAllowed = false;
		}
		if(courseAllowed) {
			student.addCourse(course);
		}	
	}
	
	@Override
	@Transactional
	public Set<StudentModel> getCourseWithStudents(String courseId) {
		List<Object[]> objectList = courseRepository.getCourseOfStudents(Long.parseLong(courseId));
		Set<StudentModel> studentModels = new HashSet<StudentModel>();
		if(objectList!=null && !objectList.isEmpty()) {
			for(Object[] object: objectList) {
				StudentModel studentModel = new StudentModel();
				if(object[0]!=null) {
					studentModel.setAddressLine1((String)object[1]);
				}
				if(object[2]!=null) {
					studentModel.setAge((int)object[2]);
				}
				if(object[3]!=null) {
					studentModel.setCity((String)object[3]);
				}
				if(object[4]!=null) {
					studentModel.setCountry((String)object[4]);
				}
				if(object[0]!=null) {
					studentModel.setId(String.valueOf((BigInteger)object[0]));
				}
				if(object[5]!=null) {
					studentModel.setName((String)object[5]);
				}
				if(object[6]!=null) {
					studentModel.setPincode((String)object[6]);
				}
				if(object[7]!=null) {
					studentModel.setState((String)object[7]);
				}
				if(object[8]!=null) {
					studentModel.setStreetNo((String)object[8]);
				}
				studentModels.add(studentModel);
			}
		}
		return studentModels;
	}
	
	@Override
	@Transactional
	public Set<CourseModel> getStudentsWithCourse(String studentId){
		List<Object[]> objects = studentRepository.getStudentsWithCourse(Long.parseLong(studentId));
		Set<CourseModel> courseModels = new HashSet<CourseModel>();
		if(objects!=null && !objects.isEmpty()) {
			for(Object[] object: objects) {
				CourseModel courseModel = new CourseModel();
				if(object[1]!=null) {
					courseModel.setCourseDuration((String)object[1]);
				}
				if(object[3]!=null) {
					courseModel.setCourseName((String)object[3]);
				}
				if(object[4]!=null) {
					courseModel.setCredits((String)object[4]);
				}
				if(object[2]!=null) {
					courseModel.setCourseId((String)object[2]);
				}
				if(object[6]!=null) {
					courseModel.setStartDate(String.valueOf((Date)object[6]));
				}
				if(object[5]!=null) {
					courseModel.setEndDate(String.valueOf((Date)object[5]));
				}
				if(object[0]!=null) {
					courseModel.setId(String.valueOf((BigInteger)object[0]));
				}
				courseModels.add(courseModel);
			}
		}
		return courseModels;
	}
	
	@Override
	@Transactional
	public Set<StudentModel> getStudentsWithOutCourses(){
		List<Object[]> objects = studentRepository.getStudentWithOutCourses();
		Set<StudentModel> studentModels = new HashSet<StudentModel>();
		if(objects!=null && !objects.isEmpty()) {
			for(Object[] object: objects) {
				StudentModel studentModel = new StudentModel();
				if(object[0]!=null) {
					studentModel.setAddressLine1((String)object[1]);
				}
				if(object[2]!=null) {
					studentModel.setAge((int)object[2]);
				}
				if(object[3]!=null) {
					studentModel.setCity((String)object[3]);
				}
				if(object[4]!=null) {
					studentModel.setCountry((String)object[4]);
				}
				if(object[0]!=null) {
					studentModel.setId(String.valueOf((BigInteger)object[0]));
				}
				if(object[5]!=null) {
					studentModel.setName((String)object[5]);
				}
				if(object[6]!=null) {
					studentModel.setPincode((String)object[6]);
				}
				if(object[7]!=null) {
					studentModel.setState((String)object[7]);
				}
				if(object[8]!=null) {
					studentModel.setStreetNo((String)object[8]);
				}
				studentModels.add(studentModel);
			}
		}
		return studentModels;
	}
	
	@Override
	@Transactional
	public Set<CourseModel> getCoursesWithOutStudents(){
		List<Object[]> objectList = courseRepository.getCoursesWithOutStudents();
		Set<CourseModel> courseModels = new HashSet<CourseModel>();
		if(objectList!=null && !objectList.isEmpty()) {
			for(Object[] object: objectList) {
				CourseModel courseModel = new CourseModel();
				if(object[1]!=null) {
					courseModel.setCourseDuration((String)object[1]);
				}
				if(object[3]!=null) {
					courseModel.setCourseName((String)object[3]);
				}
				if(object[4]!=null) {
					courseModel.setCredits((String)object[4]);
				}
				if(object[2]!=null) {
					courseModel.setCourseId((String)object[2]);
				}
				if(object[6]!=null) {
					courseModel.setStartDate(String.valueOf((Date)object[6]));
				}
				if(object[5]!=null) {
					courseModel.setEndDate(String.valueOf((Date)object[5]));
				}
				if(object[0]!=null) {
					courseModel.setId(String.valueOf((BigInteger)object[0]));
				}
				courseModels.add(courseModel);
			}
		}
		return courseModels;
	}
}
