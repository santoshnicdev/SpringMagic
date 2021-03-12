package com.san.dao;

import java.util.List;

import com.san.model.Person;

public interface PesronDao {
	public String addPerson(Person p);
	public void updatePerson(Person p);
	public List<Object[]> listPersons();
	public Person getPersonById(long id);
	public void removePerson(long id);

}
