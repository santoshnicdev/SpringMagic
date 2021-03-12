package com.san.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.san.model.Person;
@Component
public class PersonValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		System.out.println("CustomerValidator.supports()");
		return clazz.isAssignableFrom(Person.class);
	}

	public void validate(Object target, Errors errors) {
		Person pers=(Person) target;
	    System.out.println("PersonValidator.validate()");
		if(pers.getName()==null || pers.getName().isEmpty())  //required rule
			errors.rejectValue("name","pname.required");
         if(pers.getName().length()<=5)
         {
        	 errors.rejectValue("name","pname.minlen");
         }
	}

}
