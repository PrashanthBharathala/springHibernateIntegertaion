package com.nt.dao;

import java.io.Serializable;
import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Student;


@Repository
public class StudentDaoImpl implements StudentDaoI {

	
	@Autowired
  private HibernateTemplate ht;
  
	
	@Transactional(propagation=Propagation.REQUIRED,value="hbtxmgr",readOnly=false)
	public void insertRecord() {
		Student s=new Student();
		s.setSid(102);
		s.setSname("shivani");
		s.setAddress("rajpet");
		s.setMarks(102.32f);
		s.setJdate(new Date(10, 05, 2017));
		ht.setCheckWriteOperations(false);
		Serializable se=ht.save(s);
		System.out.println("..............");
		System.out.println(se);
		
	}


	@Override
	public void updaterecord() {
		// TODO Auto-generated method stub
		
	}
	

}
