package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

class ConfirmButtonActionListner implements ActionListener{

	JTextField text;
	JLabel label;
	
	ConfirmButtonActionListner(JTextField text, JLabel label) {
		this.text = text;
		this.label = label;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String name = text.getText();
		label.setText("hello " + name);
		
	}
	
}