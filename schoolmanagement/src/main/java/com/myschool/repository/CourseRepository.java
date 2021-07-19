package com.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myschool.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query(value="select * from student where id in (select student_id from student_courses where course_id in (select id from course where id = :courseId))",nativeQuery=true)
	List<Object[]> getCourseOfStudents(@Param("courseId") Long courseId);
	
	@Query(value="select * from course where id not in (select course_id from student_courses)",nativeQuery=true)
	List<Object[]> getCoursesWithOutStudents();

}
