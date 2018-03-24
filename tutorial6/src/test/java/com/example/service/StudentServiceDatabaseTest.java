package com.example.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.StudentMapper;
import com.example.model.StudentModel;

public class StudentServiceDatabaseTest {
	private StudentService studentService = new StudentServiceDatabase();
	
	@Mock
	private StudentMapper studentMapper;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.studentService = new StudentServiceDatabase(this.studentMapper);
	}
	
	@Test
	public void selectStudent() {
		//Given
		StudentModel studentModel = new StudentModel ("1506737823","Chanek",3.5);
		StudentModel check = new StudentModel("1506737823","Chanek",3.5);
		BDDMockito.given(studentMapper.selectStudent("1506737823")).willReturn(studentModel);
		
		//When
		StudentModel test = studentService.selectStudent("1506737823");
		
		//Then
		assertThat(test,notNullValue()); //Check if not null
		assertThat(test,equalTo(check)); //Check if same
	}
	
//	@Test
//	public void selectAllStudent() {
//		//Given
//		List<StudentModel>studentModels = new ArrayList<>();
//		StudentModel studentModel = new StudentModel ("1506737823","Chanek",3.5);
//		studentModels.add(studentModel);
//		
//		List<StudentModel> checks = new ArrayList<>();
//		StudentModel check = new StudentModel("1506737823","Chanek",3.5);
//		checks.add(check);
//		BDDMockito.given(studentMapper.selectAllStudents()).willReturn(studentModels);
//		
//		//When
//		List<StudentModel>test = studentService.selectAllStudents();
//		
//		//Then
//		assertThat(test,notNullValue());//Check if not null
//		assertThat(test.isEmpty(),equalTo(false));//Check if not null;
//		assertThat(test.size(),equalTo(1)); //Check if size same
//		assertThat(test,equalTo(checks)); //Check if content same
//		
//	}
	
//	@Test
//	public void addStudent() {
//		//Given
//		StudentModel studentModel = new StudentModel ("1506737823","Chanek",3.5);
//		StudentModel check = new StudentModel("1506737823","Chanek",3.5);
//		BDDMockito.given(studentService.addStudent(studentModel)).willReturn(true);
//		
//		//When
//		boolean test = studentService.addStudent(studentModel);
//		
//		//Then
//		BDDMockito.then(studentMapper).should().addStudent(check);
//		assertThat(test,equalTo(true)); //Check if same
//	}
//	
//	@Test
//	public void updateStudent() {
//		//Given
//		StudentModel studentModel = new StudentModel ("1506737823","Chanek",3.5);
//		StudentModel check = new StudentModel ("1506737823","Chanek",3.5);
//		BDDMockito.given(studentService.updateStudent(studentModel)).willReturn(true);
//		
//		//When
//		boolean test = studentService.updateStudent(studentModel);
//		
//		//Then
//		BDDMockito.then(studentMapper).should().updateStudent(check);
//		assertThat (test,equalTo(true)); //Check if same
//	}
//	
//	@Test
//	public void deleteStudent() {
//		//Given
//		StudentModel studentModel = new StudentModel ("1506737823","Chanek",3.5);
//		StudentModel check = new StudentModel("1506737823","Chanek",3.5);
//		BDDMockito.given(studentService.deleteStudent(studentModel.getNpm())).willReturn(true);
//		
//		//When
//		boolean test = studentService.deleteStudent(studentModel.getNpm());
//		
//		//Then
//		BDDMockito.then(studentMapper).should().deleteStudent(check.getNpm());
//		assertThat(test,equalTo(true));
//	}
}
