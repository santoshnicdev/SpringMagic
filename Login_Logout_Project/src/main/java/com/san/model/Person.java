package com.san.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "person_table")
public class Person {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	private Long id;
	@Column(name = "email", length = 200)

	private String email;
	@Column(name = "pass", length = 255)

	private String password;
	@Column(name = "name", length = 20)

	private String name;
	@Column(name = "fname", length = 20)

	private String fathername;
	//@Temporal(TemporalType.DATE)
	@Column(name = "dob")
    @DateTimeFormat(pattern = "mm-dd-yyyy")
	private Date dob;

	@Column(name="country")
	private String country;
	@Column(name = "state", length = 20)

	private String state;

	private String city;
	@Column(name = "address", length = 20)

	private String add;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", fathername="
				+ fathername + ", dob=" + dob + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", add=" + add + "]";
	}

}
