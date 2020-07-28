package com.san.factory;

import com.san.comp.BlueDart;
import com.san.comp.Couriar;
import com.san.comp.FlipKart;

public class FlipKartFactory {
	static FlipKart flipkart;
	static Couriar couriar;
	public static FlipKart getInstance(String couriarname)
	{
		if (couriarname.equalsIgnoreCase("bluedart"))
		{
			couriar=new BlueDart();
			flipkart=new FlipKart(couriar);
			//return flipkart;
			
		}
		return flipkart;
	}
	public static FlipKart getFlipkart() {
		return flipkart;
	}
	public static void setFlipkart(FlipKart flipkart) {
		FlipKartFactory.flipkart = flipkart;
	}
	public static Couriar getCouriar() {
		return couriar;
	}
	public static void setCouriar(Couriar couriar) {
		FlipKartFactory.couriar = couriar;
	}
	

}
