package com.san.comp;

import java.util.HashMap;
import java.util.Map;

public final class FlipKart {
	private Couriar couriar;
	private float billamt = 0;

	public FlipKart(Couriar couriar2) {
		couriar = couriar2;
	}

	public String shopping(Map<String ,Float> list) {
		for (Map.Entry<String, Float> s: list.entrySet())
		{
			
		  float p=s.getValue();
			billamt = billamt + p;
		}
		double order= Math.random();
		couriar.delivery(order);

		
	
		return "FlipKart has devered your order with  billamt=" + billamt + ", iteams="
				 +list.keySet() +" " +list.values()+ "your order id is::"+order +"and will be delivered by" +couriar.toString();
	}
}
