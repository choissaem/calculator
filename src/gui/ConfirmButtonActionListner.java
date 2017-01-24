package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import cli.CalcEngine;

class ConfirmButtonActionListner implements ActionListener{

	JTextField text;
	JLabel label;
	
	ConfirmButtonActionListner(JTextField text, JLabel label) {
		this.text = text;
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String express = text.getText();

		CalcEngine ce = new CalcEngine();
		express = ce.proceed(express);

		label.setText("계산 결과 : " + express);
	}
	
}