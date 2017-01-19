package cli;

public class RunCalc {

	static CalcEngine ce;
	public static void main(String[] args) {
		
		ce = new CalcEngine();

		System.out.print("식을 입력하세요 : ");
		// Scanner input = new Scanner(System.in);
		// String s = input.nextLine();
		String s = "10+23*2*3-2+5";
		System.out.println(s);
		
		ce.setup(s);
		System.out.println(ce.proceed());
	}

}
