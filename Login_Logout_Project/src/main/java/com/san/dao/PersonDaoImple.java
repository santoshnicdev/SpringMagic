package com.san.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.san.model.Person;


public class PersonDaoImple implements PesronDao {
	
	private SessionFactory sessionFactory;
	
	/*
	 * @Autowired private HibernateTransactionManager tx;
	 */

	
	  public void setSessionFactory(SessionFactory sf)
	  { this.sessionFactory = sf; 
	  }
	
	public String addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("PersonDaoImple.addPerson():::"+p);
		Date d=p.getDob();
		p.setDob(d);
     
		session.persist(p);
		//session.getTransaction().commit();
		

		return "sucessfully added";

		// TODO Auto-generated method stub

	}

	public void updatePerson(Person p) {
	
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
		 
	

	}

	public List<Object[]> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		String query="select id,name,fathername,dob ,email,country,city from com.san.model.Person ";
	    Query  q =session.createQuery(query);
	    List<Object[]> rows =q.list();
	    //System.out.println(listresult.getClass()+"hello");
		rows.forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+"   ");
			}//for
			System.out.println();
		});
		
		
		return rows;
	}
	@Override
	public Person getPersonById(long id) {
		Person p=null;
		try
		{
			
		
		Session session = this.sessionFactory.getCurrentSession();
		
		 p=session.load(Person.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("person not found");
		}
		return p;
	}

	public void removePerson(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p=session.get(Person.class, id);
		session.delete(p);
		
	}

	

	

	

}
