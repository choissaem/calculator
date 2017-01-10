package gui;

public class Express {
	
	static StringBuilder express = new StringBuilder("");
	String token;

	public String appendExpress(String token){
		return express.append(token).toString();
	}

}
