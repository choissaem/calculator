package gui;

public class Express {
	
	StringBuilder express = new StringBuilder("");
	String token;

	public String appendExpress(String exp, String token){
		
		express.append(exp);
		
		return express.append(token).toString();
	}

}
