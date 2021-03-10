package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.CustDao;
import com.nt.model.Customer;
@Service
public class CustomerServiceImple implements ICustomerMgmtService {
	@Autowired
	CustDao custdao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(Customer cust) {
		
		return custdao.saveCustomer(cust);
	}

}
