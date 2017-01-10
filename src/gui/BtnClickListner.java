package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BtnClickListner implements ActionListener {

	JLabel label;
	String value;

	public BtnClickListner() {
		super();
	}

	BtnClickListner(String value, JLabel label) {
		this.label = label;
		this.value = value;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("input v : " + value);
		label.setText(value);
	}
	
}
