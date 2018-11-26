package com.nt.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;


@Entity

@Table(name="student1444")
public class Student {

	@Id
	@GenericGenerator(name="g1",strategy="increment")
	@GeneratedValue(generator="g1")
	@Column(name="studentid")
	private  int sid;
	
	@Column(name="studentname",length=10)
	private String sname;
	@Column(name="marks",length=10,precision=2)
	private float marks;
	@Column(name="address",length=10)
	@Type(type="string")
	private String address;
	@Temporal(TemporalType.DATE)
	private Date jdate;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJdate() {
		return jdate;
	}
	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}



}
