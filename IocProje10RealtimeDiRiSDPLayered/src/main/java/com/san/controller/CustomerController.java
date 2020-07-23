package com.san.controller;

import java.sql.SQLException;

import org.springframework.beans.BeanUtils;

import com.san.dto.CustomerDto;
import com.san.service.CustomerService;
import com.san.vo.CustomerVO;

public class CustomerController {
CustomerDto dto=new CustomerDto();
CustomerService service;
CustomerController(CustomerService service)
{
	this.service=service;
}

public String processCustomer(CustomerVO vo) throws Exception
{
	
	  dto.setCno(Integer.valueOf(vo.getCno())); 
	  dto.setName(vo.getName());
	  dto.setCcity(vo.getCcity());
	  dto.setPamt(Float.valueOf(vo.getPamt()));
	  dto.setRate(Float.valueOf(vo.getRate())); 
	  dto.setTime(Float.valueOf(vo.getTime()));
	 
	//BeanUtils.copyProperties(vo, dto);
	String result=service.calculateSimpleIntrest(dto);
	return result;
	
	
}


}
