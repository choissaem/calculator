package cli;

import java.util.ArrayList;

public class calc {

	static ArrayList<String> operation = new ArrayList<String>();
	static ArrayList<Double> digits = new ArrayList<Double>();
	Character c;

	public static void main(String[] args) {

		System.out.println("식을 입력하세요");
		// Scanner input = new Scanner(System.in);
		// String s = input.nextLine();
		String s = "10+23*3-2+5";
		// System.out.println(s);
		setup(s);

		System.out.println(s);
		proceed();
	}

	public static void proceed() {
		int i = 0;
		while (i < operation.size()) {

			switch (operation.get(i)) {
			case "*":
			case "/":
				Double r = oper(digits.get(i), digits.get(i + 1), operation.get(i));
				operation.remove(i);
				digits.remove(i);
				digits.set(i, r);
				System.out.println(digits.toString());
				System.out.println(operation.toString());
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
				System.out.println(digits.toString());
				System.out.println(operation.toString());
				break;
			}
		}

		System.out.println("= " + digits.get(0));
	}

	public static double setup(String source) {

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

	public static double oper(Double a, Double b, String o) {

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