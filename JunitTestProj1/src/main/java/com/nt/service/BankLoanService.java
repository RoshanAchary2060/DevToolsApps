package com.nt.service;

public class BankLoanService {

	public float calcSimpleInterestAmount(float pamt, float rate, float time) {
//		System.out.println("BankLoanService.calcSimpleInterestAmount()");
		if (pamt <= 0 || rate <= 0 || time <= 0) {
			throw new IllegalArgumentException("Invalid inputs!");
		}
//		try {
//			Thread.sleep(10000);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		return pamt * rate * time / 100;
	}
}
