package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BtnClickListner implements ActionListener {

	JLabel label;
	String key;
	String express= "";
	Express exp = new Express();

	public BtnClickListner() {
		super();
	}

	BtnClickListner(String key, JLabel label) {
		this.label = label;
		this.key = key;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		express= exp.appendExpress(key);
		System.out.println("key : " + key);
		System.out.println("express : " + express);
		
		label.setText(express);
	}
	
}

