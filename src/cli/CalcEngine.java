package cli;

import java.util.ArrayList;

public class CalcEngine {

	ArrayList<String> operation;
	ArrayList<Double> digits;
	Character c;
	String express = "";
	
	public String proceed(String s) {
		
		setup(s);
		
		express = s;
		
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
		
		Bracket br = new Bracket();
		express = br.proceedBrakcet(source);
		
		operation = new ArrayList<String>();
		digits = new ArrayList<Double>();

		for (int i = 0; i < express.length(); i++) {
			Character c = express.charAt(i);
			switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
				operation.add(String.valueOf(c));
				break;
			}
		}

		String[] digit = express.split("(\\+|-|\\*|/)");
		
		
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