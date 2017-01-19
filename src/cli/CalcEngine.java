package cli;

import java.util.ArrayList;

public class CalcEngine {

	ArrayList<String> operation;
	ArrayList<Double> digits;
	Character c;
	String express = "";
	
	public String proceed() {
		
		int i = 0;
		while (i < operation.size()) {

			switch (operation.get(i)) {
			
			case "*":
			case "/":
				Double r = oper(digits.get(i), digits.get(i + 1), operation.get(i));
				operation.remove(i);
				digits.remove(i);
				digits.set(i, r);
				i=0;
				
				System.out.println(operation.toString());
				System.out.println(digits.toString());
				break;
			}
			i++;
			
		}

		i = 0;
		while (operation.size() > 0) {

			switch (operation.get(i)) {
			case "+":
			case "-":
				Double r = oper(digits.get(i), digits.get(i + 1), operation.get(i));
				operation.remove(i);
				digits.remove(i);
				digits.set(i, r);
				System.out.println(operation.toString());
				System.out.println(digits.toString());
				break;
			}
		}

		express = digits.get(0).toString();
//		System.out.println("= " + digits.get(0));
		return express;
	}

	public double setup(String source) {
		
		operation = new ArrayList<String>();
		digits = new ArrayList<Double>();

		for (int i = 0; i < source.length(); i++) {
			Character c = source.charAt(i);
			switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
				operation.add(String.valueOf(c));
				break;
			}
		}

		String[] digit = source.split("(\\+|-|\\*|/)");

		for (String s : digit) {
			digits.add(Double.valueOf(s));
		}

		System.out.println(operation.toString());
		System.out.println(digits.toString());

		return 0;
	}

	public double oper(Double a, Double b, String o) {

		Double result = 0.0;

		switch (o) {
		case "+":
			result = (a + b);
			break;
		case "-":
			result = (a - b);
			break;
		case "*":
			result = (a * b);
			break;
		case "/":
			result = (a / b);
			break;
		}

		return result;
	}

}