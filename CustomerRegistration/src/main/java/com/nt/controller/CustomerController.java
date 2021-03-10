package com.nt.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;
import com.nt.util.EmailUtil;
import com.nt.validation.CustomerValidator;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerMgmtService service;
	@Autowired
	private CustomerValidator validator;
	@Autowired
	EmailUtil util;

	@GetMapping("/customer")
	public String showForm(@ModelAttribute("cust") Customer cust) { // initial phase request (form launching)
		cust.setCadd("hyd");
		// return lvn
		return "customer_form";
	}

	@PostMapping("/customer")
	public String registerCustomer(Map<String, Object> map, @ModelAttribute("cust") Customer cust,
			BindingResult errors,RedirectAttributes rd,final @RequestParam CommonsMultipartFile attachFileObj) { // Post back request (form submission)

		// pefrom server side form validations only when client side form valdations are
		// not done
		if (cust.getVflag().equalsIgnoreCase("no")) {
			// perform form validations..
			if (validator.supports(cust.getClass()))
				validator.validate(cust, errors);

			if (errors.hasErrors()) // if form validation errors are there
				return "customer_form"; // lvn
		} // if

		// Application Logic errors
		if (cust.getBillAmt() > 100000) {
			errors.rejectValue("billAmt", "billAmt.big");
			return "customer_form";
		}

		// use service
		String resultMsg = service.register(cust);
		Boolean flag=util.sendEmail("santoshsati09@gmail.com", "hi", "how are you", null, null,attachFileObj);
		if(flag)
			System.out.println("Sent Sucessfully");
		else
			System.out.println("failed to email");
		// keep result in model attribute
		//map.put("resultMsg", resultMsg);
		// return LVN
		rd.addFlashAttribute("resultMsg",resultMsg);
		return "redirect:show";
	}
	@GetMapping("/show")
	public String showResult()
	{
		return  "result";
	}

}