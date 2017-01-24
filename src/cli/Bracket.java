package cli;

import java.util.LinkedList;

public class Bracket {
	
	String express;
	LinkedList<Integer> startBracket = new LinkedList<Integer>();
	LinkedList<Integer> endBracket = new LinkedList<Integer>();
	
	public String proceedBrakcet(String s){
		
		express = s;

		while (true) {
			
			substractBracket(s);
			
			System.out.println(startBracket.toString());
			System.out.println(endBracket.toString());
			
			if (startBracket.isEmpty() && endBracket.isEmpty()){
				System.out.println("return");
				return s;	
			}

			String coreExp = s.substring(startBracket.getFirst() + 1, endBracket.getFirst());
			System.out.println("core exp : " + coreExp);
			
			CalcEngine ce = new CalcEngine();
			String resultBracket = ce.proceed(coreExp);

			StringBuffer sb = new StringBuffer();
			sb.append(s.substring(0, startBracket.getFirst()));
			sb.append(resultBracket);
			sb.append(s.substring(endBracket.getFirst() + 1));
			
			startBracket.removeFirst();
			endBracket.removeFirst();
			
			System.out.println("sb : " + sb);
			s = sb.toString();
		}
		
	}

	private void substractBracket(String s) {
		
		int startIndex = -1;
		int endIndex = -1;
		
		startBracket.clear();
		endBracket.clear();
		
		while(true){
		
			startIndex = -1;
			endIndex = -1;
			
			for(int i=0; i<s.length(); i++){

				if(s.charAt(i) == '('){
					if(!startBracket.contains(i)){
						startIndex = i;
					}
				}
			}
			
			if(startIndex != -1)
				startBracket.add(startIndex);
			else
				break;
			
			for(int i=startIndex; i<s.length(); i++){

				if(s.charAt(i) == ')'){
					if(!endBracket.contains(i)){
						endIndex = i;
						endBracket.add(i);
						break;
					}
				}
			}
			
			if(endIndex == -1)
				break;
			
		}
	}
	
	String make2ndExpress(String str){
		
		StringBuilder sb = new StringBuilder(str);
		
		if(sb.indexOf("(") == -1)
			return sb.toString();
		
		String tmpExp = sb.subSequence(startBracket.getFirst()+1, endBracket.getFirst()).toString();
		
		return tmpExp;
	}
	
}
