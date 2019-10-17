package kr.or.nextit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		double result = Calculator.sum(4, 5);
		assertTrue("9가 나와야함", result == 9);

	}

	@Test
	public void testSubtract() {
		double result = Calculator.subtract(5, 4);
		assertTrue(result == 1);
	}

	@Test
	public void testMultiply() {
		double result = Calculator.multiply(4, 5);
		assertTrue(result == 20);
	}

	@Test
	public void testDivide() {
		double result = Calculator.divide(5, 5);
		assertTrue(result == 1);
	}

}
