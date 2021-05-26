package com.qa.start.calculator;

public class Calculator {
	//Create a project that has four methods; addition, 
	//	subtraction, multiplication, and division:
	//All of these methods should take two numbers as parameters.
			
	public static int add(int x, int y) {
		return x+y;
	}
	public static double add(double x, double y) {
		return x+y;
	}
	public static int subtract(int x, int y) {
		return x-y;
	}
	public static double subtract(double x, double y) {
		return x-y;
	}
	public static int multiply(int x, int y) {
		return x*y;
	}
	public static double multiply(double x, double y) {
		return x*y;
	}
	public static double divide(double x, double y) {
		try {
			if(y == 0d)
				throw new ArithmeticException(); 
			return x/y;
		} catch(ArithmeticException e) {
			System.out.println("\nCannot divide by zero\n");
			return 0d;
		}
	}
}
