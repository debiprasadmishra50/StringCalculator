package com.maven.project.demoproject;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String text) {
		if (text.isEmpty())
			return 0;

		else if (text.length() == 1)
			return toInt(text);

		else if (text.contains("//") || text.matches("[^0-9]") || text.contains("+")) {
			String[] numbers = text.split("\\D");
			return calculateSum(numbers);
		}

		else {
			String[] numbers = text.split(",|\\n");
			StringCalculator.checkForNegativeNumbers(numbers);
			return calculateSum(numbers);
		}
	}

	private static int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			if (number.isEmpty() || toInt(number) >= 1000)
				sum += 0;
			else
				sum += toInt(number);
		}
		return sum;
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static void checkForNegativeNumbers(String[] numbers) {
		List<Integer> negatives = new ArrayList<Integer>();
		int num;
		String message = "Negatives are Not Allowed : ";
		for (String number : numbers) {
			num = toInt(number);
			if (num < 0) {
				negatives.add(num);
				message += number + " ";
			}
		}

		if (negatives.size() > 0) {
//			System.out.println(message.trim());
			throw new RuntimeException(message.trim());
		}
	}
}
