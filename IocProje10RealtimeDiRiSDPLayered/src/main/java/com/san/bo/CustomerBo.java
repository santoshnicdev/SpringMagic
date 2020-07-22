package com.san.bo;

import java.io.Serializable;

public class CustomerBo implements Serializable {
	Integer cno;
	String name;
	String ccity;
	Float pamt;
	Float intrest;
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public Float getPamt() {
		return pamt;
	}
	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}
	public Float getIntrest() {
		return intrest;
	}
	public void setIntrest(Float intrest) {
		this.intrest = intrest;
	}
	

}
