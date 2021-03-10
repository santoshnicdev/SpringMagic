package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {
	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		Session ses = null;
		if (factory != null)
			ses = factory.openSession();
		System.out.println("HibernateUtil.getSession()" + factory.getClass());
		return ses;
	}

	public void closeSession(Session ses) {
		if (ses != null)
			ses.close();
	}

	public void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
