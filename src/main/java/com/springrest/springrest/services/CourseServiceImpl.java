package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	//List<Course> list;
	public CourseServiceImpl() {
		/*
		 * list=new ArrayList<>(); list.add(new Course(123, "Java Core Courses",
		 * "This is Core Java Course")); list.add(new Course(143, "React JS",
		 * "This is React JS Course"));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
		/* return list; */
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {

		/*
		 * Course c=null; for(Course course: list) { if(course.getId()==courseId) {
		 * c=course; break; } } return c;
		 */
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		/*
		 * list.add(course); return course;
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public List<Course> updateCourse(Course course) {
		/*
		 * for(Course c: list) { if(c.getId()==course.getId()) {
		 * list.set(list.indexOf(c), course); break; } } return list;
		 */
		courseDao.save(course);
		return courseDao.findAll();
	}

	@Override
	public void deleteCourse(long courseId) {
		/*
		 * for(Course c: list) { if(c.getId()==courseId) { list.remove(list.indexOf(c));
		 * break; } }
		 */
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}
}
