package br.com.aimbra.inspection.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CnpjValidatorTest {
	
	CnpjValidator cnpjValidator;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void isCNPJTest() {
		String cnpjValid = "14956069000106";
		cnpjValidator = new CnpjValidator(cnpjValid);
		assertEquals(true, cnpjValidator.isCNPJ());
	}
	
	@Test
	void isCNPJWithEspecialCharacterTest() {
		String cnpjValid = "14.956.069/0001-06";
		cnpjValidator = new CnpjValidator(cnpjValid);
		assertEquals(true, cnpjValidator.isCNPJ());
	}
	
	@Test
	void isCNPJWithEspecialCharacterAndSpaceTest() {
		String cnpjValid = " 14.956.069/0001-06 ";
		cnpjValidator = new CnpjValidator(cnpjValid);
		assertEquals(true, cnpjValidator.isCNPJ());
	}
	
	@Test
	void isCNPJisNull() {
		String cnpjValid = null;
		cnpjValidator = new CnpjValidator(cnpjValid);
		assertNotEquals(true, cnpjValidator.isCNPJ());
	}
	
	@Test
	void isNotCNPJTest() {
		String cnpjValid = "14956069000101";
		cnpjValidator = new CnpjValidator(cnpjValid);
		assertNotEquals(true, cnpjValidator.isCNPJ());
	}

}
