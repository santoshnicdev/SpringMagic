package com.san.service;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.san.dao.PersonDaoImple;
import com.san.model.Person;
@Service
@Transactional
public class PersonServiceImple implements PersonService {
	@Autowired
	PersonDaoImple perdao;

	
	public String addPerson(Person person) {
		String msg=perdao.addPerson(person);
		return null;
	}
	
	public List<Object[]> showPersons()
	{
		List<Object[]> l=perdao.listPersons();
		return  l;
	}
    
	public String removePersonI(long id)
	{
		Person p=perdao.getPersonById(id);
		perdao.removePerson(p.getId());
		
		return "Person with Object id"+id+"deleted sucessfully";
	}
	public Set<String> countryList() {
		Locale local[]=null;
		Set<String> countries = new TreeSet<String>();

        // Map ISO countries to custom country object
       local=Locale.getAvailableLocales();
        for (Locale l : local){

           if(!l.getDisplayCountry().equals(""))
           {
        	   countries.add(l.getDisplayCountry());
        	  
        	  // java.util.Collections.sort(  countries);
           }
          
	}
        return countries;

}
	@Override
	public boolean isExistbyId(long id) {
		Person p=perdao.getPersonById(id);
		if(p==null)
		return false;
		else 
			return true;
	}
	public Person getPersonWithId(long id){
		Person p=perdao.getPersonById(id);
		if(p==null)
		return null;
		else 
			return p;
		
	}

	public String editPerson(Person person) {
		perdao.updatePerson(person);
		return "hi";
	}
}
