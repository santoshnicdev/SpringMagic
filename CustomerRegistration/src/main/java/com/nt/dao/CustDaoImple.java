package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.Customer;

@Repository
public class CustDaoImple implements CustDao {
	
	@Autowired
	private LocalSessionFactoryBean ls;
	private SessionFactory fact = null;
	private Session ses;
	private Transaction tx = null;
	
	

	@Transactional(propagation = Propagation.REQUIRED)
	public String saveCustomer(Customer cust) {
		System.out.println("CustDaoImple.saveCustomer()" + ls.getClass());
		fact = ls.getObject();
		ses = fact.getCurrentSession();

		ses.save(cust);

		return "saved";
	}

}
