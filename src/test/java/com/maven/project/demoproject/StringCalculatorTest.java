package com.maven.project.demoproject;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void checkForEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void returnIntegerWhenInputIsOne() {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void returnSumOfNumbersSeparatedByComma() {
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
	public void checkForUnknownAmountOfNumbers() {
		assertEquals(10, StringCalculator.add("1,2,3,4"));
	}
	
	@Test
	public void handleNewLinesBetweenNumbers() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void supportCustomDelimeter() {
		assertEquals(3, StringCalculator.add("//;\\n1;2"));
	}
	
	@Test()
	public void checkForNegativeNumbers() {
		try {
			StringCalculator.add("1,2,-3");
		} catch (RuntimeException e) {
			assertEquals("Negatives are Not Allowed : -3", e.getMessage());
		}
	}

	@Test()
	public void checkForMultipleNegativeNumbers() {
		try{
			StringCalculator.add("-1,-2,-3");
		} catch (RuntimeException e) {
			assertEquals("Negatives are Not Allowed : -1 -2 -3", e.getMessage());
		}
	}
	
	@Test
	public void ignoreNumberBiggerThanThousand() {
		assertEquals(2, StringCalculator.add("2+1000"));
	}
	
	@Test
	public void delimeterOfAnyLength() {
		assertEquals(6, StringCalculator.add("//[***]\\n1***2***3"));
	}

	@Test
	public void withMultipleDelimeters() {
		assertEquals(6, StringCalculator.add("//[*][%]\\n1*2%3"));
	}
	
	@Test
	public void multipleDelimeterWithLengthLongerThanOneChar() {
		assertEquals(6, StringCalculator.add("//[**][%%]\\n1**2%%3"));
	}
	
	
	
}
