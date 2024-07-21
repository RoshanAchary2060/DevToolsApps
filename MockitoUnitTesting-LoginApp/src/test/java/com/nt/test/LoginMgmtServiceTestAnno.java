package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.nt.dao.ILoginDAO;
import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

class LoginMgmtServiceTestAnno {
	public LoginMgmtServiceTestAnno() {
		MockitoAnnotations.openMocks(this);
	}
	
	@InjectMocks
	private  LoginMgmtServiceImpl loginService;
	@Mock
	private ILoginDAO loginDAOMock;
	
//	@Spy
//	private ILoginDAO loginDAOSpy;


	// Test method
	@Test
	public void testLoginWithValidCredentials() {
		// Provide Stub(Temporary Functionalities) for DAO's authenticate() method
//		Mockito.when(loginDAOMock.authenticate("raja", "rani")).thenReturn(1);
		BDDMockito.given(loginDAOMock.authenticate("raja", "rani")).willReturn(1);
		// Unit Testing
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
