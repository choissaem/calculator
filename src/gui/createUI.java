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

public class createUI {

	public void setInit(){
		
		JFrame frame = new JFrame("자바 다항 계산기");
		Container contentPane = frame.getContentPane();

		JLabel label = new JLabel("계산 결과", SwingConstants.CENTER);
		JTextField text = new JTextField();
		JButton button = new JButton("확인");

		frame.setLocation(600, 400);
		frame.setPreferredSize(new Dimension(300, 200));

		contentPane.add(label, BorderLayout.NORTH);
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);

		GridLayout digitGrid = new GridLayout(4, 3);
		JPanel digitPanel = new JPanel();
		digitPanel.setLayout(digitGrid);
		
		
		Map<String, JButton> btnMap = new HashMap<String, JButton>();
		
		final String digitBtnTitle[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "±", "0", "." };

		createBtn(digitPanel, btnMap, digitBtnTitle);

		GridLayout operGrid = new GridLayout(4, 1);
		JPanel operPanel = new JPanel();
		operPanel.setLayout(operGrid);
		
		final String operBtnTitle[] = {"+","-","*","/"};
		createBtn(operPanel, btnMap, operBtnTitle);

		JPanel p = new JPanel();
		p.add(digitPanel, BorderLayout.WEST);
		p.add(operPanel, BorderLayout.EAST);
		contentPane.add(p, BorderLayout.SOUTH);

		ActionListener listner = new ConfirmButtonActionListner(text, label);
//		ActionListener btnClicklistner = new BtnClickListner();
		ActionListener btnClicklistner;
		
		Iterator<String> valueIterator = btnMap.keySet().iterator();
		
		ArrayList<ActionListener> btnClickListnerList = new ArrayList<ActionListener>(); 
		
		while(valueIterator.hasNext()){
			String key = valueIterator.next();
			btnClicklistner = new BtnClickListner(key, label);
			btnMap.get(key).addActionListener(btnClicklistner);
//			addActionListener(btnClickListnerList.get(i));
//			btnClicklistner = new BtnClickListner(btnMap, value, label);
//			btnClicklistner = new BtnClickListner();
		}
		
		button.addActionListener(listner);
		
//		for(int i=0; i<btnClickListnerList.size(); i++){
//			for(String s:digitBtnTitle){
//				btnMap.get(s).addActionListener(btnClickListnerList.get(i));
//			}
//		}
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static void createBtn(JPanel panel, Map<String, JButton> btnMap, String[] btnTitle) {

		int btnLength = btnTitle.length;
		JButton[] btns = new JButton[btnLength];

		for (int i = 0; i < btnLength; i++) {
			btns[i] = new JButton(btnTitle[i]);
			btnMap.put(btnTitle[i], btns[i]);
			panel.add(btns[i]);
		}
	}
}
