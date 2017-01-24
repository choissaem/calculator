package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BtnClickListner implements ActionListener {

	JLabel label;
	JTextField text;
	String key;
	
	String express= "";
	Express exp = new Express();

	public BtnClickListner() {
		super();
	}

	BtnClickListner(String key, JLabel label, JTextField text) {
		this.text = text;
		this.label = label;
		this.key = key;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		express= text.getText();
		switch(key){
		
		case "±":
			express = changePlusMinus(express);
			text.setText(express);
			break;
		default:		
			express= exp.appendExpress(express, key);
			text.setText(express);
		}
	}

	private String changePlusMinus(String exp) {
		
		StringBuilder sb = new StringBuilder(exp);
		System.out.println("sb : " + sb);
		String digits[] = exp.split("(\\+|-|\\*|/|\\(|\\))");
		
		int expLength = exp.length() - 1;
		int digitLength = digits.length-1;
		
		String num = digits[digitLength];
		String oppNumber = String.valueOf(Integer.parseInt(digits[digitLength]) * -1);
		
		int numLength = num.length();
		
//		System.out.println(digits[expLength]);
//		System.out.println(oppNumber);
		System.out.println(exp.substring(expLength - numLength + 1));
		
		sb.delete(expLength - numLength + 1, expLength+1);
		sb.append("(");
		sb.append(oppNumber);
		sb.append(")");
		System.out.println(sb);
		
		return sb.toString();
	}
	
}

