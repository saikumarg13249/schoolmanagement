package com.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myschool.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query(value="select * from course where id in (select course_id from student_courses where student_id in (select id from student where id = :studentId))",nativeQuery=true)
	List<Object[]> getStudentsWithCourse(@Param("studentId") Long studentId);
	
	@Query(value="select * from student where id not in (select student_id from student_courses)",nativeQuery=true)
	List<Object[]> getStudentWithOutCourses();

}
