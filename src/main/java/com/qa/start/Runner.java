package com.qa.start;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.qa.start.calculator.Calculator;

public class Runner {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Create a menu to ask the user which of the four methods
		// they wish to use, then take the numbers as user input
		// for the operation and output the result back to the user.
		try {
			String calcMethod = getCalcMethod();
			double input1 = getUserDoubleInput();
			double input2 = getUserDoubleInput();
			double answer = calcAnswer(calcMethod, input1, input2);

			if (calcMethod != "div" && input2 != 0d)
				System.out.println(input1 + " " + calcMethod + " " + input2 + " equals " + answer);
		} finally {
			scan.close();
		}
	}

	private static String getCalcMethod() {
		String question = "Would you like to add, divide, subtract or divide?";
		String answer = "";

		while (true) {
			System.out.println(question);
			System.out.print("Enter your choice: ");
			try {
				answer = scan.nextLine();
				answer = answer.replaceAll("\\s", "");

				if (answer.length() > 3)
					answer = answer.substring(0, 3);

				switch (answer) {
				case "add":
					return "add";
				case "sub":
					return "subtract";
				case "mul":
					return "multiply";
				case "div":
					return "divide";
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("\nPlease enter add, divide, subtract, or multiply\n");
			}
		}
	}

	private static double getUserDoubleInput() {
		String question = "\nPlease Enter a number: ";

		while (true) {
			System.out.print(question);
			try {
				return scan.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Input");
				scan.nextLine();
			}
		}
	}

	private static double calcAnswer(String method, double x, double y) {
		double result = 0d;
		switch (method) {
		case "add":
			result = Calculator.add(x, y);
			break;
		case "divide":
			result = Calculator.divide(x, y);
			break;
		case "multiply":
			result = Calculator.multiply(x, y);
			break;
		case "subtract":
			result = Calculator.subtract(x, y);
			break;
		}
		return result;
	}
}
