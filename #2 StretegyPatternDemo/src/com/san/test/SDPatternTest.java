package com.san.test;

import com.san.comp.FlipKart;
import com.san.factory.FlipKartFactory;

public class SDPatternTest {

	public static void main(String[] args) {
		//FlipKartFactory factort;
		FlipKart flip=FlipKartFactory.getInstance("bluedart");
		System.out.println(flip.shopping(new String[] {"umbrella"}, new float[]{500}));
		
	}

}
