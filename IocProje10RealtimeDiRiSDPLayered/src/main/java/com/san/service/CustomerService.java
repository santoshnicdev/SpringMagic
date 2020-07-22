package com.san.service;

import java.sql.SQLException;

import org.springframework.beans.BeanUtils;

import com.san.bo.CustomerBo;
import com.san.dao.CustomerDao;
import com.san.dto.CustomerDto;

public class CustomerService {
	CustomerDao custd;
	public CustomerService(CustomerDao custd)
	{
		this.custd=custd;
		
	}
	
	public String calculateSimpleIntrest(CustomerDto dto) throws SQLException
	{
		CustomerBo bo=new CustomerBo();
		float intrest=((dto.getPamt()*dto.getRate()*dto.getTime())/100.0f);
		BeanUtils.copyProperties(dto, bo);
		/*
		 * bo.setCno(dto.getCno()); bo.setName(dto.getName());
		 * bo.setCcity(dto.getCcity()); bo.setPamt(dto.getPamt());
		 */
		bo.setIntrest(intrest);
		int flag=custd.insert(bo);
		
		if (flag==0)
			return "customer registation failed with intrest"+intrest;
			
		else
			return "customer registation sucessfully with intrest"+intrest;
		
		
	}

}
