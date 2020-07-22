package com.san.dto;

public class CustomerDto {
	Integer cno;
	String name;
	String ccity;
	Float pamt;

	float rate;
	float time;

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

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

}
