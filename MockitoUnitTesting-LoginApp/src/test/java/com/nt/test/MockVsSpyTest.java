package com.nt.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockVsSpyTest {

	@Test
	public void testList() {
		List<String> listMock = Mockito.mock(ArrayList.class); // Mock
		List<String> listSpy = Mockito.spy(new ArrayList()); // Spy
//		List<String> listSpy = Mockito.spy(ArrayList.class); // same
		listMock.add("table");
		Mockito.when(listMock.size()).thenReturn(10); // stub on Mock
		listSpy.add("table");
		when(listSpy.size()).thenReturn(10); // stub on Spy Object
		System.out.println(listMock.size()+ ", "+listSpy.size());
		
	}
}
