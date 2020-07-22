package com.san.test;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.san.controller.CustomerController;
import com.san.vo.CustomerVO;

public class ApplicationTest {

	public static void main(String[] args) throws IOException {
		CustomerVO vo=new CustomerVO();
		ApplicationContext ctx=new FileSystemXmlApplicationContext("src\\main\\resources\\applicationContext.xml");
		CustomerController ctm=ctx.getBean("controller",CustomerController.class);
		try (Scanner scn = new Scanner(System.in)) {
			System.out.println("Enter Cno:");
			vo.setCno(scn.nextInt());
			System.out.println("Enter Name:");
			vo.setName(scn.next());
			System.out.println("Enter City:");
			vo.setCcity(scn.next());
			System.out.println("Enter Principalamt:");
			vo.setPamt(scn.nextFloat());
			System.out.println("Enter rate:");
			vo.setRate(scn.nextFloat());
			System.out.println("Enter time:");
			vo.setTime(scn.nextFloat());
		
		   String res=ctm.processCustomer(vo);
		   System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Closeable) ctx).close();
		
		
		
		
	}

}
