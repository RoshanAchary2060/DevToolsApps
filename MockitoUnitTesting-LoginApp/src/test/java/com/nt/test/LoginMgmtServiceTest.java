package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.dao.ILoginDAO;
import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

class LoginMgmtServiceTest {

	private static ILoginMgmtService loginService;
	private static ILoginDAO loginDAOMock;

	@BeforeAll
	public static void setupOnce() {
		// mock() generates InMemory class implementing ILoginDAO(I) having null method
		// definitions for authenticate()
		loginDAOMock = mock(ILoginDAO.class); // creating Mock/Fake/Dummy object
		System.out.println(loginDAOMock.getClass());
		// create Service class object
		loginService = new LoginMgmtServiceImpl(loginDAOMock);

	}

	@AfterAll
	public static void clearOnce() {
		loginDAOMock = null;
		loginService = null;
	}

	// Test method
	@Test
	public void testLoginWithValidCredentials() {
		// Provide Stub(Temporary Functionalities) for DAO's authenticate() method
		Mockito.when(loginDAOMock.authenticate("raja", "rani")).thenReturn(1);
		assertTrue(loginService.login("raja", "rani"));
	}

	// Test method
	@Test
	public void testLoginWithInValidCredentials() {
		// Provide Stub(Temporary Functionalities) for DAO's authenticate() method
		Mockito.when(loginDAOMock.authenticate("raja", "rani1")).thenReturn(0);
		assertFalse(loginService.login("raja", "rani1"));
	}

	// Test method
	@Test
	public void testLoginWithNoCredentials() {
		assertThrows(IllegalArgumentException.class, () -> {
			loginService.login("", "");
		});
	}

	@Test
	public void testRegisterWithSpy() {
		ILoginDAO loginDAOSpy = Mockito.spy(ILoginDAO.class);
		ILoginMgmtService loginService = new LoginMgmtServiceImpl(loginDAOSpy);
		loginService.registerUser("raja", "admin");
		loginService.registerUser("Suresh", "visitor");
		loginService.registerUser("jani", "");

		Mockito.verify(loginDAOSpy, Mockito.times(1)).addUser("raja", "admin");
		Mockito.verify(loginDAOSpy, Mockito.times(0)).addUser("suresh", "visitor");
		Mockito.verify(loginDAOSpy, Mockito.never()).addUser("jani", "");
		
	}
}
