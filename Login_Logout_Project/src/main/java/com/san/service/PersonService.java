package com.san.service;

import java.util.List;
import java.util.Set;

import com.san.model.Person;

public interface PersonService {
	
	public String addPerson(Person person);
	public Set<String > countryList();
	public List<Object[]> showPersons();
	public boolean isExistbyId(long id);
	public String removePersonI(long id);
	

}
