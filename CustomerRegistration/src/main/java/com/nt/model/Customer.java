package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "cust_table")
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	//private int cno;  //auto generated
	private String cname;
	private  String cadd;
	private  Float billAmt;
	@Transient
	private  String vflag="no";

}