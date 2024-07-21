package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import com.nt.service.CensusService;

class CensusServiceTest {
//	@Test
//	@RepeatedTest(value=10, name="execution of {displayName}-{{currentRepetition}/{totalRepetitions}}")
//	@DisplayName("testing data export")
//	public void testexportData() {
//		System.out.println("CensusServiceTest.testexportData()");
//		CensusService service = new CensusService();
//		assertEquals("data exported", service.exportData());
//	}

//	@ParameterizedTest
//	@ValueSource(ints = { 10, 21, 33, 45, 56, 99 })
//	public void testisOdd(int n) {
//		CensusService service = new CensusService();
//		assertTrue(service.isOdd(n));
//	}

//	@ParameterizedTest
//	@ValueSource(strings = { "raja", "rani" })
//	@EmptySource
//	public void testSayHello(String user) {
//		CensusService service = new CensusService();
//		assertEquals("hello : " + user, service.sayHello(user));
//	}
	
	@ParameterizedTest
//	@ValueSource(strings = {"","  ","k"})
//	@EmptySource
//	@NullSource
	@NullAndEmptySource
	public void testisEmpty(String data) {
		 CensusService service = new CensusService();
		 assertTrue(service.isEmpty(data));
	}
}
