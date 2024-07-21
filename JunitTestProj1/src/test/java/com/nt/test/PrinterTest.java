package com.nt.test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.nt.service.Printer;

class PrinterTest {

	@Test
	public void testSingleton() {
		Printer p1 = Printer.getInstance();
		Printer p2 = Printer.getInstance();
		if (p1 == null || p2 == null) {
			fail("p1, p2 references must not be null");
		}
		assertSame(p1, p2);
		assertNotNull(p1);
		assertNotNull(p2);
	}

}
