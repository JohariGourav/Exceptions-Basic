package com.cg.exceptions;

import java.util.Scanner;

//Factorial class to find factorial ( with Exception Handling)

class InvalidInputException extends Exception {

	public InvalidInputException(String message) {
		super(message);
	}
}

class FactorialException extends Exception {

	public FactorialException(String message) {
		super(message);
	}
}

// Factorial class to find factorial
public class Factorial {

	int getFactorial(int num) throws InvalidInputException, FactorialException {
		int factorial = 1;
		if (num < 2)
			throw new InvalidInputException("Number Should be greater than 2");
		else {
			for (int i = num; i > 1; i--) {
				factorial *= i;
			}
			if (factorial > Integer.MAX_VALUE) {
				throw new FactorialException("Result exceeds the highest value");
			} else {

				return factorial;
			}
		}
	}

	// main method
	public static void main(String[] args) {

		Factorial factorial = new Factorial();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number to find its Factorial");
		int number = scanner.nextInt();
		int answer;
		try {
			answer = factorial.getFactorial(number);
			System.out.println("The Factorial of number is: " + answer);

		} catch (InvalidInputException invalidInput) {
			invalidInput.printStackTrace();
		} catch (FactorialException factorialException) {
			factorialException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
