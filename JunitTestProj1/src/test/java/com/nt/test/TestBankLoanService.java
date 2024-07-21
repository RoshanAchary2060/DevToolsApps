package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import com.nt.service.BankLoanService;

@DisplayName("TestingBankLoanServiceClass")
//@TestMethodOrder(value = OrderAnnotation.class) // best
//@TestMethodOrder(value = MethodName.class)
//@TestMethodOrder(MethodName.class)
@TestMethodOrder(Random.class)
class TestBankLoanService {
	private static BankLoanService service;

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("TestBankLoanService.setUpOnce()");
		service = new BankLoanService();
	}

//	@BeforeEach
//	public void setUp() {
//		System.out.println("TestBankLoanService.setUp()");
//		service = new BankLoanService();
//	}

	@Test
	@DisplayName("Testing with small numbers")
//	@Order(10)
	@Tag("dev")
	@Tag("uat")
	public void testcaluSimpleInterestAmountWithSmallNumber(TestInfo info) {
		System.out.println("TestBankLoanService.testcaluSimpleInterestAmountWithSmallNumber()");
		System.out.println(info.getDisplayName()+ ", "+info.getTestClass().get().getName()+", "+info.getTestMethod().get().getName());
		float actual = service.calcSimpleInterestAmount(100000, 2, 12);
		float expected = 24000;
		assertEquals(expected, actual, "may be results are not matching");
	}

	@Test
//	@Order(2)
	@DisplayName("Testing with big numbers")
	@Tag("test")
	public void testcaluSimpleInterestAmountWithBigNumber() {
		System.out.println("TestBankLoanService.testcaluSimpleInterestAmountWithBigNumber()");
		float actual = service.calcSimpleInterestAmount(10000000, 2, 12);

		float expected = 2400000.12f;
		assertEquals(expected, actual, 0.5, "may be results are not matching");
		// 0.5 is delta value -> the difference value that is allowed in the result
	}

	@Test
//	@Order(5)
	@Tag("uat")
	@DisplayName("Testing with invalid Inputs")
	public void testcaluSimpleInterestAmountWithInvalidInputs() {
		System.out.println("TestBankLoanService.testcaluSimpleInterestAmountWithInvalidInputs()");
//		service.calcSimpleInterestAmount(0, 12, 0); // it will give error

		// this is to prevent error
		assertThrows(IllegalArgumentException.class, () -> {
			service.calcSimpleInterestAmount(0, 0, 0);
		}, "may be exception raised is not matching");
	}

	@Test
	@Disabled
//	@Order(0)
	@Tag("prod")
	@DisplayName("Testing with timeout period")
	public void testcaluSimpleInterestAmountWithTimer() {
		System.out.println("TestBankLoanService.testcaluSimpleInterestAmountWithTimer()");
		BankLoanService service = new BankLoanService();
		assertTimeout(Duration.ofMillis(20000), () -> {
			service.calcSimpleInterestAmount(10000000, 2, 12);
		});
	}

	@Test
//	@Order(-10)
	@Tag("dev")
	@DisplayName("Testing for no exception")
	public void testcaluSimpleInterestAmountForNoExceptions() {
		System.out.println("TestBankLoanService.testcaluSimpleInterestAmountForNoExceptions()");
		assertDoesNotThrow(() -> {
			service.calcSimpleInterestAmount(100000, 2, 12);
		});
	}

//	@AfterEach
//	public void clear() {
//		System.out.println("TestBankLoanService.clear()");
//		service = null;
//	}

	@AfterAll
	public static void clearOnce() {
		System.out.println("TestBankLoanService.clearOnce()");
		service = null;
	}
}
