package com.san.comp;

import java.util.Arrays;
import java.util.Random;

public final class FlipKart {
	private Couriar couriar;
	private float billamt = 0;

	public FlipKart(Couriar couriar2) {
		couriar=couriar2;
	}

	public String shopping(String[] iteams, float[] prices) {
		for (float p : prices)
			billamt = billamt + p;
		double order= Math.random();
		couriar.delivery(order);

		return "FlipKart has devered your order with " + couriar.toString() + ", billamt=" + billamt + ", iteams="
				+ Arrays.toString(iteams) + ", prices=" + Arrays.toString(prices) + "your order id is::"+order;
	}

}
