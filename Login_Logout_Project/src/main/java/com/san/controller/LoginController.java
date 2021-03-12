package com.san.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import com.san.commons.EmailUtil;
import com.san.commons.PersonPDFView;
import com.san.commons.PersonXlsView;
import com.san.model.Login;
import com.san.model.Person;
import com.san.service.PersonServiceImple;
import com.san.validation.PersonValidator;

@Controller
public class LoginController {
	@Autowired
	PersonValidator validator;
	@Autowired
	PersonServiceImple serv;

	@GetMapping(value = { "/", "/loginBack" })
	public String hometest(Model model) {

		model.addAttribute("login", new Login());

		return "login";
	}

	@PostMapping("/loginurl")
	public String showresult(@ModelAttribute("login") Login login, Model model, HttpServletRequest ress) {
		HttpSession session = ress.getSession();
		session.setAttribute("email", login.getEmail());
		model.addAttribute("name", "Santosh Chouhan");
		System.out.println();
		return "success";

	}

	@GetMapping("/add")
	public String addPerson(Model model, @ModelAttribute("person") Person person, HttpSession ses) {
		person.setEmail((String) ses.getAttribute("email"));
		// model.addAttribute("person", new Person());

		return "add-form";

	}

	@ModelAttribute("ctr")
	public Set<String> showCoutry() {
		Set<String> ctr = serv.countryList();
		return ctr;
	}

	@PostMapping("/addsubmit")
	public String addsubmit(Model model, @ModelAttribute("person") Person person, BindingResult error) {
		if (validator.supports(person.getClass())) {
			System.out.println("LoginController.addsubmit()");
			validator.validate(person, error);
		}
		if (error.hasErrors()) {
			System.out.println("LoginController.has error");
			return "add-form";
		}

		String msg = serv.addPerson(person);
		System.out.println("LoginController.addsubmit()" + msg);

		return "success";
	}

	@GetMapping("/edit")
	public String updatedPerson(@RequestParam("id") long id, Model model, @ModelAttribute("person") Person person) {
		System.out.println("LoginController.updatedPerson()");
		person = serv.getPersonWithId(id);
		model.addAttribute("person", person);

		return "update";

	}

	@PostMapping("/edit")
	public String updatedPerson2(Model model, @ModelAttribute("person") Person person, BindingResult error) {
		if (validator.supports(person.getClass())) {
			System.out.println("LoginController.addsubmit()");
			validator.validate(person, error);
		}
		if (error.hasErrors()) {
			System.out.println("LoginController.has error");
			return "add-form";
		}

		String msg = serv.editPerson(person);

		return "redirect:view";

	}

	@GetMapping("/view")
	public String viewPerson(Model model) {
		List<Object[]> per = serv.showPersons();
		model.addAttribute("person", per);
		return "result";

	}

	@GetMapping("/delete")
	public String removePerson(@RequestParam("id") long id, Model model) {
		System.out.println("LoginController.removePerson()");
		String msg = serv.removePersonI(id);
		model.addAttribute("msg", msg);
		return "redirect:view";

	}
	@GetMapping("/excel")
	   public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new PersonXlsView());
		//fetch data from DB
		 List<Object[]> per = serv.showPersons();
		
				//send data to View class
     	m.addObject("person", per);
				return m;
		
	}
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView m = new ModelAndView();
		m.setView(new PersonPDFView());
		//fetch data from DB
		 List<Object[]> per = serv.showPersons();
		
				//send data to View class
    	m.addObject("person", per);
				return m;
	}
	
	public String emailPage(Document document,HttpServletRequest req,HttpServletResponse response)
	{
	  
	    
		File file=new File("E:/hi");
      EmailUtil util=new EmailUtil();
      System.out.println(document.isOpen()+"hello");
      util.sendEmail("santoshchauhan2086@gmail.com", "hello", "hello", null, null, (MultipartFile) file);
		return null;
	}

	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("PersonController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
