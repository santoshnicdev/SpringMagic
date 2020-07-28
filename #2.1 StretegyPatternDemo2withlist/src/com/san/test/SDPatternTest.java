package com.san.test;

import java.util.HashMap;
import java.util.Map;

import com.san.comp.FlipKart;
import com.san.factory.FlipKartFactory;

public class SDPatternTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//FlipKartFactory factort;
		/*
		 * Map<String,Float> sum=new HashMap<>(); sum.put("Chair",500.0f);
		 * sum.put("table", 456.76f); Map<Integer,HashMap<String, Float>> list=new
		 * HashMap<>(); list.put(3, new HashMap<>() {{ put("something", 6.0f);}});
		 * System.out.println(list);
		 */
		
		
		
		
		
		Map<String,Float> hm=new HashMap<String,Float>();
		hm.put("umbrella",  500.50f);
		hm.put("condom",  300.0f);
		FlipKart flip=FlipKartFactory.getinstance();
		System.out.println(flip.shopping(hm));
		
	}

	

}
