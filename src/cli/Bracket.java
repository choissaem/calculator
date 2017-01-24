package cli;

import java.util.LinkedList;

public class Bracket {
	
	String express;
	LinkedList<Integer> startBracket = new LinkedList<Integer>();
	LinkedList<Integer> endBracket = new LinkedList<Integer>();
	
	public String proceedBrakcet(String s){
		
		express = s;

		while (true) {
			
			String subtractedBracketExp = substractBracket(s);
			
//			System.out.println("s : " + s);
//			System.out.println("subtracted Bracket Exp : " + subtractedBracketExp);
			
			if (subtractedBracketExp.equals(s)){
				return subtractedBracketExp;
			}

			String coreExp = s.substring(startBracket.getLast() + 1, endBracket.getFirst());

			CalcEngine ce = new CalcEngine();
			String resultBracket = ce.proceed(coreExp);

			StringBuffer sb = new StringBuffer();
			sb.append(s.substring(0, startBracket.getLast()));
			sb.append(resultBracket);
			sb.append(s.substring(endBracket.getFirst() + 1));
			
			startBracket.clear();
			endBracket.clear();
			
			s = sb.toString();
		}
		
	}

	private String substractBracket(String s) {
		
		StringBuffer sb = new StringBuffer(s);
		
		if(sb.indexOf("(") == -1)
			return sb.toString();
		
		for(int i=0; i<s.length(); i++){

			if(s.charAt(i) == '(')
				startBracket.add(i);
			
			if(s.charAt(i) == ')')
				endBracket.add(i);
		}
		
//		System.out.println("startBracket : " + startBracket );
//		System.out.println("endBracket : " + endBracket );

		String tmpExp = sb.subSequence(startBracket.getFirst()+1, endBracket.getLast()).toString();
		return tmpExp;
	}
	
}
