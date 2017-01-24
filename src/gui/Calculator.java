package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {

	final String digitBtnTitle[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "±", "0", ".", "(", ")"};
	final String operBtnTitle[] = {"+","-","*","/"};
	
	JFrame frame;
	Container contentPane;
	JLabel label; 
	JTextField text; 
	JButton btnConfirm; 
	Map<String, JButton> btnMap = new HashMap<String, JButton>();
	JPanel digitPanel = new JPanel();
	JPanel operPanel = new JPanel();
	
	public void run(){
		
		setFrame();
		setLayoutTop();
		setDigitPanel();
		setOperPanel();
		setPanel();
		connectLisnter();
		frameCloseSet();
	}

	private void frameCloseSet() {
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void connectLisnter() {
		ActionListener listner = new ConfirmButtonActionListner(text, label);
		btnConfirm.addActionListener(listner);

		ActionListener btnClicklistner;
		Iterator<String> iterator = btnMap.keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			btnClicklistner = new BtnClickListner(key, label, text);
			btnMap.get(key).addActionListener(btnClicklistner);
		}
	}

	private void setPanel() {
		JPanel p = new JPanel();
		p.add(digitPanel, BorderLayout.WEST);
		p.add(operPanel, BorderLayout.EAST);
		contentPane.add(p, BorderLayout.SOUTH);
	}

	private void setFrame() {
		frame = new JFrame("자바 다항 계산기");
		label = new JLabel("계산 결과", SwingConstants.CENTER);
		text = new JTextField();
		btnConfirm = new JButton("=");

		frame.setLocation(600, 400);
		frame.setPreferredSize(new Dimension(250, 230));
	}

	private void setOperPanel() {
		GridLayout operGrid = new GridLayout(5, 1);
		operPanel.setLayout(operGrid);
		createBtn(operPanel, btnMap, operBtnTitle);
	}

	private void setDigitPanel() {
		GridLayout digitGrid = new GridLayout(5, 3);
		digitPanel.setLayout(digitGrid);
		createBtn(digitPanel, btnMap, digitBtnTitle);
	}

	private void setLayoutTop() {
		contentPane = frame.getContentPane();
		contentPane.add(label, BorderLayout.NORTH);
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(btnConfirm, BorderLayout.EAST);
	}
	
	private void createBtn(JPanel panel, Map<String, JButton> btnMap, String[] btnTitle) {

		int btnLength = btnTitle.length;
		JButton[] btns = new JButton[btnLength];

		for (int i = 0; i < btnLength; i++) {
			btns[i] = new JButton(btnTitle[i]);
			btnMap.put(btnTitle[i], btns[i]);
			panel.add(btns[i]);
		}
	}
}
